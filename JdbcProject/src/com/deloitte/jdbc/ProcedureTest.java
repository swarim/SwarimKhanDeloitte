package com.deloitte.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Map;
import java.util.Scanner;

public class ProcedureTest {
	public static void main(String[] args) {
		String DRIVER = "", URL = "", USER = "", PASSWORD = "";
		Connection conn = null;
		Scanner scan = new Scanner(System.in);
		String query = "call myproc(?,?)";
		try {
			Map<String, String> dbConfigMap = new DBReader().getConfigMap();
			DRIVER = dbConfigMap.get("DRIVER");
			URL = dbConfigMap.get("URL");
			USER = dbConfigMap.get("USER");
			PASSWORD = dbConfigMap.get("PASSWORD");
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			CallableStatement stmt = conn.prepareCall(query);
			System.out.println("Enter <ID>");
			int id = scan.nextInt();
			stmt.setInt(1, id);
			stmt.registerOutParameter(2, Types.INTEGER);
			stmt.executeUpdate();
			int allowance = stmt.getInt(2);
			System.out.println("Employee with id " + id + " get allowance of " + allowance);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
