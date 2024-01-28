package com.flipkart.client;

import java.util.*;

import com.flipkart.bean.User;
import com.flipkart.service.UserFlipFitServiceImpl;
import com.flipkart.constants.*;
import com.flipkart.exception.UserNotFoundException;

public class ApplicationFlipFitClient {

	public static void login() throws Exception {
		Scanner in = new Scanner(System.in);

		System.out.println("__________________________________________________________________________________\n");
		System.out.println("Enter LogIn Details\n");
		System.out.print("Enter Email: ");
		String userEmail = in.next();
		System.out.print("Enter Password: ");
		String password = in.next();
		System.out.print("Enter Role ID: 1. Customer 2. Gym Owner 3. Gym Administrator ");
		String roleCode = in.next();
		String roleId="Admin";
		if(roleCode.equals("1"))//tokenising the role id
		{
			roleId = "Customer";
		}
		if(roleCode.equals("2")) {
			roleId = "GymOwner";
		}
		User user = new User(userEmail, password, roleId);
		UserFlipFitServiceImpl userBusiness = new UserFlipFitServiceImpl();
		if (roleId.equalsIgnoreCase("Admin")) {
			AdminFlipFitClient admin = new AdminFlipFitClient();
			admin.adminMenu(in);
			return;
		}
		try {
			userBusiness.authenticateUser(user);
			System.out.println("__________________________________________________________________________________\n");
			System.out.println(
					ColorConstants.GREEN + "Welcome " + userEmail + "! You are logged in. " + "(" + new Date() + ")" + ColorConstants.RESET);

			if (roleId.equalsIgnoreCase("Customer")) {

				CustomerFlipFitClient customer = new CustomerFlipFitClient();
				customer.customerMenu(userEmail);

			} else if (roleId.equalsIgnoreCase("GymOwner")) {

				GymOwnerFlipFitClient gymOwner = new GymOwnerFlipFitClient();
				gymOwner.gymOwnerMenu(in, userEmail);

			} else {
				System.out.println(ColorConstants.RED + "Wrong Choice!" + ColorConstants.RESET);
			}
		} catch(UserNotFoundException e) {
			System.out.println(ColorConstants.RED + e.getMessage() + ColorConstants.RESET);
		}
	}

	public static void applicationMenu() throws Exception {
		boolean recur = true;

		int choice=0;
		while (choice!=4) {
			System.out.println(ColorConstants.GREEN + "Welcome to the FlipFit Application!" + ColorConstants.RESET);
			System.out.println("_______________________________________");
			System.out.println("\nChoose your action:");
			System.out.println("1. Login");
			System.out.println("2. Customer Registration");
			System.out.println("3. Gym Owner Registration");
			System.out.println("4. Exit");
			System.out.print("\nEnter Your Choice: ");

			Scanner in = new Scanner(System.in);

			choice = in.nextInt();
			in.nextLine();
			switch (choice) {
				case 1:
					login();
					break;
				case 2:
					CustomerFlipFitClient customer = new CustomerFlipFitClient();
					customer.registerCustomer();
					login();
					break;
				case 3:
					GymOwnerFlipFitClient owner = new GymOwnerFlipFitClient();
					owner.gymOwnerRegistration(in);
					login();
					break;
				case 4:
					System.out.println(ColorConstants.RED + "Exiting..." + ColorConstants.RESET);
					System.out.println(ColorConstants.GREEN + "Exited Successfully" + ColorConstants.RESET);
					recur = false;
					System.exit(0);
					break;
				default:
					System.out.println(ColorConstants.RED + "Wrong choice" + ColorConstants.RESET);
			}
		}

	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		applicationMenu();
	}

}
