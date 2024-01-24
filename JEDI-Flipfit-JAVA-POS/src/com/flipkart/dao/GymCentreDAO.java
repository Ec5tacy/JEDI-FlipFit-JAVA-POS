package com.flipkart.dao;

import com.flipkart.bean.Gymnasium;
import com.flipkart.dao.GymCentreInterfaceDAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class GymCentreDAO implements GymCentreInterfaceDAO {



    public GymCentreDAO() {
    }

    // api call to retrieve all gym centres and status
    public List<Gymnasium> getAllCentresByOwnerId(String gymOwnerId)  {

        List<Gymnasium> allGymCentres = new ArrayList<>();
        return allGymCentres;
    }



    public Gymnasium getGymCentreByCentreId(String gymCentreId){
        Gymnasium gymCentre = new Gymnasium();
        return gymCentre;

    }

    public void addGymCentre(Gymnasium centre) {

    }
    public List<Gymnasium> getPendingGymCentreList() {
        List<Gymnasium> pendingList = new ArrayList<>();
        return pendingList;
    }

    public void validateGymCentre(String gymCentreId, int isApproved) {
//        System.out.println("IN VALIDATE GYM CENTRE");
        try {
            conn = DBConnection.connect();
            System.out.println("Fetching gyms centres..");

            statement = conn.prepareStatement(SQLConstants.SQL_APPROVE_GYM_CENTRE_BY_ID_QUERY);
            statement.setInt(1, isApproved);
            statement.setString(2, gymCentreId);
            statement.executeUpdate();
//            System.out.println("The gym centre has been approved!");
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        }
//        for(GymCentre gymCentre : gymCentreList) {
//            if(gymCentre.getGymCentreID().equals(gymCentreId)) {
//                gymCentre.setApproved(isApproved);
//            }
//        }
//        for(GymCentre gymCentre : pendingGymCentreList) {
//            if(gymCentre.getGymCentreID().equals(gymCentreId)) {
//                pendingGymCentreList.remove(gymCentre);
//            }
//        }
    }

    public void sendCentreApprovalRequest(String gymCentreId){
        try {
            conn = DBConnection.connect();
            System.out.println("Sending gym centre approval request..");
            // SQL_APPROVE_GYM_CENTRE_BY_ID_QUERY="Update GymCentre Set isApproved=? WHERE centreId=?";
            statement = conn.prepareStatement(SQLConstants.SQL_APPROVE_GYM_CENTRE_BY_ID_QUERY);
            statement.setInt(1,2);
            statement.setString(2, gymCentreId);
            statement.executeUpdate();

        } catch (SQLException se) { se.printStackTrace(); }
        catch (Exception e) { e.printStackTrace(); }
    }

    public List<GymCentre> getGymCentreListByCity(String city) {
        List<GymCentre> allCentreByCity = new ArrayList<>();
        try {
            conn = DBConnection.connect();
            System.out.println("Fetching gyms centres by City..");
            statement = conn.prepareStatement(SQLConstants.FETCH_GYM_CENTRES_BY_CITY);
            statement.setString(1, city);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                GymCentre gymCentre = new GymCentre(
                        rs.getString("centreId"),
                        rs.getString("ownerId"),
                        rs.getString("centreName"),
                        rs.getString("gstin"),
                        rs.getString("city"),
                        rs.getInt("capacity"),
                        rs.getInt("price")
                );
                allCentreByCity.add(gymCentre);
            }
            //System.out.println("The gym centre has been approved!");
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        }
//        for(GymCentre gymCentre: gymCentreList){
//            if(gymCentre.getCity().equals(city)){
//                allCentreByCity.add(gymCentre);
//            }
//        }
        return allCentreByCity;
    }
}