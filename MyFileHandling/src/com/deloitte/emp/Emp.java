package com.deloitte.emp;

import java.io.Serializable;

public class Emp implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private transient long mobile;
	private String desig;
	private Dept dept;

	public Emp(int id, String name, long mobile, String desig, Dept dept) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.desig = desig;
		this.dept = dept;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public Emp() {
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", desig=" + desig + ", dept=" + dept + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getDesig() {
		return desig;
	}

	public void setDesig(String desig) {
		this.desig = desig;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Emp clonedEmp = (Emp) super.clone();
		Dept dept= clonedEmp.getDept();
		
		Dept clonedDept = (Dept) dept.clone();
		clonedEmp.setDept(clonedDept);
		//deep cloning
		return clonedEmp;
	}

}
