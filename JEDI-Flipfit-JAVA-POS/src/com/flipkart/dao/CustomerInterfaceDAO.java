package com.flipkart.dao;

import com.flipkart.bean.Customer;

public interface CustomerInterfaceDAO {

    void registerCustomer(String userName, String password, String email, String phoneNumber, String cardNumber);
    boolean isUserValid(String userName, String password);
    Customer getCustomerById(String userName);
}