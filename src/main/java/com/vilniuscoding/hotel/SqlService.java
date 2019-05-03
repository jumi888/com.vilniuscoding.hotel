package com.vilniuscoding.hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public interface SqlService {

	default Connection connect() {
		// SQLite connection string
		String url = "jdbc:sqlite:C:/Users/julmik/Desktop/JAVA/Workplace/com.vilniuscoding.hotel/HOTEL.db";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	

}
