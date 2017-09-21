package com.student.service;

import java.util.List;

import com.student.dao.ScoreDAO;
import com.student.model.Score;

public class ScoreService
{
	private ScoreDAO scoreDAO;

	public ScoreDAO getScoreDAO()
	{
		return scoreDAO;
	}

	public void setScoreDAO(ScoreDAO scoreDAO)
	{
		this.scoreDAO = scoreDAO;
	}
	
	public List<Score> findallsco()
	{
		return scoreDAO.findAll();
	}
	
	public List<Score> findbycid(String CID)
	{
		return scoreDAO.findbyCID(CID);
	}
	
	public List<Score> findbysid(String sid)
	{
		return scoreDAO.findbySid(sid);
	}
	
	@SuppressWarnings("rawtypes")
	public List max(String cid)
	{
		return scoreDAO.max(cid);
	}
	
	@SuppressWarnings("rawtypes")
	public List min(String cid)
	{
		return scoreDAO.min(cid);
	}
	public void addscore(String cid,String sid,String score)
	{
		scoreDAO.add(sid, cid, score);
	}
}
