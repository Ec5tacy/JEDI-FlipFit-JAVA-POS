package com.flipkart.dao;

import com.flipkart.bean.Gym_Owner;

import java.util.List;

public interface GymOwnerInterfaceDAO {

    List<Gym_Owner> getGymOwnerList();

    void setGymOwnerList(List<Gym_Owner> gymOwnerList);

    void registerGymOwner(Gym_Owner gymOwner);

    List<Gym_Owner> getPendingGymOwnerList();

    void sendOwnerApprovalRequest(String gymOwnerId);

    void setPendingGymOwnerList();

    void validateGymOwner(String gymOwnerId, int isApproved);
}