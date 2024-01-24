package com.flipkart.dao;

import com.flipkart.bean.Gymnasium;
import com.flipkart.bean.Gym_Owner;
import java.util.List;
public class AdminDAO implements com.flipkart.dao.AdminInterfaceDAO {

    private static GymOwnerInterfaceDAO gymOwnerDAO = new gymOwnerDAO();
    private static  GymOwnerInterfaceDAO = new GymCentreDAO();

    public List<Gym_Owner> getPendingGymOwners() {
        return gymOwnerDAO.getPendingGymOwnerList();
    }

    public void validateGymOwner(String gymOwnerId, int isApproved) {
        gymOwnerDAO.validateGymOwner(gymOwnerId, isApproved);
    }

    public void validateGymCentre(String gymCentreId, int isApproved) {
    }

    public List<Gymnasium> getPendingGymCentres() {
        return GymCentreDAO.getPendingGymCentreList();
    }

}