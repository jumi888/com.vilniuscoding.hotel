package com.vilniuscoding.hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Booking implements SqlDbConnect {

	private int id;
	private String bookDate;
	private String bookStart;
	private String bookEnd;
	private double totalPay;
	private String Customer_id;
	private String Rooms_id;

	Customer customer = new Customer();
	Rooms rooms = new Rooms();

	public void insertBooking() {
		String sql = "INSERT INTO Booking (bookDate, bookStart, bookEnd, totalPay, Customer_id, Rooms_id) VALUES(?,?,?,?,?,?)";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, this.bookDate);
			pstmt.setString(2, this.bookStart);
			pstmt.setString(3, this.bookEnd);
			pstmt.setDouble(4, this.totalPay);
			pstmt.setString(5, this.Customer_id);
			pstmt.setString(6, this.Rooms_id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void getBooking() {
		String sql = "SELECT * " + "FROM Booking WHERE Customer_id = ? ";
		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			// set the value
			pstmt.setString(1, this.Customer_id);
			//
			ResultSet rs = pstmt.executeQuery();

			// loop through the result set
			while (rs.next()) {
				System.out.println("---------------------------------" + "\n" + "Booking ID: " + rs.getInt("id") + "\n"
						+ "Booking Date: " + rs.getString("bookDate") + "\n" + "Check-In: " + rs.getString("bookStart")
						+ "\n" + "Check-Out: " + rs.getString("bookEnd") + "\n" + "Total Price: "
						+ rs.getString("totalPay") + "\n" + "Customer ID: " + rs.getString("Customer_id") + "\n"
						+ "----------------------------------------");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public String getCustomer_id() {
		return Customer_id;
	}

	public void setCustomer_id(String customer_id) {
		Customer_id = customer_id;
	}

	public String getRooms_id() {
		return Rooms_id;
	}

	public void setRooms_id(String rooms_id) {
		Rooms_id = rooms_id;
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

}
