package com.student.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable
{

	// Fields

	private String sid;
	private Cla cla;
	private String sname;
	private String sex;
	private String birthday;
	private String password;
	private String tel;
	private String address;
	private Set scores = new HashSet(0);

	// Constructors

	/** default constructor */
	public Student()
	{
	}

	/** minimal constructor */
	public Student(String sid, Cla cla, String sname, String sex,
			String birthday, String password, String tel, String address)
	{
		this.sid = sid;
		this.cla = cla;
		this.sname = sname;
		this.sex = sex;
		this.birthday = birthday;
		this.password = password;
		this.tel = tel;
		this.address = address;
	}

	/** full constructor */
	public Student(String sid, Cla cla, String sname, String sex,
			String birthday, String password, String tel, String address,
			Set scores)
	{
		this.sid = sid;
		this.cla = cla;
		this.sname = sname;
		this.sex = sex;
		this.birthday = birthday;
		this.password = password;
		this.tel = tel;
		this.address = address;
		this.scores = scores;
	}

	// Property accessors

	public String getSid()
	{
		return this.sid;
	}

	public void setSid(String sid)
	{
		this.sid = sid;
	}

	public Cla getCla()
	{
		return this.cla;
	}

	public void setCla(Cla cla)
	{
		this.cla = cla;
	}

	public String getSname()
	{
		return this.sname;
	}

	public void setSname(String sname)
	{
		this.sname = sname;
	}

	public String getSex()
	{
		return this.sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public String getBirthday()
	{
		return this.birthday;
	}

	public void setBirthday(String birthday)
	{
		this.birthday = birthday;
	}

	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getTel()
	{
		return this.tel;
	}

	public void setTel(String tel)
	{
		this.tel = tel;
	}

	public String getAddress()
	{
		return this.address;
	}

	public void setAddress(String address)
	{
		this.address = address;
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