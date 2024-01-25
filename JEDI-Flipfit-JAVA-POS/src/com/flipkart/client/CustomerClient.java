package com.flipkart.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.flipkart.bean.Customer;
import com.flipkart.bean.Gym;
import com.flipkart.bean.Slot;
import com.flipkart.service.CustomerFlipFitService;
import com.flipkart.service.UserFlipFitService;

public class CustomerClient {

	Customer customer = new Customer();
	CustomerFlipFitService customerFlipFitService = new CustomerFlipFitService();
	Scanner sc = new Scanner(System.in);

	public void registerCustomer() {
		System.out.print("Enter email: ");
		customer.setName(sc.next());
		System.out.print("Enter password: ");
		customer.setPassword(sc.next());
		System.out.print("Enter Name: ");
		customer.setName(sc.next());
		System.out.print("Enter Phone Number: ");
		customer.setPhoneNumber(sc.next());
		System.out.print("Enter Age: ");
		customer.setAge(Integer.valueOf(sc.next()));
		System.out.print("Enter Address: ");
		customer.setAddress(sc.next());
		UserFlipFitService userFlipFitService = new UserFlipFitService();
		userFlipFitService.registerCustomer(customer);

		System.out.println("Customer registered successfully!");

	}

	public void viewProfile(Scanner in, String email) {
		customer = customerFlipFitService.getProfile(email);
		System.out.println("______________________________________________________________");
		System.out.printf("%15s%15s%15s%15s", "Customer Name", "Phone Number", "Address", "Age");
		System.out.println();
		System.out.printf("%15s%15s%15s%15s", customer.getName(), customer.getPhoneNumber(),
				customer.getAddress(), customer.getAge(), customer.getEmail());
		System.out.println("______________________________________________________________");

	}

	public void viewGyms(String email) throws ParseException {
		getGyms();
		System.out.print("Enter gym ID: ");
		String gymId = sc.next();
		System.out.print("Enter Date (yyyy-mm-dd): ");
		String dateStr = sc.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dateFormat.parse(dateStr);

		List<Slot> slots = customerFlipFitService.getSlotInGym(gymId);
		for (Slot slot : slots) {
			System.out.print("Slot Id: " + slot.getSlotId());
			System.out.print("Availability: " + !customerFlipFitService.isSlotBooked(slot.getSlotId(), date));
		}
		System.out.print("Enter the slot ID which you want to book: ");
		String slotId = sc.next();
		int bookingResponse = customerFlipFitService.bookSlot(gymId,slotId, email, date);
		switch (bookingResponse) {
		case 0:
			System.out.println("You have already booked this time. Cancelling the previous one and booking this slot");
			break;
		case 1:
			System.out.println("Slot is already booked, added to the waiting list");
			break;
		case 2:
			System.out.println("Successfully booked the slot");
			break;
		case 3:
			System.out.println("Slot not found");
			break;
		default:
			System.out.println("Booking failed");
		}
	}

	public void editProfile(String email) {
		System.out.print("Enter password: ");
		customer.setPassword(sc.next());
		System.out.print("Enter Name: ");
		customer.setName(sc.next());
		System.out.print("Enter Phone Number: ");
		customer.setPhoneNumber(sc.next());
		System.out.print("Enter Age: ");
		customer.setAge(Integer.valueOf(sc.next()));
		System.out.print("Enter Address: ");
		customer.setAddress(sc.next());
		System.out.println("Successfully edited your profile");
	}

	public void getGyms() {
		System.out.print("Enter your city: ");
		List<Gym> gyms = customerFlipFitService.getGymInCity(sc.next());
		for (Gym gym : gyms) {
			System.out.print("Gym Id: " + gym.getGymId());
			System.out.print("Gym Owner Email: " + gym.getOwnerEmail());
			System.out.print("Gym Name: " + gym.getGymName());
			System.out.println();
		}
	}

	public void cancelBooking(String email) {
		System.out.print("Enter booking ID that you want to cancel: ");
		String bookingId = sc.next();
		customerFlipFitService.cancelBooking(bookingId, email);
	}

	public void customerMenu(Scanner in,String email) throws ParseException {
		int choice = 0;

		while (choice != 5) {
			System.out.println("Menu:-");
			System.out.println("1.View Gyms \n2.View Booked Slots \n3.Cancel Booked Slots \n4. Edit Profile \n5.View Profile \n6.Exit");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				viewGyms(email);
				break;
			case 2:
				customerFlipFitService.getBookings(email);
				break;
			case 3:
				cancelBooking(email);
				break;
			case 4:
				editProfile(email);
				break;
			case 5:
				viewProfile(in, email);
				break;
			case 6:
				break;
			default:
				System.out.println("Invalid choice!");
			}
		}
	}
}
