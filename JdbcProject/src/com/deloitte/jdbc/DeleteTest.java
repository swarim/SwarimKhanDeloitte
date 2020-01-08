package com.deloitte.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class DeleteTest {

	public static void main(String[] args) {
		String DRIVER = "", URL = "", USER = "", PASSWORD = "";
		Connection conn = null;
		Scanner scan = new Scanner(System.in);
		String query = "delete from employee where emp_id = ?";
		try {
			Map<String, String> dbConfigMap = new DBReader().getConfigMap();
			DRIVER = dbConfigMap.get("DRIVER");
			URL = dbConfigMap.get("URL");
			USER = dbConfigMap.get("USER");
			PASSWORD = dbConfigMap.get("PASSWORD");
			/*
			 * props.load(new FileInputStream("db.config")); Enumeration em =
			 * props.propertyNames(); String key = (String) em.nextElement(); DRIVER =
			 * props.getProperty("DRIVER"); URL = props.getProperty("URL"); USER =
			 * props.getProperty("USER"); PASSWORD = props.getProperty("PASSWORD");
			 */
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			conn.setAutoCommit(false);
			PreparedStatement stmt = conn.prepareStatement(query);
			System.out.println("Enter id for record that you want to delete : ");
			stmt.setInt(1, scan.nextInt());
			System.out.println("Are you sure you want to delete record[Y/N]");
			String response = scan.next();
			if (response.equalsIgnoreCase("Y")) {
				int rows = stmt.executeUpdate();
				if (rows > 0) {
					System.out.println("Deleted record in the table, number of rows affected : " + rows);
					conn.commit();
				} else {
					System.out.println("Delete failed");
				}
			} else {
				System.out.println("Delete canceled by user");
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
