package com.deloitte.util;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

public class DBUtil {

	public static Connection conn = null;

	public static Connection getConnection() {
		String DRIVER = "", URL = "", USER = "", PASSWORD = "";
		try {
			if (conn == null || conn.isClosed()) {
				Map<String, String> dbConfigMap = new DBReader().getConfigMap();
				DRIVER = dbConfigMap.get("DRIVER");
				URL = dbConfigMap.get("URL");
				USER = dbConfigMap.get("USER");
				PASSWORD = dbConfigMap.get("PASSWORD");
				Class.forName(DRIVER);
				conn = DriverManager.getConnection(URL, USER, PASSWORD);

			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void closeConneciton() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
