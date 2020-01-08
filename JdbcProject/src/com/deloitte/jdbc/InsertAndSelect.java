package com.deloitte.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Scanner;

public class InsertAndSelect {
	static void ShowTable() {
		Properties props = new Properties();
		String DRIVER = "", URL = "", USER = "", PASSWORD = "";
		String query = "select * from EMPLOYEE";
		Connection conn = null;
		try {
			props.load(new FileInputStream("db.config"));
			Enumeration em = props.propertyNames();
			String key = (String) em.nextElement();
			DRIVER = props.getProperty("DRIVER");
			URL = props.getProperty("URL");
			USER = props.getProperty("USER");
			PASSWORD = props.getProperty("PASSWORD");
			Class.forName(DRIVER);
			System.out.println("Driver Loaded");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Connection Established");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				System.out.println(
						rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getString(3) + ", " + rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
	}

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
				ShowTable();
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
