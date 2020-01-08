package com.deloitte;

public class Reverser {
	public String revString(String s) {
		char[] ch=s.toCharArray();
		char[] ch1=new char[ch.length];
		int j=0;
		for(int i=ch.length-1;i>=0; i--)
			{
			ch1[j]=ch[i];
			j++;
			}
		String s1= new String(ch1);
				return s1 ;
		}

}
