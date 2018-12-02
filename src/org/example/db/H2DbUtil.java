package org.example.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class H2DbUtil {
	private MyConnection myConnection;
	
	public MyConnection getMyConnection() {
		return myConnection;
	}

	public void setMyConnection(MyConnection myConnection) {
		this.myConnection = myConnection;
	}

	public void insert(User user) {
		try {
			PreparedStatement stmt = myConnection.getConnection().prepareStatement("insert into mailuser (username, password) values(?,?)");
			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getPassword());
			int i = stmt.executeUpdate();
			System.out.println(i + " records inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<User> select() {
		List<User> users = new ArrayList<User>();
		try {
			Statement smt = myConnection.getConnection().createStatement();
			ResultSet rs = smt.executeQuery("select * from mailuser;");
			while(rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setPassword(rs.getString(3));
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
}
