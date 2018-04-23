package deloitte.jpa.dao;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import deloitte.jpa.beans.Customer;
import deloitte.jpa.customerExceptions.CustomerExistException;
import deloitte.jpa.customerExceptions.CustomerNotFoundException;

@Service
public interface CustomerDao {

	/**
	 * Create customer object.
	 * 
	 * @param customer
	 * @throws CustomerExistException
	 */
	void create(Customer customer) throws CustomerExistException;

	/**
	 * Update customer object by id. Setting only the name & password.
	 * 
	 * @param customer
	 * @throws CustomerNotFoundException
	 * @throws CustomerExistException
	 */
	void update(int customerId, String name, String address, int phone)
			throws CustomerNotFoundException, CustomerExistException;

	/**
	 * Delete a customer by id.
	 * 
	 * @param customerId
	 * @throws CustomerNotFoundException
	 */
	void delete(int customerId) throws CustomerNotFoundException;

	/**
	 * Get customer by id
	 * 
	 * @param customerId
	 * @return
	 */
	Optional<Customer> getCustomer(int customerId) throws CustomerNotFoundException;

	/**
	 * Get list of all customer from the DB.
	 * 
	 * @return ArrayList<Customer> ArrayList of customers.
	 */
	ArrayList<Customer> getAllCustomers();

}
