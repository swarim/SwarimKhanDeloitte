package com.deloitte;

public class Emp {

	private int id;
	private String name;
	private long mobile;
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
	public void setId(int id) {
		this.id = id;
	}
	public int getId()
	{
		return id;
	}
	public Emp() {
		
	}

	public Emp(int i, String string, long j) {
		id = i;
		name = string;
		mobile = j;
	}
	@Override
	protected void finalize() throws Throwable {
		
		
		super.finalize();
		System.out.println("Emp finalize");
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", mobile=" + mobile + "]";
	}
	public boolean equals(Object obj) {
		Emp comparedEmp = (Emp) obj;
		return comparedEmp.getId()==id && comparedEmp.name == name && comparedEmp.mobile == mobile;
	}

}
