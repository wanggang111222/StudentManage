package com.student.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.student.model.Cla;
import com.student.model.Student;
import com.student.service.ClassService;
import com.student.service.StudentService;

public class StudentAction extends ActionSupport
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected StudentService studentService;
	protected ClassService classService;
	protected Student stu;
	protected Cla cla;
	
	public Cla getCla()
	{
		return cla;
	}

	public void setCla(Cla cla)
	{
		this.cla = cla;
	}

	public ClassService getClassService()
	{
		return classService;
	}

	public void setClassService(ClassService classService)
	{
		this.classService = classService;
	}

	
	public StudentService getStudentService()
	{
		return studentService;
	}
	
	public void setStudentService(StudentService studentService)
	{
		this.studentService = studentService;
	}
	
	public Student getStu()
	{
		return stu;
	}
	
	public void setStu(Student stu)
	{
		this.stu = stu;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String stulist() throws Exception
	{
		List students = studentService.findallstu(); 
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("student", students);
		return SUCCESS;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String deletestu() throws Exception
	{
		HttpServletRequest request1 = ServletActionContext.getRequest();
		request1.setCharacterEncoding("utf-8");
		String checkTnum = new String(request1.getParameter("checkTnum").getBytes("ISO-8859-1"),"UTF-8");
		String [] checkedNums = checkTnum.split(",");
		for(int i=0;i<checkedNums.length;i++)
		{
			studentService.deletestu(checkedNums[i]);
		}
		List students = studentService.findallstu(); 
		Map request = (Map) ActionContext.getContext().get("request");
		request.remove("student");
		request.put("student", students);
		return SUCCESS;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String addstu() throws Exception
	{
		HttpServletRequest request1 = ServletActionContext.getRequest();
		request1.setCharacterEncoding("utf-8");
		String sid = new String(request1.getParameter("sid").getBytes("ISO-8859-1"),"UTF-8");
		String sname = new String(request1.getParameter("sname").getBytes("ISO-8859-1"),"UTF-8");
		String sex = new String(request1.getParameter("sex").getBytes("ISO-8859-1"),"UTF-8");
		String birthday = new String(request1.getParameter("birthday").getBytes("ISO-8859-1"),"UTF-8");
		String password = new String(request1.getParameter("password").getBytes("ISO-8859-1"),"UTF-8");
		String tel = new String(request1.getParameter("tel").getBytes("ISO-8859-1"),"UTF-8");
		String address = new String(request1.getParameter("address").getBytes("ISO-8859-1"),"UTF-8");
		String id = new String(request1.getParameter("id").getBytes("ISO-8859-1"),"UTF-8");
		studentService.addstu(sid, sname, sex, birthday, password, tel, address, id);
		List students = studentService.findallstu(); 
		Map request = (Map) ActionContext.getContext().get("request");
		request.remove("student");
		request.put("student", students);
		return SUCCESS;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String searchstu() throws Exception
	{
		HttpServletRequest request1 = ServletActionContext.getRequest();
		request1.setCharacterEncoding("utf-8");
		String sort = new String(request1.getParameter("sort").getBytes("ISO-8859-1"),"UTF-8");
		String menuname = new String(request1.getParameter("menuname").getBytes("ISO-8859-1"),"UTF-8");
		if(sort.equals("sid"))
		{
			
			List students = studentService.findbyid(menuname);
			Map request = (Map) ActionContext.getContext().get("request");
			request.remove("student");
			request.put("student", students);
		}
		else if(sort.equals("sname"))
		{
			List students = studentService.findbyname(menuname); 
			Map request = (Map) ActionContext.getContext().get("request");
			request.remove("student");
			request.put("student", students);
		}
		else if(sort.equals("id"))
		{	
			List cla = classService.findbyname(menuname);
			if(cla.size()!=0)
			{
				Cla clas = (Cla) cla.get(0);
				System.out.println(clas.getId());
				List students = studentService.findbycla(clas.getId()); 
				Map request = (Map) ActionContext.getContext().get("request");
				request.remove("student");
				request.put("student", students);
			}
		}
		return SUCCESS;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String updatestu() throws Exception
	{
		HttpServletRequest request1 = ServletActionContext.getRequest();
		request1.setCharacterEncoding("utf-8");
		String sid = new String(request1.getParameter("sid").getBytes("ISO-8859-1"),"UTF-8");
		String sname = new String(request1.getParameter("sname").getBytes("ISO-8859-1"),"UTF-8");
		String sex = new String(request1.getParameter("sex").getBytes("ISO-8859-1"),"UTF-8");
		String birthday = new String(request1.getParameter("birthday").getBytes("ISO-8859-1"),"UTF-8");
		String password = new String(request1.getParameter("password").getBytes("ISO-8859-1"),"UTF-8");
		String tel = new String(request1.getParameter("tel").getBytes("ISO-8859-1"),"UTF-8");
		String address = new String(request1.getParameter("address").getBytes("ISO-8859-1"),"UTF-8");
		String id = new String(request1.getParameter("id").getBytes("ISO-8859-1"),"UTF-8");
		studentService.updatestu(sid, sname, sex, birthday, password, tel, address, id);
		List students = studentService.findallstu(); 
		Map request = (Map) ActionContext.getContext().get("request");
		request.remove("student");
		request.put("student", students);
		return SUCCESS;
	}
}
