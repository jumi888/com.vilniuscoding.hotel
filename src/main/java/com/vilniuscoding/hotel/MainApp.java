package com.vilniuscoding.hotel;

import java.util.ArrayList;



public class MainApp {
	public static void main(String[] args) {

		Customer customer = new Customer();
		
		customer.setId(2588557);
		customer.setCompany("private");
		customer.setForename("Lukrecija");
		customer.setSurname("Ber�inskait�");
		customer.setPhone("+37068616675");
		customer.setStreet("Liep� 3");
		customer.setCity("Klaip�da");
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
		guest.setSurname("Ber�inskas");
		guest.setPhone("+37068274345");
		guest.setStreet("Liep� 3");
		guest.setCity("Klaip�da");
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
