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

            System.out.println("<-----Enter your choice----->\n 1. Login \n 2.Registeratio0n of Gym Customer \n 3.Update Password \n 4.Exit");
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
