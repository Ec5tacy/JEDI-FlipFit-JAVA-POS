package com.flipkart.client;
import java.util.Scanner;
public class LandingPage {
    public static void main (String args[])
    {
       // System.out.println("<-----Welcome to Flip Application----->");
        Scanner in = new Scanner(System.in);
       // System.out.println("<-----Enter your choice----->\n 1. Login \n 2.Registeratio0n of Gym Customer \n 3.Update Password \n 4.Exit");
        int choice=0;
        while(choice != 4) {
            System.out.println("<-----Welcome to Flip Application----->");

            System.out.println("<-----Enter your choice----->\n 1. Login \n 2.Registration of Gym Customer \n 3.Update Password \n 4.Exit");
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
                    System.out.println("Enter the Role---- 1.Gym Customer 2. Gym Owner 3. GymFlipFit ADMIN");
                    role = in.nextInt();


                    switch (role) {
                        case 1:
                            System.out.println("Opening Customer Menu Page");
                            //calling admin menu object
                            break;

                        case 2:
                            int ch=0;
                            while(ch!=8) {
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
                                        String timings, centre, seats;
                                        System.out.println("Enter Slot Timings: ");
                                        timings = in.nextLine();

                                        System.out.println("Enter Slot Center: ");
                                        centre = in.nextLine();

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
                                        centre = in.nextLine();

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

                            System.out.println("Opening GymFlipFit ADMIN");

                        default:
                            System.out.println("Wrong details entered");
                    }
                    break;

                case 2:
                    //registeration of gym customer
                    break;


                default:
                    System.out.println("Invalid Credentials");
            }
        }
    }
}
