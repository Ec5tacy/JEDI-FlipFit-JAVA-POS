package com.flipkart.bean;

public class GymOwner {
    private int ownerId;
    private String ownerName;
    private String ownerEmailAddress;
    private int ownerPhone;
    private boolean isApproved;
    private String ownerAddress;

    private String GST;

    public String getGST() {
        return GST;
    }

    public void setGST(String GST) {
        this.GST = GST;
    }

    public String getPanCardGymOwner() {
        return panCardGymOwner;
    }

    public void setPanCardGymOwner(String panCardGymOwner) {
        this.panCardGymOwner = panCardGymOwner;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public byte[] getGymPictures() {
        return gymPictures;
    }

    public void setGymPictures(byte[] gymPictures) {
        this.gymPictures = gymPictures;
    }

    private String panCardGymOwner;

    private String state,district;

    private byte[] gymPictures;
    public int getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
    public String getOwnerName() {
        return ownerName;
    }
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    public String getOwnerEmailAddress() {
        return ownerEmailAddress;
    }
    public void setOwnerEmailAddress(String ownerEmailAddress) {
        this.ownerEmailAddress = ownerEmailAddress;
    }
    public int getOwnerPhone() {
        return ownerPhone;
    }
    public void setOwnerPhone(int ownerPhone) {
        this.ownerPhone = ownerPhone;
    }
    public boolean isApproved() {
        return isApproved;
    }
    public void setApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }
    public String getOwnerAddress() {
        return ownerAddress;
    }
    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }
}
