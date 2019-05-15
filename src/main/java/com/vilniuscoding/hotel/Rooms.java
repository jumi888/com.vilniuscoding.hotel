package com.vilniuscoding.hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Rooms implements SqlDbConnect {

	private int id;
	private String floor;
	private String description;
	private boolean occupied;
	private boolean cleaned;

	
	public String getRooms() {
		String sql = "SELECT id, floor, description, occupied, cleaned FROM Rooms";
		ArrayList<String> list = new ArrayList<>();

		try (Connection conn = this.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {

				list.add(rs.getString("id"));
				list.add(rs.getString("floor"));
				list.add(rs.getString("description"));
				list.add(rs.getString("occupied"));
				list.add(rs.getString("cleaned"));

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("-Number-Floor--Description--Occupied-Cleaned-");
		System.out.println("-----" + list.get(0) + "------" + list.get(1) + "----" + list.get(2) + "-----" + list.get(3) + "--------" + list.get(4) + "---");
		System.out.println("-----" + list.get(5) + "------" + list.get(6) + "----" + list.get(7) + "-----" + list.get(8) + "--------" + list.get(9) + "---");
		System.out.println("-----" + list.get(10) + "------" + list.get(11) + "----" + list.get(12) + "----" + list.get(13) + "--------" + list.get(14) + "---");
		System.out.println("-----" + list.get(15) + "------" + list.get(16) + "----" + list.get(17) + "----" + list.get(18) + "--------" + list.get(19) + "---");
		System.out.println("-----" + list.get(20) + "------" + list.get(21) + "----" + list.get(22) + "------------" + list.get(23) + "--------" + list.get(24) + "---");
		System.out.println("-----" + list.get(25) + "------" + list.get(26) + "----" + list.get(27) + "------------" + list.get(28) + "--------" + list.get(29) + "---");
		System.out.println("-----" + list.get(30) + "------" + list.get(31) + "----" + list.get(32) + "------------" + list.get(33) + "--------" + list.get(34) + "---");
		System.out.println("-----" + list.get(35) + "------" + list.get(36) + "----" + list.get(37) + "------------" + list.get(38) + "--------" + list.get(39) + "---");
		System.out.println("-----" + list.get(40) + "------" + list.get(41) + "----" + list.get(42) + "------------" + list.get(43) + "--------" + list.get(44) + "---");
		System.out.println("-----" + list.get(45) + "-----" + list.get(46) + "----" + list.get(47) + "------------" + list.get(48) + "--------" + list.get(49) + "---");
		System.out.println("-----" + list.get(50) + "-----" + list.get(51) + "----" + list.get(52) + "--------------" + list.get(53) + "--------" + list.get(54) + "---");
		System.out.println("-----" + list.get(55) + "-----" + list.get(56) + "----" + list.get(57) + "--------------" + list.get(58) + "--------" + list.get(59) + "---");
		System.out.println("-----" + list.get(60) + "-----" + list.get(61) + "----" + list.get(62) + "--------------" + list.get(63) + "--------" + list.get(64) + "---");
		System.out.println("-----" + list.get(65) + "-----" + list.get(66) + "----" + list.get(67) + "--------------" + list.get(68) + "--------" + list.get(69) + "---");
		System.out.println("-----" + list.get(70) + "-----" + list.get(71) + "----" + list.get(72) + "--------------" + list.get(73) + "--------" + list.get(74) + "---");
		System.out.println("-----" + list.get(75) + "-----" + list.get(76) + "----" + list.get(77) + "--------------" + list.get(78) + "--------" + list.get(79) + "---");
		return null;
		
		
		

		
	}

	public void changeStatusCleaned() {
		String sql = "UPDATE Rooms SET cleaned = ? " + "WHERE id = ?";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setBoolean(1, this.cleaned);
			pstmt.setInt(2, this.id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void changeStatusOccupied() {
		String sql = "UPDATE Rooms SET occupied = ? " + "WHERE id = ?";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setBoolean(1, this.occupied);
			pstmt.setInt(2, this.id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupancy) {
		this.occupied = occupancy;
	}

	public boolean isCleaned() {
		return cleaned;
	}

	public void setCleaned(boolean cleaned) {
		this.cleaned = cleaned;
	}

}
