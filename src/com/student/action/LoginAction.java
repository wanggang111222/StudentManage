package com.student.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.student.model.Student;
import com.student.service.LoginService;

public class LoginAction extends ActionSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Student student;
	protected LoginService loginService;

	public Student getStudent()
	{
		return student;
	}

	public void setStudent(Student student)
	{
		this.student = student;
	}

	public LoginService getLoginService()
	{
		return loginService;
	}

	public void setLoginService(LoginService loginService)
	{
		this.loginService = loginService;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String login() throws Exception
	{

		Student s= loginService.validateUser(student.getSid(), student.getPassword());
		if (s != null)
		{
			Map session = ActionContext.getContext().getSession();
			session.put("user", s);
			return SUCCESS;
		} else
		{
			return ERROR;
		}
	}
}
