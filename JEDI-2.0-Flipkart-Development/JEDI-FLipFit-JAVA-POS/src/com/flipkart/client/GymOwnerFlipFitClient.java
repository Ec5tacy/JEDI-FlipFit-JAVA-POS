package com.flipkart.client;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.*;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;
import com.flipkart.service.GymOwnerFlipFitServiceImpl;
import com.flipkart.service.UserFlipFitServiceImpl;
import com.flipkart.constants.ColorConstants;
import com.flipkart.exception.GymNotFoundException;
import com.flipkart.exception.GymOwnerNotFoundException;
import com.flipkart.exception.UnauthorizedAccessException;
import com.flipkart.exception.UserAlreadyExistsException;
import com.flipkart.utils.IdGenerator;

public class GymOwnerFlipFitClient {

	GymOwner gymOwner = new GymOwner();
	GymOwnerFlipFitServiceImpl gymOwnerBusiness = new GymOwnerFlipFitServiceImpl();
	UserFlipFitServiceImpl userBusiness = new UserFlipFitServiceImpl();

	public void gymOwnerRegistration(Scanner in) throws UserAlreadyExistsException {
		System.out.println("\nEnter GymOwner Details: \n");
		String aadhar="",email="",phoneNo="",pan="";
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher m = pattern.matcher(email);
		while(!m.matches()){
			System.out.print("Enter Email: ");
			email = in.next();
			m = pattern.matcher(email);
		}
		gymOwner.setEmail(email);


		System.out.print("Enter Password: ");
		gymOwner.setPassword(in.next());
		gymOwner.setRoleId("GymOwner");
		System.out.print("Enter Name: ");
		gymOwner.setName(in.next());



		while(phoneNo.length()!=10){
			if(!phoneNo.isEmpty())System.out.println("Invalid Phone number");
			System.out.println("Enter phone number");
			phoneNo = in.next();
		}
		gymOwner.setPhoneNumber(phoneNo);

		while(aadhar.length()!=12){
			if(!aadhar.isEmpty())System.out.println("Invalid Aadhaar ID");
			System.out.println("Enter Aadhaar Id");
			aadhar = in.next();
		}
		gymOwner.setAadharNumber(aadhar);
		while(pan.length()!=10){
			if(!pan.isEmpty())System.out.println("Invalid PAN Number");
			System.out.println("Enter PAN Number");
			pan = in.next();
		}
		gymOwner.setPanNumber(pan);




		UserFlipFitServiceImpl userBusiness = new UserFlipFitServiceImpl();
        userBusiness.registerGymOwner(gymOwner);
        System.out
                .println("\n" + ColorConstants.GREEN + "Gym Owner registered successfully!" + ColorConstants.RESET);
    }

