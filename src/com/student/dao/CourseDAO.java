package com.student.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.student.model.Course;

public class CourseDAO
{
	private SessionFactory sessionFactory;
	private Course course;
	
	public SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	public Course getCourse()
	{
		return course;
	}

	public void setCourse(Course course)
	{
		this.course = course;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Course> findAll()
	{
		List<Course> course = null;
		try
		{
			String sql = "select * from Course";
			Session session = sessionFactory.getCurrentSession();
			course = session.createSQLQuery(sql).addEntity(Course.class).list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return course;
	}
	
	@SuppressWarnings({ "unchecked" })
	@Transactional
	public List<Course> findbyCID(String CID)
	{
		List<Course> course = null;
		try
		{
			String sql = "select * from Course where cid = '"+CID+"'";
			Session session = sessionFactory.getCurrentSession();
			course = session.createSQLQuery(sql).addEntity(Course.class).list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return course;
	}
	
	@SuppressWarnings({ "unchecked" })
	@Transactional
	public List<Course> findbyName(String name)
	{
		List<Course> course = null;
		try
		{
			String sql = "select * from Course where cname = '"+name+"'";
			Session session = sessionFactory.getCurrentSession();
			course = session.createSQLQuery(sql).addEntity(Course.class).list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return course;
	}
	
	@SuppressWarnings({ "unchecked" })
	@Transactional
	public List<Course> findbyProperty(String property)
	{
		List<Course> course = null;
		try
		{
			String sql = "select * from Course where property = '"+property+"'";
			Session session = sessionFactory.getCurrentSession();
			course = session.createSQLQuery(sql).addEntity(Course.class).list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return course;
	}
	
	@Transactional
	public void delete(String id)
	{
		try
		{
			Course course = new Course();
			course.setCid(id);
			Session session = sessionFactory.getCurrentSession();
			session.delete(course);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Transactional
	public void add(String cid,String cname,String credit,String property)
	{
		Course course = new Course();
		Session session = sessionFactory.getCurrentSession();
		course.setCid(cid);
		course.setCname(cname);
		course.setCredit(credit);
		course.setProperty(property);
		try
		{
			session.save(course);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Transactional
	public void update(String cid,String cname,String credit,String property)
	{
		Course course = new Course();
		Session session = sessionFactory.getCurrentSession();
		course.setCid(cid);
		course.setCname(cname);
		course.setCredit(credit);
		course.setProperty(property);
		try
		{
			session.update(course);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
