package com.deloitte.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "user_details")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "login_id")
	private int id;
	@Column(name = "user_name")
	private String name;
	@Column(name = "user_password")
	private String pwd;

	public User() {
	}

	public User(int id, String name, String pwd) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@NotEmpty(message = "User Name is required")
	@Pattern(regexp = "^[A-Z][A-Za-z]{2,40}$", message = "User name should have only characters and first letter should be uppercase")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pwd=" + pwd + "]";
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
