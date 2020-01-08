package com.deloitte;

public class StringPoolTest {

	public static void main(String[] args)
	{
		/*String s1 = "Hello";
		String s2 = "Hello";
		System.out.println(s1 == s2);
		String s3 = new String("Hello");
		String s4 = new String("Hello");
		System.out.println(s3 == s4);
		System.out.println(s3.equals(s4));*/
		Emp e1 = new Emp(111,"Sandhra",8129201170L);
		Emp e2 = new Emp(112,"Adithya",8129201170L);
		Emp e3 = new Emp(111,"Sandhra",8129201170L);
		System.out.println(e1 == e3);
		System.out.println(e1.equals(e3));
		System.out.println(e1);
		e1 = null;
		System.gc();
	}
}
