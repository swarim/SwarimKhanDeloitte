package com.deloitte;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class IDValidatorFromFile {
	private Pattern pattern;
	private Matcher matcher;
	private String regex="\\d{3}-\\d{2}-\\d{4}";

	public IDValidatorFromFile() {
		pattern = pattern.compile(regex);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BufferedReader br=null;
		try {
		IDValidatorFromFile idv= new IDValidatorFromFile();
		FileReader fr= new FileReader("values.txt");
		 br = new BufferedReader(fr);
		String input="";
		while((input=br.readLine())!=null){
			boolean valid = idv.validate(input);
			System.out.println("ID: "+input+" valid = "+valid);
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			if(br!=null)  { try {
				br.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			} }
		}
		

	}

	private boolean validate(String input) {
		
      matcher = pattern.matcher(input);
	  return matcher.matches();
      //return mater.matches("\\d{3}-\\d{2}-\\d{4}");
		
	}

}
