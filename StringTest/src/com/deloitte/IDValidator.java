package com.deloitte;
import java.util.Scanner;
import java.util.*;
public class IDValidator {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the ID to validate[xxx-xx-xxxx]");
		String input=scan.nextLine();
		IDValidator dg= new IDValidator();
		boolean valid = dg.validate(input);
		System.out.println("Input valid = "+valid);

	}

	private boolean validate(String input) {
		
		return input.matches("\\d{3}-\\d{2}-\\d{4}");
	}

}
