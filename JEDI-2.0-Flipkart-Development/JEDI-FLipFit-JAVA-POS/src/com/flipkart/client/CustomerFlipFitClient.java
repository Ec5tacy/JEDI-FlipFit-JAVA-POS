package com.flipkart.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.flipkart.bean.Customer;
import com.flipkart.bean.Gym;
import com.flipkart.bean.Slot;
import com.flipkart.constants.ColorConstants;
import com.flipkart.exception.CustomerNotFoundException;
import com.flipkart.exception.GymOwnerNotFoundException;
import com.flipkart.service.CustomerFlipFitServiceImpl;
import com.flipkart.service.UserFlipFitServiceImpl;
import com.flipkart.exception.SlotNotFoundException;
import com.flipkart.exception.UserAlreadyExistsException;

public class CustomerFlipFitClient {

	Customer customer = new Customer();
	CustomerFlipFitServiceImpl customerBusiness = new CustomerFlipFitServiceImpl();
	Scanner sc = new Scanner(System.in);

	public void registerCustomer() throws UserAlreadyExistsException {
		System.out.println("==========================================");
		System.out.println("            Customer Registration         ");
		System.out.println("==========================================");
		String email="",phoneNo="";
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher m = pattern.matcher(email);
		while(!m.matches()){
			System.out.print("Enter Email: ");
			email = sc.next();
			m = pattern.matcher(email);
		}
		customer.setEmail(email);
		System.out.print("Enter password: ");
		customer.setPassword(sc.next());
		customer.setRoleId("Customer");
		System.out.print("Enter Name: ");
		customer.setName(sc.next());
		while(phoneNo.length()!=10){
			if(!phoneNo.isEmpty())System.out.println("Invalid Phone number");
			System.out.println("Enter Phone Number");
			phoneNo = sc.next();
		}
		customer.setPhoneNumber(phoneNo);
		System.out.print("Enter Age: ");
		customer.setAge(Integer.valueOf(sc.next()));
		System.out.print("Enter Address: ");
		customer.setAddress(sc.next());
		UserFlipFitServiceImpl userBusiness = new UserFlipFitServiceImpl();
		userBusiness.registerCustomer(customer);

		System.out.println("Customer registered successfully!");

	}


//	public void viewProfile(Scanner in, String email) {
//		try {
//			customer = CustomerFlipFitServiceImpl.getProfile(email);
//		} catch (GymOwnerNotFoundException e) {
//			// TODO Auto-generated catch block
//			System.out.println(ColorConstants.RED + e.getMessage() + ColorConstants.RESET);
//			return;
//		}
//		System.out.println("______________________________________________________________");
//		System.out.printf("%15s%15s%15s%15s", "Gym Owner Name", "Phone Number", "PAN Number", "Aadhaar Number");
//		System.out.println();
//		System.out.printf("%15s%15s%15s%15s", gymOwner.getName(), gymOwner.getPhoneNumber(), gymOwner.getPanNumber(),
//				gymOwner.getAadharNumber());
//		System.out.println();
//		System.out.println("\n______________________________________________________________");
//	}

	public void getProfile(Scanner in, String email) {
		try {
			customer = customerBusiness.getProfile(email);
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(ColorConstants.RED + e.getMessage() + ColorConstants.RESET);
			return;
		}
		System.out.println("______________________");
		System.out.printf("%15s%15s%15s%15s", "Customer Name", "Phone Number", "Address", "Age");
		System.out.println();
		System.out.printf("%15s%15s%15s%15s", customer.getName(), customer.getPhoneNumber(), customer.getAddress(),
				customer.getAge());
		System.out.println();
		System.out.println("\n______________________");
//		n______________________");
	}
	public static boolean isValidFutureDate(String inputDate) {
		try {
			// Parse the input date
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate date = LocalDate.parse(inputDate, formatter);

			// Get today's date
			LocalDate currentDate = LocalDate.now();

			// Check if the parsed date is today or in the future
			return !date.isBefore(currentDate);
		} catch (Exception e) {
			// Handle parsing errors or invalid date format
			return false;
		}
	}


