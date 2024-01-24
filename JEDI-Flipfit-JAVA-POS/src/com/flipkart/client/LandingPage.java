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
            System.out.println("<-----Welcome to FlipFit----->");

            System.out.println("<-----Enter your choice----->\n 1.Login \n 2.Registration of Gym Customer \n 3.Update Password \n 4.Exit");
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
                            System.out.println("----Choose the following options------");
                            System.out.println("1. Select a GYM on the basis of location \n 2. View Booked Slots \n 3. Modify Personal Details");
                            int customerChoice = in.nextInt();
                            switch(customerChoice)
                            {
                                case 1:
                                    System.out.println("Select the location of your GYM:\n 1. Marathalli \n 2. ETV");
                                    int locChoice = in.nextInt();
                                    switch(locChoice)
                                    {
                                        case 1:
                                            System.out.println("GYMS at Marathalli \n1.GYM A\n 2. GYM B");
                                            int gymChoiceMarathalli= in.nextInt();
                                            switch(gymChoiceMarathalli)
                                            {
                                                case 1:
                                                    System.out.println("1. View slot \n 2. Book a slot \n 3. Cancel slot");
                                                    break;
                                                case 2:
                                                    System.out.println("1. View slot \n 2. Book a slot \n 3. Cancel slot");
                                                    break;
                                            }
                                            break;
                                        case 2:
                                            System.out.println("GYMS at ETV \n1.GYM C\n 2. GYM D");
                                            int gymChoiceETV= in.nextInt();
                                            switch(gymChoiceETV)
                                            {
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
                                    System.out.println("Here are your Current Bookinga");
                                    break;


                                case 3:
                                    System.out.println("Modify personal details page");
                                    break;

                                default:
                                    System.out.println("Wrong Selection");




                            }
                            break;

                        case 2:
                            System.out.println("Opening Gym Owner Page");
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
