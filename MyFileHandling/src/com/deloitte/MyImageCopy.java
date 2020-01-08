package com.deloitte;

import java.io.*;

public class MyImageCopy {
	public MyImageCopy() {
		File inFile = new File("vegetables.jpg");
		File outFile = new File("veg.jpg");
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream(inFile);
			fos = new FileOutputStream(outFile);
			int c;
			while ((c = fis.read()) != -1) {

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
				}
			}
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {

		new MyImageCopy();
	}

}
