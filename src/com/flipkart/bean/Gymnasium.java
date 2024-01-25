package com.flipkart.bean;
import java.util.ArrayList;

public class Gymnasium
{
    private String gymId; // ID of the gymnasium.
    private String ownerId; // ID of the gym owner.
    private ArrayList<Integer> slotAvailable;
    private int capacity;
    private String name; // Name of the gymnasium.

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private String city;
    private String address; // Address of the gymnasium.
    private double totalArea; // Total area of the gymnasium.
    private int numItem; // Number of items in the gymnasium.
    private int approved; // Approval status of the gymnasium.


    public Gymnasium() {

    }
    public Gymnasium(String gymId, String name, String address, double totalArea, int numItem, int approved, String ownerId) {
        this.gymId = gymId;
        this.ownerId = ownerId;
        this.name = name;
        this.address = address;
        this.totalArea = totalArea;
        this.numItem = numItem;
        this.approved = approved;
    }


    public ArrayList<Integer> getSlotAvailable() {
        return slotAvailable;
    }

    public void setSlotAvailable(ArrayList<Integer> slotAvailable) {
        this.slotAvailable = slotAvailable;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getApproved()
    {
        return approved;
    }
    public String getGymId() {
        return gymId;
    }


    public void setGymId(String gymId) {
        this.gymId = gymId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public double getTotalArea()
    {
        return totalArea;
    }

    public void setTotalArea(double totalArea) {
        this.totalArea = totalArea;
    }
    public int getNumItem()
    {
        return numItem;
    }


    public void setNumItem(int numItem) {
        this.numItem = numItem;
    }


    public String getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
    public int isApproved() {
        return approved;
    }


    public void setApproved(int approved) {
        this.approved = approved;
    }
}
