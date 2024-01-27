/**
 * 
 *//**
 *
 */
package com.flipkart.business;

import com.flipkart.DAO.GymOwnerDAOImpl;
import com.flipkart.DAO.UserDAOImpl;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.exception.UserAlreadyExistsException;
import com.flipkart.exception.UserNotFoundException;

/**
 *
 */
public class UserBusiness implements UserBusinessInterface{

	GymOwnerDAOImpl gymOwnerDao = new GymOwnerDAOImpl();
	UserDAOImpl userDao = new UserDAOImpl();
	/**
	 Registers a customer in the system.
	 @param customer The Customer object representing the customer data
	  * @throws UserAlreadyExistsException
	 */
	public void registerCustomer(Customer customer) throws UserAlreadyExistsException {
		if (!(userDao.registerCustomer(customer)))
			throw new UserAlreadyExistsException();
	}
	/**
	 Registers a gym owner in the system.
	 @param gymOwner The gym owner object representing the gym owner data
	  * @throws UserAlreadyExistsException
	 */
	public void registerGymOwner(GymOwner gymOwner) throws UserAlreadyExistsException {
		if (!(userDao.registerGymOwner(gymOwner)))
			throw new UserAlreadyExistsException();
	}
	/**
	 Verifies a user's data.
	 @param user The user object representing the user data
	 @return true if the user's data are valid else returns false
	  * @throws UserNotFoundException
	 */
	public void authenticateUser(User user) throws UserNotFoundException {
		if (!(userDao.authenticateUser(user)))
			throw new UserNotFoundException();
	}
	/**
	 Logs out a user.
	 @param user The User object representing the user data
	 @return true if the user is successfully logged out else returns false
	 */
	public boolean logout(User user) {
		return true;
	}
}