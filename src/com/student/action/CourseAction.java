package com.student.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.student.model.Course;
import com.student.service.CourseService;

public class CourseAction extends ActionSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected CourseService courseService;
	
	public CourseService getCourseService()
	{
		return courseService;
	}

	public void setCourseService(CourseService courseService)
	{
		this.courseService = courseService;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String courselist() throws Exception
	{
		List course = courseService.findallcourse(); 
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("course", course);
		return SUCCESS;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String deletecourse() throws Exception
	{
		HttpServletRequest request1 = ServletActionContext.getRequest();
		request1.setCharacterEncoding("utf-8");
		String checkTnum = new String(request1.getParameter("checkTnum").getBytes("ISO-8859-1"),"UTF-8");
		String [] checkedNums = checkTnum.split(",");
		for(int i=0;i<checkedNums.length;i++)
		{
			System.out.println(checkedNums[i]);
			courseService.deletecourse(checkedNums[i]);
		}
		List course = courseService.findallcourse(); 
		Map request = (Map) ActionContext.getContext().get("request");
		request.remove("course");
		request.put("course", course);
		return SUCCESS;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String addcourse() throws Exception
	{
		HttpServletRequest request1 = ServletActionContext.getRequest();
		request1.setCharacterEncoding("utf-8");
		String cid = new String(request1.getParameter("cid").getBytes("ISO-8859-1"),"UTF-8");
		String cname = new String(request1.getParameter("cname").getBytes("ISO-8859-1"),"UTF-8");
		String credit = new String(request1.getParameter("credit").getBytes("ISO-8859-1"),"UTF-8");
		String property = new String(request1.getParameter("property").getBytes("ISO-8859-1"),"UTF-8");
		courseService.addcourse(cid, cname, credit, property);
		List course = courseService.findallcourse(); 
		Map request = (Map) ActionContext.getContext().get("request");
		request.remove("course");
		request.put("course", course);
		return SUCCESS;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String searchcourse() throws Exception
	{
		HttpServletRequest request1 = ServletActionContext.getRequest();
		request1.setCharacterEncoding("utf-8");
		String sort = new String(request1.getParameter("sort").getBytes("ISO-8859-1"),"UTF-8");
		String menuname = new String(request1.getParameter("menuname").getBytes("ISO-8859-1"),"UTF-8");
		if(sort.equals("cid"))
		{
			List course = courseService.findbyid(menuname);
			Map request = (Map) ActionContext.getContext().get("request");
			request.remove("course");
			request.put("course", course);
		}
		else if(sort.equals("cname"))
		{
			List course = courseService.findbyname(menuname); 
			Map request = (Map) ActionContext.getContext().get("request");
			request.remove("course");
			request.put("course", course);
		}
		else if(sort.equals("property"))
		{
			List course = courseService.findbyproperty(menuname); 
			Map request = (Map) ActionContext.getContext().get("request");
			request.remove("course");
			request.put("course", course);
		}
		return SUCCESS;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String savecourse() throws Exception
	{
		HttpServletRequest request1 = ServletActionContext.getRequest();
		request1.setCharacterEncoding("utf-8");
		String cid = new String(request1.getParameter("cid").getBytes("ISO-8859-1"),"UTF-8");
		String cname = new String(request1.getParameter("cname").getBytes("ISO-8859-1"),"UTF-8");
		String credit = new String(request1.getParameter("credit").getBytes("ISO-8859-1"),"UTF-8");
		String property = new String(request1.getParameter("property").getBytes("ISO-8859-1"),"UTF-8");
		courseService.updatecourse(cid, cname, credit, property);
		List course = courseService.findallcourse(); 
		Map request = (Map) ActionContext.getContext().get("request");
		request.remove("course");
		request.put("course", course);
		return SUCCESS;
	}
	
	public void showcourse() throws Exception
	{
		List<Course> course = courseService.findallcourse();
		String arrCF="";
		for(int i=0;i<course.size();i++)
		{
			arrCF +=course.get(i).getCid()+","+course.get(i).getCname()+",";
		}
		arrCF = arrCF.substring(0,arrCF.length()-1);
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().getWriter().write(arrCF);
	}
}
