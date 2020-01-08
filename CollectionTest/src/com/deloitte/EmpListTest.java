package com.deloitte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmpListTest {

	public static void main(String[] args) {
		List<Emp> empList = new ArrayList<>();
		empList.add(new Emp(141,"Swati",9827291011L));
		empList.add(new Emp(111,"Sandhra",8129201170L));
		empList.add(new Emp(231,"Anshul",9827294142L));
		empList.add(new Emp(199,"Aditya",9827298849L));
		empList.add(new Emp(871,"Swarim",9824748011L));
		System.out.println("Sorted by ID");
		System.out.println(empList);
		Collections.sort(empList,new EmpComparator(OrderField.ID));
		System.out.println(empList);
		System.out.println("Sorted by Name");
		//Collections.sort(empList,new EmpComparator(OrderField.NAME));
		Collections.sort(empList,(e1,e2)->e1.getName().compareTo(e2.getName()));
		System.out.println(empList);
		System.out.println("Sorted by Mobile");
		Collections.sort(empList,new EmpComparator(OrderField.MOBILE));
		System.out.println(empList);

	}

}
