package com.domain;

import java.util.List;

/**
 * @author Suresh
 * 
 */
public class Student {

	private int stuID;
	private String stuName;
	private List<Address> address;

	public int getStuID() {
		return stuID;
	}

	public void setStuID(int stuID) {
		this.stuID = stuID;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

}