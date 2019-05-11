package com.vilniuscoding.hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Booking implements SqlDbConnect {

	private int id = 1;
	private String bookDate;
	private String bookStart;
	private String bookEnd;
	private double totalPay;
	private String coments;

	public void insertBooking() {
		String sql = "INSERT INTO Booking (id, bookDate, bookStart, bookEnd, totalPay, Customer_id, coments) VALUES(?,?,?,?,?,?,?)";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, this.id++);
			pstmt.setString(2, this.bookDate);
			pstmt.setString(3, this.bookStart);
			pstmt.setString(4, this.bookEnd);
			pstmt.setDouble(5, this.totalPay);
			pstmt.setString(6, Customer.id);
			pstmt.setString(7, this.coments);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<String> getBooking() {
		String sql = "SELECT id, bookDate, bookStart, bookEnd, totalPay, coments FROM Booking";
		ArrayList<String> list = new ArrayList<>();

		try (Connection conn = this.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {

				list.add(rs.getString("id"));
				list.add(rs.getString("bookDate"));
				list.add(rs.getString("bookStart"));
				list.add(rs.getString("bookEnd"));
				list.add(rs.getString("totalPay"));
				list.add(rs.getString("coments"));

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookDate() {
		return bookDate;
	}

	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}

	public String getBookStart() {
		return bookStart;
	}

	public void setBookStart(String string) {
		this.bookStart = string;
	}

	public String getBookEnd() {
		return bookEnd;
	}

	public void setBookEnd(String checkOut) {
		this.bookEnd = checkOut;
	}

	public double getTotalPay() {
		return totalPay;
	}

	public void setTotalPay(double d) {
		this.totalPay = d;
	}

	public String getComents() {
		return coments;
	}

	public void setComents(String coments) {
		this.coments = coments;
	}

}
