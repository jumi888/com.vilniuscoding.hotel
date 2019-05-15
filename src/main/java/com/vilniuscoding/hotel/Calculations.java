package com.vilniuscoding.hotel;

import java.time.LocalDate;

public class Calculations {

	private LocalDate checkIn;
	private LocalDate checkOut;
	private int stayNights;
	private double totalPrice;
	private double pricePerRoom;
	private int roomQty;

	public int calcStayNights(LocalDate checkIn, LocalDate checkOut) { // method, calculating stay nights

		stayNights = checkOut.compareTo(checkIn);

		return stayNights;

	}

	public double calcTotalPay(int stayNights, double pricePerRoom, int roomQty) { // method, calculating total stay
																					// price

		totalPrice = stayNights * pricePerRoom * roomQty;

		return totalPrice;

	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}

	public int getStayNights() {
		return stayNights;
	}

	public void setStayNights(int stayNights) {
		this.stayNights = stayNights;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getPricePerRoom() {
		return pricePerRoom;
	}

	public void setPricePerRoom(double pricePerRoom) {
		this.pricePerRoom = pricePerRoom;
	}

	public int getRoomQty() {
		return roomQty;
	}

	public void setRoomQty(int roomQty) {
		this.roomQty = roomQty;
	}

}
