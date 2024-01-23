package com.flipkart.service;

public class Gym_Owner_Service {
    public String getOwnerDetails(){
        return "get Owner Details";
    }

    public boolean viewAllSlots(int id) {
        System.out.println("view All Slots");
        return true;
    }

    public boolean isApprovedGymOwner(int id) {
        System.out.println("is Approved Gym Owner");
        return true;
    }


    public void addSlots() {
        System.out.println("add slots");
    }

    public boolean createSlot(int id) {
        System.out.println("create slot");
        return true;
    }

}