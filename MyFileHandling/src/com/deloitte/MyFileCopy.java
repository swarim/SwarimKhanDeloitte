package com.deloitte;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MyFileCopy {

	public static void main(String[] args) {
		new MyFileCopy();
	}

	public MyFileCopy() {
		FileReader fr = null;
		BufferedReader br = null;
		String line = "";
		File outFile = new File("output2.txt");
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fr = new FileReader("output.txt");
			br = new BufferedReader(fr);
			// line = br.readLine();

			fw = new FileWriter(outFile,true);//appends to file
			bw = new BufferedWriter(fw);
			
			//bw.write(line+delim);//to write to next line
			//or
			while ((line = br.readLine()) != null)
			{
				bw.write(line);
				bw.newLine();// for end of line character 
				
			}
			} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if(bw!=null)
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
		}

	}

}
