package com.vilniuscoding.hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Customer implements SqlDbConnect {

	protected String id;
	protected String company;
	protected String forename;
	protected String surname;
	protected String phone;
	protected String street;
	protected String city;
	protected String country;
	protected String postal;
	protected String email;
	protected String birth;

	public void insertCustomer() {
		String sql = "INSERT INTO Customer (id, company, forename, surname, birth, phone, street, city, country, postal, email) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			pstmt.setString(2, this.company);
			pstmt.setString(3, this.forename);
			pstmt.setString(4, this.surname);
			pstmt.setString(5, this.birth);
			pstmt.setString(6, this.phone);
			pstmt.setString(7, this.street);
			pstmt.setString(8, this.city);
			pstmt.setString(9, this.country);
			pstmt.setString(10, this.postal);
			pstmt.setString(11, this.email);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void getCustomers() {
		String sql = "SELECT id, company, forename, surname, birth, phone, street, city, country, postal, email FROM Customer";

		try (Connection conn = this.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				System.out.println("Customer ID: " + rs.getInt("id") + "\t"
						+ "Company: " + rs.getString("company") + "\t" + "Name: " + rs.getString("forename") + "\t"
						+ "Last Name: " + rs.getString("surname") + "\t" + "Date of Birth: " + rs.getString("birth")
						+ "\t" + "Phone Number: " + rs.getString("phone") + "\t" + "Adress: " + rs.getString("street")
						+ "\t" + "City: " + rs.getString("city") + "\t" + "Country: " + rs.getString("country") + "\t"
						+ "Post Code: " + rs.getString("postal") + "\t" + "E-mail: " + rs.getString("email"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getForename() {
		return forename;
	}

	public void setForename(String forename) {
		this.forename = forename;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

}
