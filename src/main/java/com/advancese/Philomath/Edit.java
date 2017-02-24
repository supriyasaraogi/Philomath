package com.advancese.Philomath;

import java.util.List;

public class Edit {
	
	String name;
	String address;
	String phoneNum;
	String password;
	String pricing;
	String availability;
	boolean travel;
	boolean tutor;
	List<String> courses;
	List<String> coursesTakenAsStudent;
	public List<String> getCoursesTakenAsStudent() {
		return coursesTakenAsStudent;
	}
	public void setCoursesTakenAsStudent(List<String> coursesTakenAsStudent) {
		this.coursesTakenAsStudent = coursesTakenAsStudent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPricing() {
		return pricing;
	}
	public void setPricing(String pricing) {
		this.pricing = pricing;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public boolean isTravel() {
		return travel;
	}
	public void setTravel(boolean travel) {
		this.travel = travel;
	}
	public boolean isTutor() {
		return tutor;
	}
	public void setTutor(boolean tutor) {
		this.tutor = tutor;
	}
	public List<String> getCourses() {
		return courses;
	}
	public void setCourses(List<String> courses) {
		this.courses = courses;
	}

}
