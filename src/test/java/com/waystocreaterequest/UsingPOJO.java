package com.waystocreaterequest;

/**
 * 
 */
public class UsingPOJO 
{
	/*
	 * name-string
	 * loaction-string
	 * int-phone number
	 * courses -string
	 */
	
	private String name;
	private String location;
	private double phoneNumber;
	private String[] courses;
	
	public String getName()
	{
		return name;
	}
	public String getLoction()
	{
		return location;
	}
	public double getPhoneNumber()
	{
		return phoneNumber;
	}
	
	public String[] getCourses()
	{
		return courses;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	public void setLoaction(String location)
	{
		this.location=location;
	}
	
	
	public void setPhoneNum(double phoneNumber)
	{
		this.phoneNumber=phoneNumber;
	}
	
	public void setCourses(String[] courses)
	{
		this.courses=courses;
	}
}