	public void editProfile(Scanner in, String email) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Want to change Email? Yes/No");
		String choice = sc.next();
		if(choice.equals("Yes")){
			System.out.println("Enter Email: ");
			gymOwner.setEmail(email);
		}
		System.out.println("Want to change Password? Yes/No");
		choice = sc.next();
		if(choice.equals("Yes")){
			System.out.print("Enter Password: ");
			gymOwner.setPassword(in.next());
		}
		System.out.println("Want to change Name? Yes/No");
		choice = sc.next();
		if(choice.equals("Yes")){
			System.out.print("Enter Name: ");
			gymOwner.setRoleId("GymOwner");
			gymOwner.setName(in.next());
		}
		System.out.println("Want to change Phone Number? Yes/No");
		choice = sc.next();
		if(choice.equals("Yes")) {
			System.out.print("Enter Phone Number: ");
			gymOwner.setPhoneNumber(in.next());
		}
		System.out.println("Want to change PAN? Yes/No");
		choice = sc.next();
		if(choice.equals("Yes")) {
			System.out.print("Enter PAN: ");
			gymOwner.setPanNumber(in.next());
		}
		System.out.println("Want to change Aadhar? Yes/No");
		choice = sc.next();
		if(choice.equals("Yes")) {
			System.out.print("Enter Aadhaar: ");
			gymOwner.setAadharNumber(in.next());
		}
		try {
			gymOwnerBusiness.editProfile(gymOwner);
		} catch (GymOwnerNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(ColorConstants.RED + e.getMessage() + ColorConstants.RESET);
		}
	}

	public void viewProfile(Scanner in, String email) {
		try {
			gymOwner = gymOwnerBusiness.getProfile(email);
		} catch (GymOwnerNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(ColorConstants.RED + e.getMessage() + ColorConstants.RESET);
			return;
		}
		System.out.println("______________________________________________________________");
		System.out.printf("%15s%15s%15s%15s", "Gym Owner Name", "Phone Number", "PAN Number", "Aadhaar Number");
		System.out.println();
		System.out.printf("%15s%15s%15s%15s", gymOwner.getName(), gymOwner.getPhoneNumber(), gymOwner.getPanNumber(),
				gymOwner.getAadharNumber());
		System.out.println();
		System.out.println("\n______________________________________________________________");
	}

	public void addGym(Scanner in, String email) {
		System.out.println("Please Enter Gym Details ");

		Gym gym = new Gym();
		gym.setGymId(IdGenerator.generateId("Gym"));
		System.out.print("Gym Name: ");
		gym.setGymName(in.next());
		gym.setOwnerEmail(email);
		System.out.print("Address: ");
		gym.setAddress(in.next());
		System.out.print("SlotCount: ");
		try {
			gym.setSlotCount(in.nextInt());
		} catch (InputMismatchException e) {
			System.out.println(ColorConstants.RED + e.getMessage() + ColorConstants.RESET);
			return;
		}
		System.out.print("SeatsPerSlotCount: ");
		gym.setSeatsPerSlotCount(in.nextInt());
		gym.setVerified(false);

		gymOwnerBusiness.addGym(gym);
	}

	public void editGym(Scanner in, String email) {
		System.out.println("Please Enter Gym Details ");

		Gym gym = new Gym();
		System.out.print("Gym Id: ");
		gym.setGymId(in.next());
		System.out.print("GymName: ");
		gym.setGymName(in.next());
		gym.setOwnerEmail(email);
		System.out.print("Address: ");
		gym.setAddress(in.next());
		System.out.print("SlotCount: ");
		try {
			gym.setSlotCount(in.nextInt());
			System.out.print("SeatsPerSlotCount: ");
			gym.setSeatsPerSlotCount(in.nextInt());
		} catch (InputMismatchException e) {
			System.out.println(ColorConstants.RED + e.getMessage() + ColorConstants.RESET);
			return;
		}
		gym.setVerified(false);

		try {
			gymOwnerBusiness.editGym(gym);
		} catch (GymNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(ColorConstants.RED + e.getMessage() + ColorConstants.RESET);
		}
	}

	public void getGymDetails(Scanner in, String email) {
		List<Gym> gymDetails = gymOwnerBusiness.getGymDetail(email);
		if (gymDetails.size() == 0) {
			System.out.println(ColorConstants.RED + "Sorry, no gyms found!" + ColorConstants.RED);
			return;
		}
		System.out.println("_________________________________________________________________________");
		System.out.println();
		System.out.printf("%15s%15s%15s%15s%15s%15s", "Gym Id", "Gym Name", "Address", "SlotCount", "SeatsPerSlot", "Verification");
		gymDetails.forEach(gym -> {
			System.out.println();
			System.out.printf("%15s%15s%15s%15s%15s%15s", gym.getGymId(), gym.getGymName(), gym.getAddress(),
					gym.getSlotCount(), gym.getSeatsPerSlotCount(),
					gym.isVerified() ? "Verified" : "Not Verified");
		});
		System.out.println();
		System.out.println("_________________________________________________________________________");
	}

	public void addSlot(Scanner in, String email) {
		System.out.println("Enter Slot Details: ");
		Slot slot = new Slot();
		slot.setSlotId(IdGenerator.generateId("Slot"));
		System.out.print("Enter Gym Id:");
		slot.setGymId(in.next());
		System.out.print("Enter Slot Date: ");
		slot.setDate(in.next());
		System.out.print("Enter Slot Start Time: ");
		slot.setStartTime(in.next());
		System.out.print("Enter Slot End Time: ");
		slot.setEndTime(in.next());
		System.out.print("Enter number of seats in slot: ");
		try {
			slot.setNumOfSeats(in.nextInt());
		} catch (InputMismatchException e) {
			System.out.println(ColorConstants.RED + e.getMessage() + ColorConstants.RESET);
			return;
		}
		System.out.print("Enter Trainer: ");
		slot.setTrainer(in.next());
		slot.setNumOfSeatsBooked(0);

		try {
			gymOwnerBusiness.addSlot(slot, email);
		} catch (GymNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(ColorConstants.RED + e.getMessage() + ColorConstants.RESET);
		} catch (UnauthorizedAccessException e) {
			System.out.println(ColorConstants.RED + e.getMessage() + ColorConstants.RESET);
		}
	}

	public void gymOwnerMenu(Scanner in, String email) {
		boolean recur = true;
		while (recur) {
			System.out.println("\nHere are the actions you can perform!");

			System.out.println("1. View Profile");
			System.out.println("2. Edit Profile");
			System.out.println("3. Add Gym");
			System.out.println("4. Edit Gym");
			System.out.println("5. Add Slot");
			System.out.println("6. View All Gym Details");
			System.out.println("7. LogOut\n");

			System.out.print("Enter Your Choice: " );
			int choice = in.nextInt();

			System.out.println("______________________________________________________________\n");

			switch (choice) {
				case 1:
					viewProfile(in, email);
					break;
				case 2:
					editProfile(in, email);
					break;
				case 3:
					addGym(in, email);
					break;
				case 4:
					editGym(in, email);
					break;
				case 5:
					addSlot(in, email);
					break;
				case 6:
					getGymDetails(in, email);
					break;
				case 7:
					recur = false;
					break;
				default:
					System.out.println(ColorConstants.RED + "Invalid Choice!" + ColorConstants.RESET);
			}
			if (!recur) {
				gymOwner = new GymOwner();
				boolean logOutSuccess = userBusiness.logout(gymOwner);
				if (logOutSuccess)
					System.out.println(ColorConstants.GREEN + "Logged Out Successfully!" + ColorConstants.RESET);
				else
					System.out.println(ColorConstants.RED + "Logged Out Successfully!" + ColorConstants.RESET);
			}
		}

	}

}
