package com.deloitte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.plaf.synth.SynthSeparatorUI;

import com.deloitte.bean.User;
import com.deloitte.util.DBUtil;

public class LoginDaoImpl implements LoginDao {

	@Override
	public String getUserType(User user) {
		// JDBC code
		// fetch password,type,from table, for the login
		// compare password with value in user
		// if authenticated, return type
		Connection conn = null;
		String type = null;
		conn = DBUtil.getConnection();
		if (conn == null)
			System.out.println("conn  :  " + conn);
		else {
			String query = "select password,type from user_details where login =?";
			// String type = null;
			try {
				PreparedStatement stmt = conn.prepareStatement(query);
				stmt.setString(1, user.getLogin());
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
					String password = rs.getString(1);
					if (password.equals(user.getPassword())) {
						type = rs.getString(2);
						user.setType(type);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return type;
	}

	@Override
	public void closeConnection() {
		DBUtil.closeConneciton();

	}

	@Override
	public boolean saveUser(User user) {
		boolean success = false;
		Connection conn = DBUtil.getConnection();
		String query = "insert into user_details(login,password,type) values(?,?,?)";
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(query);
			stmt.setString(1, user.getLogin());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getType());
			int rows = stmt.executeUpdate();
			if (rows > 0) {
				success = true;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;

	}

}
