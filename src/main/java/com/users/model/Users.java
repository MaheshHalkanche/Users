package com.users.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Payroll")
public class Users {
	@Id
	private int id;
	private String userName;
	private Double userEmail;
	private String Mo_Number;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Double getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(Double userEmail) {
		this.userEmail = userEmail;
	}
	public String getMo_Number() {
		return Mo_Number;
	}
	public void setMo_Number(String mo_Number) {
		Mo_Number = mo_Number;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", userName=" + userName + ", userEmail=" + userEmail + ", Mo_Number=" + Mo_Number
				+ "]";
	}
	
	
	
}
