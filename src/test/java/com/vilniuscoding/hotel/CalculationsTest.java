package com.vilniuscoding.hotel;

import org.junit.Test;

import com.vilniuscoding.hotel.Calculations;

import static org.junit.Assert.*;

import java.time.LocalDate;

public class CalculationsTest {

	@Test
	public void test_calcStayNights() {
		// setup
		Calculations nights = new Calculations();
		// test
		int reply = nights.calcStayNights(LocalDate.parse("2019-05-12"), LocalDate.parse("2019-05-15"));
		// assertion
		assertEquals(3, reply);

	}

	@Test
	public void test_calcTotalPay() {
		// setup
		Calculations total = new Calculations();
		// test
		double reply = total.calcTotalPay(10, 100.00, 2);
		// assertion
		assertEquals(2000.00, reply, 0.00);
	}

}
