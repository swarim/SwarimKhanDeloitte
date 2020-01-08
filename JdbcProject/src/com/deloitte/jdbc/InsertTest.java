package com.deloitte.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Scanner;

public class InsertTest {

	public static void main(String[] args) {
		Properties props = new Properties();
		String DRIVER = "", URL = "", USER = "", PASSWORD = "";
		Connection conn = null;
		Scanner scan = new Scanner(System.in);
		String query = "insert into employee(emp_id,emp_name,Emp_emailid,emp_dept) values(?,?,?,?)";
		try {
			props.load(new FileInputStream("db.config"));
			Enumeration em = props.propertyNames();
			String key = (String) em.nextElement();
			DRIVER = props.getProperty("DRIVER");
			URL = props.getProperty("URL");
			USER = props.getProperty("USER");
			PASSWORD = props.getProperty("PASSWORD");
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement stmt = conn.prepareStatement(query);
			System.out.println("Enter <EMP_ID> <EMP_NAME> <EMP_EMAILID> <EMP_DEPT>");
			stmt.setInt(1, scan.nextInt());
			stmt.setString(2, scan.next());
			stmt.setString(3, scan.next());
			stmt.setString(4, scan.next());
			int rows = stmt.executeUpdate();
			if (rows > 0) {
				System.out.println("Data inserted in table, number of rows affected : " + rows);
			} else {
				System.out.println("Insert failed");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
