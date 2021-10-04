package com.jwt.model;

public class UserRequest {
	private String userName;
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserRequest(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public UserRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserRequest [userName=" + userName + ", password=" + password + "]";
	}
	

}
