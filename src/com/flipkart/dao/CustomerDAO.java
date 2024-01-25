package com.flipkart.dao;

import com.flipkart.bean.Customer;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CustomerDAO implements com.flipkart.dao.CustomerInterfaceDAO {

    public void registerCustomer(String userName, String password, String email, String phoneNumber, String cardNumber)  {// make object of the Customer details
    }

    public boolean isUserValid(String userName, String password) { return true;
    }

    public Customer getCustomerById(String userName) {
        Customer customer = new Customer();

        return customer;
    }
    public boolean checkRegisteredCustomer(String emailId){
        return true;
    }
    public void deleteCustomer(Customer customer)
    {

    }
    public void updateCustomer(Customer customer){

    }
}