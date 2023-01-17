package com.test.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
	
	public static void main(String[] args) {
		
		try {
			String databaseUrl = "jdbc:mysql://localhost:3306/1to1";
			String user = "hbstudent";
			String password = "hbstudent";
			Connection connection = DriverManager.getConnection
					(databaseUrl, user, password);
			System.out.println("SUCESS - established connection to Database:\n" + connection);
		} catch (SQLException e) {
			System.out.println("FAILED - not connected to Database");
			e.printStackTrace();
		}
		
	}
	
}
