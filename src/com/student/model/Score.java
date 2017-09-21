package com.student.model;

/**
 * Score entity. @author MyEclipse Persistence Tools
 */

public class Score implements java.io.Serializable
{

	// Fields

	private ScoreId id;
	private String score;

	// Constructors

	/** default constructor */
	public Score()
	{
	}

	/** full constructor */
	public Score(ScoreId id, String score)
	{
		this.id = id;
		this.score = score;
	}

	// Property accessors

	public ScoreId getId()
	{
		return this.id;
	}

	public void setId(ScoreId id)
	{
		this.id = id;
	}

	public String getScore()
	{
		return this.score;
	}

	public void setScore(String score)
	{
		this.score = score;
	}

}