package com.flipkart.client;

import com.flipkart.service.Customer_Service;

public class CustomerClient {


    String name, mob, email,loc;
    Customer_Service cs = new Customer_Service(name,mob,email,loc);

    }
}
