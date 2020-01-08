package com.deloitte.bean;

public class User {
	private String login;
	private String password;
	private String type;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public User() {

	}

	public User(String login, String password, String type) {
		this.login = login;
		this.password = password;
		this.type = type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
