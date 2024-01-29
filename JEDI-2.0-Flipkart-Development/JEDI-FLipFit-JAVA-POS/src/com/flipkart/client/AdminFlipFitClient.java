package com.flipkart.client;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.service.*;

import java.util.*;

/**
 * 
 */

public class AdminFlipFitClient {

	AdminFlipFitServiceImpl adminBusiness = new AdminFlipFitServiceImpl();
	List<GymOwner> gymOwnerList = adminBusiness.getGymOwners();
	List<Gym> gymList = adminBusiness.getGym();
	Scanner sc = new Scanner(System.in);
	
	public void viewAllPendingGymOwnerRequests() {

		viewAllGymOwners(adminBusiness.viewAllPendingGymOwnerRequests());
	}
	public void viewAllPendingGymRequests() {

		viewAllGyms(adminBusiness.viewAllPendingGymRequests());
	}

	public void approveSingleGymOwnerRequest() {
		System.out.print("Enter the email to approve: ");
		adminBusiness.approveSingleGymOwnerRequest(sc.next());
	}

	public void approveSingleGymRequest() {
		System.out.print("Enter gym Id to approve: ");
		adminBusiness.approveSingleGymRequest(sc.next());
	}

	public void approvePendingGymOwnerRequests() {
		adminBusiness.approveAllPendingGymOwnerRequests();
		System.out.println("All pending gym owner requests approved successfully.");
	}

	public void approvePendingGymRequests() {
		adminBusiness.approveAllPendingGymRequests();
		System.out.println("All pending gym requests approved successfully.");
	}

	public void adminMenu(Scanner in) throws Exception {
		System.out.println("================= Admin FlipFit =================");
		while (true) {
			System.out.println("1. View All Gyms");
			System.out.println("2. View All Gym Owners");
			System.out.println("3. View All Pending Gym Owner Requests");
			System.out.println("4. View All Pending Gym Requests");
			System.out.println("5. Approve All Pending Gym Owner Requests");
			System.out.println("6. Approve All Pending Gym Requests");
			System.out.println("7. Approve Single Gym Owner Request");
			System.out.println("8. Approve Single Gym Request");
			System.out.println("9. Exit");

			System.out.print("Enter your choice: ");
			int choice = in.nextInt();
			switch (choice) {
				// Case statements
				case 1:
					viewAllGyms(gymList);
					break;
				case 2:
					viewAllGymOwners(gymOwnerList);
					break;
				case 3:
					viewAllPendingGymOwnerRequests();
					break;
				case 4:
					viewAllPendingGymRequests();
					break;
				case 5:
					approvePendingGymOwnerRequests();
					break;
				case 6:
					approvePendingGymRequests();
					break;
				case 7:
					approveSingleGymOwnerRequest();
					break;
				case 8:
					approveSingleGymRequest();
					break;
				case 9:
					System.out.println("Exiting Admin FlipFit. Goodbye!");
					return;
				// Default case statement
				default:
					System.out.println("Invalid choice. Please enter a valid option.");
			}
		}
	}

	public void viewAllGyms(List<Gym> gyms) {
		System.out.println("========================================== All Gyms ==========================================");
		for (Gym gym : gyms) {
			System.out.printf("%15s%15s%15s%15s%15s%15s","Gym ID", "Name", "Owner Email", "Address", "Slot Count", "Verification");
			System.out.println();
			System.out.printf("%15s%15s%15s%15s%15s%15s", gym.getGymId(), gym.getGymName(), gym.getOwnerEmail(), gym.getAddress(), gym.getSlotCount(), (gym.isVerified() ? "Approved" : "Pending"));
			System.out.println();
			System.out.println("==============================================================================================");
		}
	}

	public void viewAllGymOwners(List<GymOwner> gymOwners) {
		System.out.println("================= All Gym Owners =================");
		for (GymOwner gymOwner : gymOwners) {
			System.out.println("Name: " + gymOwner.getName());
			System.out.println("Phone Number: " + gymOwner.getPhoneNumber());
			System.out.println("Aadhar Number: " + gymOwner.getAadharNumber());
			System.out.println("PAN Number: " + gymOwner.getPanNumber());
			System.out.println("Verification: " + (gymOwner.isVerified() ? "Approved" : "Pending"));
			System.out.println("===================================================");
		}
	}
}
