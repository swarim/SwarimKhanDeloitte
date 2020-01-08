package com.deloitte.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Properties;

public class jdbcSelect {

	public static void main(String[] args) {
		/*
		 * JDBC_DRIVER=oracle.jdbc.driver.OracleDriver
		 * DATABASE_URL=jdbc:oracle:thin:@localhost:1521:xe QUERY=SELECT * from emp
		 * LOGIN=deloitte PASSWORD=del123
		 */
		/*
		 * String driver = "oracle.jdbc.driver.OracleDriver"; String url =
		 * "jdbc:oracle:thin:@localhost:1521:xe"; String user = "deloitte"; String
		 * password = "del123";
		 */
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

}
