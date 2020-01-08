package com.deloitte;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;


public class MyFileWriter {
	public MyFileWriter() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a sentence");
		String line = scan.nextLine();
		File outFile = new File("output.txt");
		FileWriter fw = null;
		BufferedWriter bw = null;
		String delim= System.getProperty("line.separator");
		try {
			//fw = new FileWriter(outFile);//overwrites the file
			
			fw = new FileWriter(outFile,true);
			bw = new BufferedWriter(fw);
			//bw.write(line);
			//bw.write(line+delim);//for new line
			bw.write(line);
			bw.newLine();
			System.out.println("Written to the file");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fw != null)
				try {
					bw.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
		}
	}

	public static void main(String[] args) {
		new MyFileWriter();

	}

}
