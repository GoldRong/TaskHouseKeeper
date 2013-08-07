package com.rong.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDBTools {
	private static ConnectDBTools tools = new ConnectDBTools();

	private ConnectDBTools() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ConnectDBTools getInstance() {
		if (tools == null) {
			tools = new ConnectDBTools();
		}
		return tools;
	}

	// 获取Connection对象
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/taskhousekeeper", "root", "123456");
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 获取Statement对象
	public Statement getStatement() {
		Statement stmt = null;
		try {
			stmt = this.getConnection().createStatement();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stmt;
	}

	// 对象Resultset对象
	public ResultSet getResultSet(String sql) {
		ResultSet rs = null;
		try {
			rs = this.getStatement().executeQuery(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}
}
