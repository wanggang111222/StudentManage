package com.student.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.student.model.Course;
import com.student.model.Score;
import com.student.model.Student;
import com.student.service.CourseService;
import com.student.service.ScoreService;
import com.student.service.StudentService;

public class ScoreAction extends ActionSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected ScoreService scoreService;
	protected CourseService courseService;
	
	public CourseService getCourseService()
	{
		return courseService;
	}

	public void setCourseService(CourseService courseService)
	{
		this.courseService = courseService;
	}
	
	public ScoreService getScoreService()
	{
		return scoreService;
	}

	public void setScoreService(ScoreService scoreService)
	{
		this.scoreService = scoreService;
	}

	protected StudentService studentService;
	
	public StudentService getStudentService()
	{
		return studentService;
	}
	
	public void setStudentService(StudentService studentService)
	{
		this.studentService = studentService;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String resultlist() throws Exception
	{
		List students = studentService.findallstu(); 
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("student", students);
		return SUCCESS;
	}
	public void addscore() throws Exception
	{
		HttpServletRequest request1 = ServletActionContext.getRequest();
		request1.setCharacterEncoding("utf-8");
		String sid = new String(request1.getParameter("sid").getBytes("ISO-8859-1"),"UTF-8");
		String cid = new String(request1.getParameter("cid").getBytes("ISO-8859-1"),"UTF-8");
		String score = new String(request1.getParameter("score").getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(sid);
		System.out.println(cid);
		System.out.println(score);
		scoreService.addscore(cid, sid, score); 
	}
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String studentsco() throws Exception
	{
		HttpServletRequest request1 = ServletActionContext.getRequest();
		request1.setCharacterEncoding("utf-8");
		String sort = new String(request1.getParameter("sort").getBytes("ISO-8859-1"),"UTF-8");
		String menuname = new String(request1.getParameter("menuname").getBytes("ISO-8859-1"),"UTF-8");
		if(sort.equals("sid"))
		{
			
			List score = scoreService.findbysid(menuname);
			Map request = (Map) ActionContext.getContext().get("request");
			request.put("score", score);
		}
		else if(sort.equals("sname"))
		{
			List stu = studentService.findbyname(menuname); 
			Student stus = (Student) stu.get(0);
			String str = stus.getSid();
			List score = scoreService.findbysid(str);
			Map request = (Map) ActionContext.getContext().get("request");
			request.put("score", score);
		}
		return SUCCESS;
	}
	
	@SuppressWarnings("rawtypes")
	public void stuperson() throws Exception
	{
		HttpServletRequest request1 = ServletActionContext.getRequest();
		request1.setCharacterEncoding("utf-8");
		String sid = new String(request1.getParameter("sid").getBytes("ISO-8859-1"),"UTF-8");
		List score = scoreService.findbysid(sid.trim());
		int credit = 0;
		int sum = 0;
		String arrCF ="";
		for(int i=0;i<score.size();i++)
		{
			Score sco = new Score();
			sco = (Score) score.get(i);
			if(Integer.parseInt(sco.getScore())<60)
			{
				sum = sum+1;
			}
			else
			{
				Course course = sco.getId().getCourse();
				System.out.println(course.getCredit());
				credit = credit+Integer.parseInt(course.getCredit());				
			}
		}
		arrCF = sum +","+credit;
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().getWriter().write(arrCF);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String courlist() throws Exception
	{
		List course = courseService.findallcourse(); 
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("course", course);
		return SUCCESS;
	}
	@SuppressWarnings("rawtypes")
	public void coudetail() throws Exception
	{
		HttpServletRequest request1 = ServletActionContext.getRequest();
		request1.setCharacterEncoding("utf-8");
		String cid = new String(request1.getParameter("cid").getBytes("ISO-8859-1"),"UTF-8");
		List score = scoreService.findbycid(cid.trim());
		int sum = 0;
		String arrCF ="";
		for(int i=0;i<score.size();i++)
		{
			Score sco = new Score();
			sco = (Score) score.get(i);
			sum = sum+Integer.parseInt(sco.getScore());		
		}
		sum = sum/score.size();
		
		List score1 = scoreService.max(cid);
		
		List score2 = scoreService.min(cid);
		
		arrCF = sum +","+score1.get(0)+","+score2.get(0);
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().getWriter().write(arrCF);
	}
}
