package com.vilniuscoding.hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Guests extends Customer {

	int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void insertGuest() {
		String sql = "INSERT INTO Guests (id, company, forename, surname, birth, phone, street, city, country, postal, email) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, this.id);
			pstmt.setString(2, company);
			pstmt.setString(3, forename);
			pstmt.setString(4, surname);
			pstmt.setInt(5, birth);
			pstmt.setString(6, phone);
			pstmt.setString(7, street);
			pstmt.setString(8, city);
			pstmt.setString(9, country);
			pstmt.setString(10, postal);
			pstmt.setString(11, email);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<String> getGuests() {
		String sql = "SELECT id, company, forename, surname, birth, phone, city, country, postal, email FROM Guests";
		ArrayList<String> list = new ArrayList<>();

		try (Connection conn = this.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {

				list.add(rs.getString("id"));
				list.add(rs.getString("company"));
				list.add(rs.getString("forename"));
				list.add(rs.getString("surname"));
				list.add(rs.getString("birth"));
				list.add(rs.getString("phone"));
				list.add(rs.getString("city"));
				list.add(rs.getString("country"));
				list.add(rs.getString("postal"));
				list.add(rs.getString("email"));

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
}