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

	public ArrayList<String> getRooms() {
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
		return list;

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
