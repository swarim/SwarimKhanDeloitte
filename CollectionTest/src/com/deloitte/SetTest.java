package com.deloitte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

public class SetTest {

	public static void main(String[] args) {

		List<String> colorList = new CopyOnWriteArrayList<>();
		// new ArrayList<>();
		String[] colorArray = { "red", "green", "blue", "pink", "orange", "red" };
		for (String color : colorArray) {
			colorList.add(color);
		}
		System.out.println(colorList);
		String[] deleteArray = { "green", "blue" };
		List<String> deleteList = Arrays.asList(deleteArray);
		Iterator<String> iter = colorList.iterator();
		int ctr = 0;
		while (iter.hasNext()) {
			ctr++;
			String color = iter.next();
			if (deleteList.contains(color)) {
				colorList.remove(color);
				// iter.remove();
				if (ctr == 2)
					colorList.add("yellow");
			}
		}

		/*
		 * Set<Emp> empSet = new HashSet<>();
		 * 
		 * empSet.add(new Emp(141, "Swati", 9827291011L)); empSet.add(new Emp(111,
		 * "Sandhra", 8129201170L)); empSet.add(new Emp(231, "Anshul", 9827294142L));
		 * empSet.add(new Emp(199, "Aditya", 9827298849L)); empSet.add(new Emp(871,
		 * "Swarim", 9824748011L)); empSet.add(new Emp(871, "Swarim", 9824748011L));
		 * System.out.println(empSet);
		 */
	}

}
