package com.deloitte;

import java.lang.reflect.Method;

public class ReflectionTest {

	public static void main(String[] args) {
		String className = new MyFileReader().getName();
		String[] arr = className.split(",");
		try {
			Class objClass = Class.forName(arr[0]);
			Emp emp = (Emp) objClass.newInstance();
			emp.setName(arr[1]);
			System.out.println(emp);
			/*Method[] meths = objClass.getMethods();
			for (Method method : meths) {
				System.out.println(method);*/
			//}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}

}
