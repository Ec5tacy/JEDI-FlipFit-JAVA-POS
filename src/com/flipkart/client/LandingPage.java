package com.flipkart.client;
import java.util.Scanner;
public class LandingPage {
    public static void main (String args[])
    {
        // System.out.println("<-----Welcome to Flip Application----->");
        Scanner in = new Scanner(System.in);
        // System.out.println("<-----Enter your choice----->\n 1. Login \n 2. Registration of Gym Customer \n 3. Update Password \n 4.Exit");
        int choice=0;
        while(choice != 4) {
            System.out.println("<-----Welcome to Flip Application----->");

            System.out.println("<-----Enter your choice----->\n 1. Login \n 2. Registration of Gym Customer \n 3. Registration of Gym Owner \n 4. Exit");
            choice = in.nextInt();
            in.nextLine();
            switch (choice) {
                case 1:
                    //login service opens
                    String username;
                    System.out.println("Enter the UserName----");
                    username = in.nextLine();
                    String password;
                    int role;

                    System.out.println("Enter the Password----");
                    password = in.nextLine();
                    System.out.println("Enter the Role---- 1.Gym Customer 2.Gym Owner 3.GymFlipFit ADMIN");
                    role = in.nextInt();


                    switch (role) {
                        case 1:
                            int customerChoice = 0;
                            while(customerChoice != 4) {
                                System.out.println("Opening Customer Menu Page");
                                System.out.println("----Choose the following options------");
                                System.out.println("1. Select a GYM on the basis of location \n 2. View Booked Slots \n 3. Modify Personal Details \n 4. Exit");
                                customerChoice = in.nextInt();
                                switch (customerChoice) {
                                    case 1:
                                        System.out.println("Select the location of your GYM:\n 1. Marathalli \n 2. ETV");
                                        int locChoice = in.nextInt();
                                        switch (locChoice) {
                                            case 1:
                                                System.out.println("GYMS at Marathalli \n1. GYM A\n 2. GYM B");
                                                int gymChoiceMarathalli = in.nextInt();
                                                switch (gymChoiceMarathalli) {
                                                    case 1:
                                                        System.out.println("1. View slot \n 2. Book a slot \n 3. Cancel slot");
                                                        break;
                                                    case 2:
                                                        System.out.println("1. View slot \n 2. Book a slot \n 3. Cancel slot");
                                                        break;
                                                }
                                                break;
                                            case 2:
                                                System.out.println("GYMS at ETV \n1. GYM C\n 2. GYM D");
                                                int gymChoiceETV = in.nextInt();
                                                switch (gymChoiceETV) {
                                                    case 1:
                                                        System.out.println("1. View slot \n 2. Book a slot \n 3. Cancel slot");
                                                        break;
                                                    case 2:
                                                        System.out.println("1. View slot \n 2. Book a slot \n 3. Cancel slot");
                                                        break;
                                                }
                                                break;


                                        }

                                        break;

                                    case 2:
                                        System.out.println("Here are your Current Bookings");
                                        break;


                                    case 3:
                                        System.out.println("Modify personal details page");
                                        break;

                                    default:
                                        System.out.println("Wrong Selection");


                                }
                            }
                            break;

                        case 2:
                            int ch = 0;
                            while (ch != 8) {
                                System.out.println("Welcome to gym owner portal: ");
                                System.out.println("Enter your choice : \n 1. View Profile \n 2. Edit Profile \n 3. Edit slots \n 4. Register Center \n 5. Add new slots \n 6. View Registered Gyms \n 7. View Slots \n 8. Exit");
                                ch = in.nextInt();
                                in.nextLine();

                                switch (ch) {
                                    case 1:
                                        System.out.println("Gym Name: - -");
                                        System.out.println("Gym Address: - - \n No of slots : - \n No of centers: 0 \n Gym owner: - \n Slot timings : \n Instructor Details: -");
                                        break;

                                    case 2:
                                        String name, location, noOfCentres, noOfSlots, GymOwner, slotTimings, instructorDetails;
                                        System.out.println("Enter name: ");
                                        name = in.nextLine();

                                        System.out.println("Enter address: ");
                                        location = in.nextLine();

                                        System.out.println("Enter no of slots: ");
                                        noOfSlots = in.nextLine();

                                        System.out.println("Enter gym owner: ");
                                        GymOwner = in.nextLine();

                                        System.out.println("Enter slot timings: ");
                                        slotTimings = in.nextLine();

                                        System.out.println("Enter instructor details: ");
                                        instructorDetails = in.nextLine();

                                        System.out.println("Enter no of centers: ");
                                        noOfCentres = in.nextLine();
                                        break;

                                    case 3:
                                        String timings, center, seats;
                                        System.out.println("Enter Slot Timings: ");
                                        timings = in.nextLine();

                                        System.out.println("Enter Slot Center: ");
                                        center = in.nextLine();

                                        System.out.println("Enter No of Seats: ");
                                        seats = in.nextLine();

                                        break;

                                    case 4:
                                        String branchName, centerLocation, centerManager;
                                        System.out.println("Enter branch name: ");
                                        branchName = in.nextLine();

                                        System.out.println("Enter branch location: ");
                                        branchName = in.nextLine();

                                        System.out.println("Enter Center Manager: ");
                                        branchName = in.nextLine();
                                        break;

                                    case 5:
                                        String slotTiming, slotCentre, slotSeats;
                                        System.out.println("Enter Slot Timings: ");
                                        slotTiming = in.nextLine();

                                        System.out.println("Enter Slot Center: ");
                                        center = in.nextLine();

                                        System.out.println("Enter No of Seats: ");
                                        seats = in.nextLine();

                                        break;

                                    case 6:
                                        System.out.println("Registered Gyms: ");
                                        System.out.println("Center 1 \n  Name : \n Location: \n Instructor:  ");
                                        System.out.println("Center 2 \n  Name : \n Location: \n Instructor:  ");
                                        System.out.println("Center 3 \n  Name : \n Location: \n Instructor:  ");
                                        break;

                                    case 7:
                                        System.out.println("Registered Slots: ");
                                        System.out.println("Slot 1 \n  Timings : \n Center: \n Instructor:  ");
                                        System.out.println("Slot 2 \n  Timings : \n Center: \n Instructor:  ");
                                        System.out.println("Slot 3 \n  Timings : \n Center: \n Instructor:  ");
                                        break;
                                    default:
                                        break;
                                }
                            }
                            break;

                        case 3:
                            int adminChoice = 0;
                            while(adminChoice != 5) {
                                System.out.println("Opening GymFlipFit ADMIN");
                                System.out.println("<-----Enter your choice----->\n 1.View pending gym owner registration request \n 2.Approve gym owner registration \n3.Approve gym registrations \n 4.View pending gym registration requests \n 5.Exit");
                                adminChoice = in.nextInt();
                                switch (adminChoice) {
                                    case 1:
                                        System.out.println("These are the pending gym owner registration requests/n");
                                        break;
                                    case 2:
                                        System.out.println(("Admin is approving a gym owner"));
                                        break;
                                    case 3:
                                        System.out.println("These are the pending gym registration requests");
                                        break;
                                    case 4:
                                        System.out.println("Approving the gym request");
                                        break;
                                    default:
                                        break;
                                }
                            }
                            break;
                    }
                case 2:
                    //registration of gym customer
                    break;
                case 3:
                    //registration of gym owner
                    break;
                case 4:
                    System.out.println("Thank You for visiting our portal :) ");
                    break;
                default:
                    System.out.println("Invalid Credentials");
            }
        }
    }
}