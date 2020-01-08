package com.deloitte;

import java.lang.reflect.Method;

public class ReflectionTest {

	public static void main(String[] args) {
		try {
			Class objClass = Class.forName("com.deloitte.Emp");
			Emp emp = (Emp) objClass.newInstance();
			System.out.println(emp);
			Method[] meths = objClass.getMethods();
			for (Method method : meths) {
				System.out.println(method);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}

}
