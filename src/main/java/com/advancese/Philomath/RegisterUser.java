package com.advancese.Philomath;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RegisterUser {
	String fullName;
    String email;
    String phoneNumber;
    String address;
    String password;
    String securityQuestion;
    String answer;
    boolean travel;
    String radius;
    boolean tutor;
    String course;
    String category;
    String availability;
    String pricing;
    
    
    public RegisterUser(){
    	
    }
    
    
    public RegisterUser(String fullName, String email, String phoneNumber,
			String address, String password, String securityQuestion,
			String answer, boolean travel, String radius, boolean tutor,
			String course, String category, String availability, String pricing) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.password = password;
		this.securityQuestion = securityQuestion;
		this.answer = answer;
		this.travel = travel;
		this.radius = radius;
		this.tutor = tutor;
		this.course = course;
		this.category = category;
		this.availability = availability;
		this.pricing = pricing;
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSecurityQuestion() {
		return securityQuestion;
	}
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public boolean isTravel() {
		return travel;
	}
	public void setTravel(boolean travel) {
		this.travel = travel;
	}
	public String getRadius() {
		return radius;
	}
	public void setRadius(String radius) {
		this.radius = radius;
	}
	public boolean isTutor() {
		return tutor;
	}
	public void setTutor(boolean tutor) {
		this.tutor = tutor;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public String getPricing() {
		return pricing;
	}
	public void setPricing(String pricing) {
		this.pricing = pricing;
	}
	

}
