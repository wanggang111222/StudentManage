package com.student.service;

import com.student.dao.StudentDAO;
import com.student.model.Student;

public class LoginService
{
	private StudentDAO studentDAO;
	
	public StudentDAO getStudentDAO()
	{
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO)
	{
		this.studentDAO = studentDAO;
	}
	
	public Student validateUser(String username, String password) {
		return studentDAO.validateUser(username, password);
	}
}
