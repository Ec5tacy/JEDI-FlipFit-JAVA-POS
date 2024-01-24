package com.flipkart.dao;

import com.flipkart.bean.Gym_Owner;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GymOwnerDAO implements GymOwnerInterfaceDAO {
    List<Gym_Owner> gymOwnerList;

    public GymOwnerDAO() {
    }

    public List<Gym_Owner> getGymOwnerList() {

        List<Gym_Owner> resGymOwnerList = new ArrayList<>();

        this.setGymOwnerList(resGymOwnerList);
        return gymOwnerList;
    }

    public void setGymOwnerList(List<Gym_Owner> gymOwnerList) {
        this.gymOwnerList = gymOwnerList;
    }

    public boolean loginGymOwner(String username, String password) {
        return false;
    }

    public void registerGymOwner(Gym_Owner gymOwner) {

        public List<Gym_Owner> getPendingGymOwnerList () {

            List<Gym_Owner> pendingList = new ArrayList<>();


        }

    }
}