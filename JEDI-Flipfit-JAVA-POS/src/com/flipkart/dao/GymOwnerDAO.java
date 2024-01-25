package com.flipkart.dao;

import com.flipkart.bean.GymOwner;


import java.util.ArrayList;
import java.util.List;

public class GymOwnerDAO implements GymOwnerInterfaceDAO {
    List<GymOwner> gymOwnerList;

    public GymOwnerDAO() {
    }

    public List<GymOwner> getGymOwnerList() {

        List<GymOwner> resGymOwnerList = new ArrayList<>();

        this.setGymOwnerList(resGymOwnerList);
        return gymOwnerList;
    }

    public void setGymOwnerList(List<GymOwner> gymOwnerList) {
        this.gymOwnerList = gymOwnerList;
    }

    public boolean loginGymOwner(String username, String password) {
        return false;
    }

    public void registerGymOwner(GymOwner gymOwner) {

    }

    @Override
    public List<GymOwner> getPendingGymOwnerList() {
        return null;
    }

    @Override
    public void sendOwnerApprovalRequest(String gymOwnerId) {

    }

    @Override
    public void setPendingGymOwnerList() {

    }

    @Override
    public void validateGymOwner(String gymOwnerId, int isApproved) {

    }
}