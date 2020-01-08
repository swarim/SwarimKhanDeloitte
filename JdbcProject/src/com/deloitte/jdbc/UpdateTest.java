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

public class UpdateTest {

	public static void main(String[] args) {
		String DRIVER = "", URL = "", USER = "", PASSWORD = "";
		Connection conn = null;
		Scanner scan = new Scanner(System.in);
		String query = "update employee set emp_dept=? where emp_id=?";
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
			PreparedStatement stmt = conn.prepareStatement(query);
			System.out.println("Enter id and dept name to update department : ");
			stmt.setString(1, scan.next());
			stmt.setInt(2, scan.nextInt());
			int rows = stmt.executeUpdate();
			if (rows > 0) {
				System.out.println("Data updated in table, number of rows affected : " + rows);
			} else {
				System.out.println("Update failed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
