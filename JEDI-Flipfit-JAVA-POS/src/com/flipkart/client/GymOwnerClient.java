package com.flipkart.client;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;
import com.flipkart.service.GymOwnerFlipFitService;
import com.flipkart.service.UserFlipFitService;
import com.flipkart.constants.ColorConstants;
import com.flipkart.utils.IdGenerator;

import java.util.List;
import java.util.Scanner;

public class GymOwnerClient {

    GymOwner gymOwner = new GymOwner();
    GymOwnerFlipFitService gymOwnerFlipFitService = new GymOwnerFlipFitService();

    public void gymOwnerRegistration(Scanner in) {
        System.out.println("Enter GymOwner Details: ");
        System.out.print("Enter Name: ");
        gymOwner.setName(in.next());
        System.out.print("Enter Phone Number: ");
        gymOwner.setPhoneNumber(in.next());
        System.out.print("Enter PAN: ");
        gymOwner.setPanNumber(in.next());
        System.out.print("Enter Aadhaar: ");
        gymOwner.setAadharNumber(in.next());
        System.out.print("Enter Email: ");
        gymOwner.setEmail(in.next());
        System.out.print("Enter Password: ");
        gymOwner.setPassword(in.next());
        gymOwner.setRoleId("GymOwner");

        UserFlipFitService userFlipFitService = new UserFlipFitService();
        userFlipFitService.registerGymOwner(gymOwner);

        System.out.println("\n" + ColorConstants.CYAN + "Customer registered successfully!" + ColorConstants.RESET);
    }

    public void editProfile(Scanner in, String email) {
        System.out.println("Enter Details: ");
        System.out.print("Enter Name: ");
        gymOwner.setName(in.next());
        System.out.print("Enter Phone Number: ");
        gymOwner.setPhoneNumber(in.next());
        System.out.print("Enter PAN: ");
        gymOwner.setPanNumber(in.next());
        System.out.print("Enter Aadhaar: ");
        gymOwner.setAadharNumber(in.next());

        gymOwnerFlipFitService.editProfile(gymOwner, email);
    }

    public void viewProfile(Scanner in, String email) {
        gymOwner = gymOwnerFlipFitService.getProfile(email);
        System.out.println("______________________________________________________________");
        System.out.printf("%15s%15s%15s%15s", "Gym Owner Name", "Phone Number", "PAN Number", "Aadhaar Number");
        System.out.println();
        System.out.printf("%15s%15s%15s%15s", gymOwner.getName(), gymOwner.getPhoneNumber(),
                gymOwner.getPanNumber(), gymOwner.getAadharNumber());
        System.out.println("______________________________________________________________");

    }

    public void addGym(Scanner in, String email) {
        System.out.println("Enter Gym Details: ");

		Gym gym = new Gym();
		gym.setGymId(IdGenerator.generateId("Gym"));
		System.out.print("Enter GymName : ");
		gym.setGymName(in.next());
		gym.setOwnerEmail(email);
		System.out.print("Enter Address : ");
		gym.setAddress(in.next());
		System.out.print("Enter SlotCount : ");
		gym.setSlotCount(in.nextInt());
		System.out.print("Enter seatsPerSlotCount : ");
		gym.setSeatsPerSlotCount(in.nextInt());
		gym.setVerified(false);
		
        gymOwnerFlipFitService.addGym(gym);
    }

    public void editGym(Scanner in, String email) {
        System.out.println("Enter Gym Details: ");

        Gym gym = new Gym();
        System.out.print("Enter GymId: ");
        gym.setGymId(in.next());
        System.out.print("Enter GymName: ");
        gym.setGymName(in.next());
        gym.setOwnerEmail(email);
        System.out.print("Enter Address: ");
        gym.setAddress(in.next());
        System.out.print("Enter SlotCount: ");
        gym.setSlotCount(in.nextInt());
        System.out.print("Enter seatsPerSlotCount: ");
        gym.setSeatsPerSlotCount(in.nextInt());
        gym.setVerified(false);

        gymOwnerFlipFitService.editGym(gym);
    }

    public void getGymDetails(Scanner in, String email) {
        List<Gym> gymDetails = gymOwnerFlipFitService.getGymDetail(email);
        for (Gym gym : gymDetails) {
            System.out.println(gym);
        }
    }

	public void addSlot(Scanner in) {
		System.out.println("Enter Slot Details: ");
		Slot slot = new Slot();
		slot.setSlotId(IdGenerator.generateId("Slot"));
		System.out.print("Enter Gym Id:");
		slot.setGymId(in.next());
		System.out.print("Enter Slot Start Time: ");
		slot.setStartTime(in.next());
		System.out.print("Enter Slot End Time: ");
		slot.setEndTime(in.next());
		System.out.print("Enter number of seats in slot: ");
		slot.setNumOfSeats(in.nextInt());
		System.out.print("Enter Trainer: ");
		slot.setTrainer(in.next());
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
            System.out.println("7. Exit\n");

            int choice = in.nextInt();

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
                	addSlot(in);
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
        }

    }

}
