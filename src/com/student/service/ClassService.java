package com.student.service;

import java.util.List;

import com.student.dao.ClassDAO;
import com.student.model.Cla;

public class ClassService
{
	private ClassDAO classDAO;

	public ClassDAO getClassDAO()
	{
		return classDAO;
	}

	public void setClassDAO(ClassDAO classDAO)
	{
		this.classDAO = classDAO;
	}
	
	public List<Cla> findallcla()
	{
		return classDAO.findAll();
	}
	
	public void deletecla(String id)
	{
		classDAO.delete(id);
	}
	
	public void updatecla(String cid,String cname)
	{
		classDAO.update(cid, cname);
	}
	
	public void addcla(String cid,String cname)
	{
		classDAO.add(cid, cname);
	}
	
	public List<Cla> findbyid(String cid)
	{
		return classDAO.findbyID(cid);
	}
	
	public List<Cla> findbyname(String cname)
	{
		return classDAO.findbyName(cname);
	}
}
