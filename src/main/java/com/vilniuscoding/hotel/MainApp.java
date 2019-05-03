package com.vilniuscoding.hotel;

import java.util.ArrayList;



public class MainApp {
	public static void main(String[] args) {

		Customer customer = new Customer();
		
		customer.setId(2588557);
		customer.setCompany("private");
		customer.setForename("Lukrecija");
		customer.setSurname("Berþinskaitë");
		customer.setPhone("+37068616675");
		customer.setStreet("Liepø 3");
		customer.setCity("Klaipëda");
		customer.setCountry("Lithuania");
		customer.setPostal("LT-05132");
		customer.setEmail("lukrecija.b@gmail.com");
		customer.setBirth(19801125);
		
		customer.insertCustomer();

		ArrayList<String> customers = customer.getCustomers();

		
		Guests guest = new Guests();
		
		guest.setId(2749896);
		guest.setCompany("private");
		guest.setForename("Marius");
		guest.setSurname("Berþinskas");
		guest.setPhone("+37068274345");
		guest.setStreet("Liepø 3");
		guest.setCity("Klaipëda");
		guest.setCountry("Lithuania");
		guest.setPostal("LT-05132");
		guest.setEmail("marius.b@gmail.com");
		guest.setBirth(19991125);
		
		guest.insertGuest();

		ArrayList<String> guests = guest.getGuests();

		System.out.println(customers);
		System.out.println(guests);
		
		
	}

	public boolean someLibraryMethod() {
		// TODO Auto-generated method stub
		return false;
	}
}
