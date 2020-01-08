package com.deloitte.emp;

public class Dept implements Cloneable {
	private int id;
	private String name;

	@Override
	public String toString() {
		return "Dept [id=" + id + ", name=" + name + "]";
	}

	public Dept() {
	}

	public Dept(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;

	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

}
