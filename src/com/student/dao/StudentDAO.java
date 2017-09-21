package com.student.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.student.model.Cla;
import com.student.model.Student;

public class StudentDAO 
{
	private SessionFactory sessionFactory;
	private Cla cla;
	private Student stu;
	
	public Cla getCla()
	{
		return cla;
	}

	public void setCla(Cla cla)
	{
		this.cla = cla;
	}

	public Student getStu()
	{
		return stu;
	}

	public void setStu(Student stu)
	{
		this.stu = stu;
	}
	
	public SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public Student validateUser(String username, String password)
	{
		List<Student> stu = null;
		try
		{
			String sql = "select * from Student where sid ='" + username + "' and password = '"
						+ password + "'";
			Session session = sessionFactory.getCurrentSession();
			stu = session.createSQLQuery(sql).addEntity(Student.class).list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if (stu.size() > 0)
		{
			Student student = (Student) stu.get(0);
			return student;
		} else
			return null;	
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Student> findAll()
	{
		List<Student> stu = null;
		try
		{
			String sql = "select * from Student";
			Session session = sessionFactory.getCurrentSession();
			stu = session.createSQLQuery(sql).addEntity(Student.class).list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return stu;
	}

	@SuppressWarnings({ "unchecked" })
	@Transactional
	public List<Student> findbyID(String SID)
	{
		List<Student> stu = null;
		try
		{
			String sql = "select * from Student where sid = '"+SID+"'";
			Session session = sessionFactory.getCurrentSession();
			stu = session.createSQLQuery(sql).addEntity(Student.class).list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return stu;
	}
	
	@SuppressWarnings({ "unchecked" })
	@Transactional
	public List<Student> findbyName(String sname)
	{
		List<Student> stu = null;
		try
		{
			String sql = "select * from Student where sname = '"+sname+"'";
			Session session = sessionFactory.getCurrentSession();
			stu = session.createSQLQuery(sql).addEntity(Student.class).list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return stu;
	}
	
	@SuppressWarnings({ "unchecked" })
	@Transactional
	public List<Student> findbyCla(String id)
	{
		List<Student> stu = null;
		try
		{
			String sql = "select * from Student where id = '"+id+"'";
			Session session = sessionFactory.getCurrentSession();
			stu = session.createSQLQuery(sql).addEntity(Student.class).list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return stu;
	}
	
	@Transactional
	public void delete(String sid)
	{
		try
		{
			Student stu = new Student();
			stu.setSid(sid);
			Session session = sessionFactory.getCurrentSession();
			session.delete(stu);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Transactional
	public void add(String sid,String sname,String sex,String birthday,String password,String tel,String address,String id)
	{
		Session session = sessionFactory.getCurrentSession();
		
		Student stu = new Student();
		Cla cla = new Cla();
		cla.setId(id);
		
		stu.setSid(sid);
		stu.setSname(sname);
		stu.setSex(sex);
		stu.setBirthday(birthday);
		stu.setPassword(password);
		stu.setTel(tel);
		stu.setAddress(address);
		stu.setCla(cla);
		try
		{
			session.save(stu);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Transactional
	public void update(String sid,String sname,String sex,String birthday,String password,String tel,String address,String id)
	{
		
		Session session = sessionFactory.getCurrentSession();
		
		Cla cla = new Cla();
		cla.setId(id);
		
		Student stu = new Student();
		stu.setSid(sid);
		stu.setSname(sname);
		stu.setSex(sex);
		stu.setBirthday(birthday);
		stu.setPassword(password);
		stu.setTel(tel);
		stu.setAddress(address);
		stu.setCla(cla);
		try
		{
			session.update(stu);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
