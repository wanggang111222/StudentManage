package com.student.service;

import java.util.List;

import com.student.dao.StudentDAO;
import com.student.model.Student;

public class StudentService
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
	
	public List<Student> findallstu()
	{
		return studentDAO.findAll();
	}
	
	public void deletestu(String id)
	{
		studentDAO.delete(id);
	}
	
	public void updatestu(String sid,String sname,String sex,String birthday,String password,String tel,String address,String id)
	{
		studentDAO.update(sid,sname,sex,birthday,password,tel,address,id);
	}
	
	public void addstu(String sid,String sname,String sex,String birthday,String password,String tel,String address,String id)
	{
		studentDAO.add(sid, sname, sex, birthday, password, tel, address, id);
	}
	
	public List<Student> findbyid(String sid)
	{
		return studentDAO.findbyID(sid);
	}
	
	public List<Student> findbyname(String sname)
	{
		return studentDAO.findbyName(sname);
	}
	
	public List<Student> findbycla(String id)
	{
		return studentDAO.findbyCla(id);
	}
}
