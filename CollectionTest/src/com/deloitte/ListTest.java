package com.deloitte;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

//import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class ListTest {

	public static void main(String[] args) {

		List<String> colorList = new ArrayList<>();
		String[] colorArray = { "red", "green", "blue", "pink", "orange" };
		for (String color : colorArray) {
			colorList.add(color);
		}
		System.out.println(colorList);
		System.out.println(colorList.get(3));
		colorList.remove(3);
		System.out.println(colorList);
		colorList.add(3,"yellow");
		System.out.println(colorList);
		Collections.sort(colorList);
		System.out.println(colorList);
		Collections.sort(colorList, Collections.reverseOrder());
		System.out.println(colorList);
	}

}
