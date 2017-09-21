package com.student.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.student.model.Course;
import com.student.model.Score;
import com.student.model.ScoreId;
import com.student.model.Student;

public class ScoreDAO
{
	private SessionFactory sessionFactory;
	private Score score;
	
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
	public List<Score> findAll()
	{
		List<Score> sco= null;
		try
		{
			String sql = "select * from Score";
			Session session = sessionFactory.getCurrentSession();
			sco = session.createSQLQuery(sql).addEntity(Score.class).list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return sco;
	}
	@SuppressWarnings({ "unchecked" })
	@Transactional
	public List<Score> findbyCID(String CID)
	{
		List<Score> sco = null;
		try
		{
			String sql = "select * from Score where cid = '"+CID+"'";
			Session session = sessionFactory.getCurrentSession();
			sco = session.createSQLQuery(sql).addEntity(Score.class).list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return sco;
	}
	
	@SuppressWarnings({ "unchecked" })
	@Transactional
	public List<Score> findbySid(String sid)
	{
		List<Score> sco = null;
		try
		{
			String sql = "select * from Score where sid = '"+sid+"'";
			Session session = sessionFactory.getCurrentSession();
			sco = session.createSQLQuery(sql).addEntity(Score.class).list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return sco;
	}
	
	@SuppressWarnings({ "rawtypes" })
	@Transactional
	public List max(String cid)
	{
		List sco = null;
		try
		{
			String sql = "select max(score) from Score where cid = '"+cid+"'";
			Session session = sessionFactory.getCurrentSession();
			sco = session.createQuery(sql).list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return sco;
	}
	
	@SuppressWarnings({"rawtypes" })
	@Transactional
	public List min(String cid)
	{
		List sco = null;
		try
		{
			String sql = "select min(score) from Score where cid = '"+cid+"'";
			Session session = sessionFactory.getCurrentSession();
			sco = session.createQuery(sql).list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return sco;
	}
	
	@Transactional
	public void add(String sid,String cid,String score)
	{
		Session session = sessionFactory.getCurrentSession();
		
		Student stu = new Student();
		stu.setSid(sid);
		
		Course cou = new Course();
		cou.setCid(cid);
		
		ScoreId scoid = new ScoreId();
		scoid.setCourse(cou);
		scoid.setStudent(stu);
		
		Score sco = new Score();
		sco.setScore(score);
		sco.setId(scoid);
		try
		{
			session.save(sco);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public Score getScore()
	{
		return score;
	}

	public void setScore(Score score)
	{
		this.score = score;
	}
}
