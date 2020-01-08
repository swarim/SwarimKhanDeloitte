package com.deloitte;

public class CountVowel {

	public int countVowel(String s1) {
		int cnt=0;
		for(int i=0;i<s1.length();i++)
		{
			if(s1.charAt(i)=='a' || s1.charAt(i)=='e' || s1.charAt(i)=='i' || s1.charAt(i)=='o' || s1.charAt(i)=='u')  
			{
				cnt++;
			}
		}
			return cnt;
	}

}
