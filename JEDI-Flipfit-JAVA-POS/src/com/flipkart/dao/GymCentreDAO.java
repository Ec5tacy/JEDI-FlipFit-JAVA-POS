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

    @Override
    public void validateGymCentre(String gymCentreId, int isApproved) {

    }

    @Override
    public void sendCentreApprovalRequest(String gymCentreId) {

    }

    public class GymCentreManager {

        private List<Gymnasium> gymCentreList;

        public GymCentreManager(List<Gymnasium> gymCentreList) {
            this.gymCentreList = gymCentreList;
        }

        public void validateGymCentre(String gymCentreId, int isApproved) {
            // Assuming gymCentreList is a list of GymCentre objects
            for (Gymnasium gymCentre : gymCentreList) {
                if (gymCentre.getGymId().equals(gymCentreId)) {
                    gymCentre.setApproved(isApproved);
                    break;  // Assuming gymCentreId is unique, so we can break out of the loop
                }
            }
        }

        public void sendCentreApprovalRequest(String gymCentreId) {
            // Assuming gymCentreList is a list of GymCentre objects
            for (Gymnasium gymCentre : gymCentreList) {
                if (gymCentre.getGymId().equals(gymCentreId)) {
                    gymCentre.setApproved(2);
                    break;  // Assuming gymCentreId is unique, so we can break out of the loop
                }
            }
        }
    }

    public List<Gymnasium> getGymCentreListByCity(String city) {
        List<Gymnasium> allCentreByCity = new ArrayList<>();

        // You can replace the database logic with another mechanism or data source if needed
        // For simplicity, I'll assume you have a method to retrieve gym data

        List<Gymnasium> allGyms = getAllGyms(); // Replace this with your actual data retrieval logic

        for (Gymnasium gymnasium : allGyms) {
            if (gymnasium.getCity().equals(city)) {
                allCentreByCity.add(gymnasium);
            }
        }

        return allCentreByCity;
    }

    // Replace this method with your actual data retrieval logic
    private List<Gymnasium> getAllGyms() {
        // Example: Assuming you have a list of Gymnasiums stored somewhere
        // Replace this with your actual data retrieval logic (e.g., reading from a file, calling an API, etc.)
        List<Gymnasium> allGyms = new ArrayList<>();

        // Add some sample gymnasiums
        allGyms.add(new Gymnasium("1", "1", "Gym1", 1200, 40, 100, "asdf"));
        allGyms.add(new Gymnasium("2", "2", "Gym2", 2000 , 30, 150, "ghjk"));
        allGyms.add(new Gymnasium("3", "1", "Gym3", 40000, 20, 120, "rtyu"));

        return allGyms;
    }


//    public List<Gymnasium> getGymCentreListByCity(String city) {
//        List<Gymnasium> allCentreByCity = new ArrayList<>();
//        try {
//            conn = DBConnection.connect();
//            System.out.println("Fetching gyms centres by City..");
//            statement = conn.prepareStatement(SQLConstants.FETCH_GYM_CENTRES_BY_CITY);
//            statement.setString(1, city);
//            ResultSet rs = statement.executeQuery();
//            while(rs.next()) {
//                Gymnasium gymnasium = new Gymnasium(
//                        rs.getString("centreId"),
//                        rs.getString("ownerId"),
//                        rs.getString("centreName"),
//                        rs.getString("gstin"),
//                        rs.getString("city"),
//                        rs.getInt("capacity"),
//                        rs.getInt("price")
//                );
//                allCentreByCity.add(gymnasium);
//            }
//            //System.out.println("The gym centre has been approved!");
//        } catch (SQLException se) {
//            // Handle errors for JDBC
//            se.printStackTrace();
//        } catch (Exception e) {
//            // Handle errors for Class.forName
//            e.printStackTrace();
//        }
////        for(GymCentre gymCentre: gymCentreList){
////            if(gymCentre.getCity().equals(city)){
////                allCentreByCity.add(gymCentre);
////            }
////        }
//        return allCentreByCity;
//    }
}