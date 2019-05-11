package com.vilniuscoding.hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Customer implements SqlDbConnect {

	static String id;
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

	public ArrayList<String> getCustomers() {
		String sql = "SELECT id, company, forename, surname, birth, phone, city, country, postal, email FROM Customer";
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
	