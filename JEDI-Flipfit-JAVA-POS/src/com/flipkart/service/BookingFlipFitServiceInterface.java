package com.flipkart.service;


public interface BookingFlipFitServiceInterface {

    public boolean isConfirmed(String bookingId);
    /*
    Returns true if the booking is confirmed and false if its waitlisted
    */

    public int getWaitingList();
    /*
    Returns the waitlist number if the booking is in waitlist
    */
}