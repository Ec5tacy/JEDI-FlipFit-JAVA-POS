
package com.flipkart.bean;

import java.time.LocalDate;
import java.time.LocalTime;

public class Registration {
    private String customerId; // Customer ID of the registration.
    private String name; // Name of the customer.
    private String mobile; // Mobile number of the customer.
    private String email; // Email address of the customer.
    private String address; // Address of the customer.
    private LocalDate dob; // Date of birth of the customer.

    private String aadhaarNumber; // Aadhaar number of the customer.
    private String panNumber; // PAN number of the customer.
    private String gstNumber; // GST number of the customer.

    private int roleId; // Role ID of the customer.
    private String password; // Password for the registration.

    private String registrationId; // Registration ID of the customer.
    private LocalDate registrationDate; // Registration date.
    private LocalTime registrationTime; // Registration time.


    public Registration() {

    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getMobile() {
        return mobile;
    }


    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public LocalDate getDob() {
        return dob;
    }


    public void setDob(LocalDate dob) {
        this.dob = dob;
    }


    public String getAadhaarNumber() {
        return aadhaarNumber;
    }


    public void setAadhaarNumber(String aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
    }

    /**
     * Returns the PAN number of the customer.
     *
     * @return the PAN number
     */
    public String getPanNumber() {
        return panNumber;
    }

    /**
     * Sets the PAN number for the customer.
     *
     * @param panNumber the PAN number to set
     */
    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    /**
     * Returns the GST number of the customer.
     *
     * @return the GST number
     */
    public String getGstNumber() {
        return gstNumber;
    }

    /**
     * Sets the GST number for the customer.
     *
     * @param gstNumber the GST number to set
     */
    public void setGstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
    }

    /**
     * Returns the role ID of the customer.
     *
     * @return the role ID
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * Sets the role ID for the customer.
     *
     * @param roleId the role ID to set
     */
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    /**
     * Returns the password for the registration.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password for the registration.
     *
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the registration ID of the customer.
     *
     * @return the registration ID
     */
    public String getRegistrationId() {
        return registrationId;
    }

    /**
     * Sets the registration ID for the customer.
     *
     * @param registrationId the registration ID to set
     */
    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    /**
     * Returns the registration date.
     *
     * @return the registration date
     */
    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    /**
     * Sets the registration date.
     *
     * @param registrationDate the registration date to set
     */
    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    /**
     * Returns the registration time.
     *
     * @return the registration time
     */
    public LocalTime getRegistrationTime() {
        return registrationTime;
    }

    /**
     * Sets the registration time.
     *
     * @param registrationTime the registration time to set
     */
    public void setRegistrationTime(LocalTime registrationTime) {
        this.registrationTime = registrationTime;
    }
}