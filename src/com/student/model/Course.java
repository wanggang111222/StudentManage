package com.student.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */

public class Course implements java.io.Serializable
{

	// Fields

	private String cid;
	private String cname;
	private String property;
	private String credit;
	private Set scores = new HashSet(0);

	// Constructors

	/** default constructor */
	public Course()
	{
	}

	/** minimal constructor */
	public Course(String cid)
	{
		this.cid = cid;
	}

	/** full constructor */
	public Course(String cid, String cname, String property, String credit,
			Set scores)
	{
		this.cid = cid;
		this.cname = cname;
		this.property = property;
		this.credit = credit;
		this.scores = scores;
	}

	// Property accessors

	public String getCid()
	{
		return this.cid;
	}

	public void setCid(String cid)
	{
		this.cid = cid;
	}

	public String getCname()
	{
		return this.cname;
	}

	public void setCname(String cname)
	{
		this.cname = cname;
	}

	public String getProperty()
	{
		return this.property;
	}

	public void setProperty(String property)
	{
		this.property = property;
	}

	public String getCredit()
	{
		return this.credit;
	}

	public void setCredit(String credit)
	{
		this.credit = credit;
	}

	public Set getScores()
	{
		return this.scores;
	}

	public void setScores(Set scores)
	{
		this.scores = scores;
	}

}