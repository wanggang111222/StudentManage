package com.student.service;

import java.util.List;

import com.student.dao.CourseDAO;
import com.student.model.Course;

public class CourseService
{
	private CourseDAO courseDAO;
	
	public CourseDAO getCourseDAO()
	{
		return courseDAO;
	}

	public void setCourseDAO(CourseDAO courseDAO)
	{
		this.courseDAO = courseDAO;
	}
	
	public List<Course> findallcourse()
	{
		return courseDAO.findAll();
	}
	
	public void deletecourse(String id)
	{
		courseDAO.delete(id);
	}
	
	public void updatecourse(String cid,String cname,String credit,String property)
	{
		courseDAO.update(cid, cname, credit, property);
	}
	
	public void addcourse(String cid,String cname,String credit,String property)
	{
		courseDAO.add(cid, cname, credit, property);
	}
	
	public List<Course> findbyid(String cid)
	{
		return courseDAO.findbyCID(cid);
	}
	
	public List<Course> findbyname(String cname)
	{
		return courseDAO.findbyName(cname);
	}
	
	public List<Course> findbyproperty(String property)
	{
		return courseDAO.findbyProperty(property);
	}
	
}
