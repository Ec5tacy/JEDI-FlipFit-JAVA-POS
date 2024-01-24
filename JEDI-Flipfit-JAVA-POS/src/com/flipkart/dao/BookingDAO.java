package com.flipkart.dao;
import com.flipkart.bean.BookedSlot;
import com.flipkart.bean.Slots;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class BookingDAO {

    public BookingDAO() {
    }



    public void  addBooking(String userName, String scheduleID) {
    }
    public List<Slots> getBookingByCustomerId(String customerId) {
        List<Slots> allBookingList = new ArrayList<>();

        return allBookingList;
    }

    public List<BookedSlot> getCustomerPlan(String customerId) {
        List<BookedSlot> allUserPlan = new ArrayList<>();
        List<Slots> allBookingList = getBookingByCustomerId(customerId);
        for (Slots booking : allBookingList) {


        return allUserPlan;
    }
        


    public void cancelBookingById(String Object bookingID = null;
        bookingID) {
       
    }

    public Slots getBookingByBookingId(String Object bookingId;
        bookingId){
            Slots booking  = null;
       
        return booking;
    }
}