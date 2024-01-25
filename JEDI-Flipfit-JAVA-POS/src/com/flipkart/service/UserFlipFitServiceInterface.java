package com.flipkart.service;

import com.flipkart.bean.*;


public interface UserFlipFitServiceInterface {

    public boolean registerCustomer(Customer customer);
    /*
    Registers a new customer
    */

    public boolean registerGymOwner(GymOwner gymOwner);
    /*
    Registers a new Gym Owner
    */

    public boolean authenticateUser(User user);
    /*
    Authenticates a user
    */

    public boolean logout(User user);
    /*
    Logs out a user
    */
}