	public void viewGyms(String email) throws ParseException, SlotNotFoundException {
		getGyms();
		System.out.print("Enter Gym ID: ");
		String gymId = sc.next();
		System.out.print("Enter Date (yyyy-mm-dd): ");
		String dateStr = sc.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dateFormat.parse(dateStr);

		if (isValidFutureDate(dateStr)) {
			System.out.println("The entered date is valid and in the future.");
		} else {
			System.out.println("Invalid date. Please enter today's date or a future date.");
		}

		List<Slot> slots = customerBusiness.getSlotInGym(gymId);
		for (Slot slot : slots) {
			System.out.print("Slot Id: " + slot.getSlotId());
			System.out.print("Availability: " + customerBusiness.isSlotBooked(slot.getSlotId(), String.valueOf(date)));
		}
		System.out.print("Enter the slot ID which you want to book: ");
		String slotId = sc.next();
		int bookingResponse = customerBusiness.bookSlot(gymId,slotId, email, String.valueOf(date));
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
		System.out.println("==========================================");
		System.out.println("              Edit Profile               ");
		System.out.println("==========================================");
		System.out.println("Want to change password? Yes/No");
		String choice = sc.next();
		if(choice.equals("Yes")){
			System.out.print("Enter Password: ");
			customer.setPassword(sc.next());
		}
		System.out.println("Want to change name? Yes/No");
		choice = sc.next();
		if(choice.equals("Yes")) {
			System.out.print("Enter Name: ");
			customer.setName(sc.next());
		}
		System.out.println("Want to change phone number? Yes/No");
		choice = sc.next();
		if(choice.equals("Yes")) {
			System.out.print("Enter Phone Number: ");
			customer.setPhoneNumber(sc.next());
		}
		System.out.println("Want to change age? Yes/No");
		choice = sc.next();
		if(choice.equals("Yes")) {
			System.out.print("Enter Age: ");
			customer.setAge(Integer.valueOf(sc.next()));
		}
		System.out.println("Want to change phone address? Yes/No");
		choice = sc.next();
		if(choice.equals("Yes")) {
			System.out.print("Enter Address: ");
			customer.setAddress(sc.next());
		}
		System.out.println("Successfully edited your profile");
	}

	public void getGyms() {
		System.out.print("Enter your city: ");
		List<Gym> gyms = customerBusiness.getGymInCity(sc.next());
		System.out.println("==========================================================================");
		System.out.printf("%15s%20s%15s", "Gym Id", "Gym Owner Email", "Gym Name");
		System.out.println();
		for (Gym gym : gyms) {
			System.out.printf("%15s%20s%15s", gym.getGymId(), gym.getOwnerEmail(),gym.getGymName() );
			System.out.println();
			System.out.println("==========================================================================");
			System.out.println();
		}
		System.out.println();
	}



	public void cancelBooking(String email) {
		System.out.println("==========================================");
		System.out.println("            Cancel Booking               ");
		System.out.println("==========================================");
		System.out.print("Enter booking ID that you want to cancel: ");
		String bookingId = sc.next();
		customerBusiness.cancelBooking(bookingId, email);
	}

	public void customerMenu(String email) throws ParseException, SlotNotFoundException {
		int choice = 0;

		while (choice != 6) {
			System.out.println("==========================================");
			System.out.println("                 Menu                    ");
			System.out.println("==========================================");
			System.out.println("1.View Gyms \n2.View Booked Slots \n3.Cancel Booked Slots \n4.Edit Profile \n5.View Profile \n6.Exit");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();

			switch (choice) {
				case 1:
					viewGyms(email);
					break;
				case 2:
					customerBusiness.getBookings(email);
					break;
				case 3:
					cancelBooking(email);
					break;
				case 4:
					editProfile(email);
					break;
				case 5:
					getProfile(sc,email);
				case 6:
					break;
				default:
					System.out.println("Invalid choice!");
			}
		}
	}
}