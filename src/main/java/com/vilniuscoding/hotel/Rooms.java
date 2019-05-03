package com.vilniuscoding.hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Rooms implements SqlService {

	int id;
	String floor;
	String description;
	boolean occupied;
	boolean cleaned;

	public void changeStatusCleaned() {
		String sql = "UPDATE Rooms cleand VALUES(?) WHERE id VALUES(?)";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setBoolean(1, this.cleaned);
			pstmt.setInt(2, this.id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void changeStatusOccupied() {
		String sql = "UPDATE Rooms occupied VALUES(?) WHERE id VALUES(?)";

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
