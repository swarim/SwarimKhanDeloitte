package com.deloitte;
import java.util.Scanner;
import java.util.*;
public class NameValidator {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the name : ");
		String input=scan.nextLine();
		NameValidator dg= new NameValidator();
		boolean valid = dg.validate(input);
		System.out.println("Input valid = "+valid);

	}

	private boolean validate(String input) {
		
		return input.matches("[A-Z][a-zA-Z]+");
	}

}
