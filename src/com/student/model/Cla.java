package com.student.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Cla entity. @author MyEclipse Persistence Tools
 */

public class Cla implements java.io.Serializable
{

	// Fields

	private String id;
	private String name;
	private Set students = new HashSet(0);

	// Constructors

	/** default constructor */
	public Cla()
	{
	}

	/** minimal constructor */
	public Cla(String id, String name)
	{
		this.id = id;
		this.name = name;
	}

	/** full constructor */
	public Cla(String id, String name, Set students)
	{
		this.id = id;
		this.name = name;
		this.students = students;
	}

	// Property accessors

	public String getId()
	{
		return this.id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Set getStudents()
	{
		return this.students;
	}

	public void setStudents(Set students)
	{
		this.students = students;
	}

}