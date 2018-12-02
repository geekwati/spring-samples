package org.example.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
	private Connection con;
	public MyConnection(String driver, String url, String userName, String password){
		try {
		Class.forName(driver);
		con=DriverManager.getConnection(url, userName,password);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
		return con;
	}
}
