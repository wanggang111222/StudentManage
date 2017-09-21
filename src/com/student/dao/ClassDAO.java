package com.student.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.student.model.Cla;

public class ClassDAO
{
	private SessionFactory sessionFactory;
	private Cla cla;
	
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
	public List<Cla> findAll()
	{
		List<Cla> cla = null;
		try
		{
			String sql = "select * from Cla";
			Session session = sessionFactory.getCurrentSession();
			cla = session.createSQLQuery(sql).addEntity(Cla.class).list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return cla;
	}
	
	@SuppressWarnings({ "unchecked" })
	@Transactional
	public List<Cla> findbyID(String ID)
	{
		List<Cla> cla = null;
		try
		{
			String sql = "select * from Cla where id = '"+ID+"'";
			Session session = sessionFactory.getCurrentSession();
			cla = session.createSQLQuery(sql).addEntity(Cla.class).list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return cla;
	}
	
	@SuppressWarnings({ "unchecked" })
	@Transactional
	public List<Cla> findbyName(String name)
	{
		List<Cla> cla = null;
		try
		{
			String sql = "select * from Cla where name = '"+name+"'";
			Session session = sessionFactory.getCurrentSession();
			cla = session.createSQLQuery(sql).addEntity(Cla.class).list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return cla;
	}
	@Transactional
	public void delete(String id)
	{
		try
		{
			Cla cla = new Cla();
			cla.setId(id);
			Session session = sessionFactory.getCurrentSession();
			session.delete(cla);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Transactional
	public void add(String cid,String cname)
	{
		Cla cla = new Cla();
		Session session = sessionFactory.getCurrentSession();
		cla.setId(cid);
		cla.setName(cname);
		try
		{
			session.save(cla);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Transactional
	public void update(String cid,String cname)
	{
		Cla cla = new Cla();
		Session session = sessionFactory.getCurrentSession();
		cla.setId(cid);
		cla.setName(cname);
		try
		{
			session.update(cla);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public Cla getCla()
	{
		return cla;
	}

	public void setCla(Cla cla)
	{
		this.cla = cla;
	}
}
