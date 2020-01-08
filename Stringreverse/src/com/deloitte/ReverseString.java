package com.deloitte;

import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("Enter a string:");
	String s1=s.next();
	Reverser rv= new Reverser();
	String rev=rv.revString(s1);
	CountVowel cv= new CountVowel();
	int cnt=cv.countVowel(s1);
	System.out.print("\nReversed String:"+rev);
	System.out.print("\nVowelCount:"+cnt);
	s.close();
	}
}