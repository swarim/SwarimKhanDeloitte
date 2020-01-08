package com.deloitte;
import java.util.Scanner;
import java.util.*;
public class EmailValidator {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the name : ");
		String input=scan.nextLine();
		EmailValidator eg= new EmailValidator();
		boolean valid = eg.validate(input);
		System.out.println("Input valid = "+valid);

	}

	private boolean validate(String input) {
		
		return input.matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");
	}

}
