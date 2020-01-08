package com.deloitte.emp;

public class CloneTest {

	public CloneTest() {
		Emp emp = new Emp(111, "Namitha", 9827291011l, "Manager", new Dept(998, "Sales"));
		try {
			Emp empClone = (Emp) emp.clone();
			System.out.println(empClone);
			System.out.println(emp == empClone);
			emp.getDept().setName("HR");
			System.out.println(empClone);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new CloneTest();

	}

}
