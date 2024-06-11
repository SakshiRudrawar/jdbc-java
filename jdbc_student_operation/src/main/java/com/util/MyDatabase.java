package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyDatabase {

	public static Connection myConnection() {
		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jap55", "root", "1234");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return con;
	}

//	// for close connection
//
//	public static void closeConnection(PreparedStatement pst, Connection con) {
//		try {
//			pst.close();
//			con.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	
//	
//	public static void closeConnection(ResultSet rs ,PreparedStatement pst, Connection con) {
//		try {
//			rs.close();
//			pst.close();
//			con.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//	  }
//	}
	
	
	
	
	
}

















