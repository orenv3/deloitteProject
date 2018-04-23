package deloitte.jpa.dao;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import deloitte.jpa.beans.Customer;
import deloitte.jpa.customerExceptions.CustomerExistException;
import deloitte.jpa.customerExceptions.CustomerNotFoundException;

@Service
public class CustomerDB_Dao implements CustomerDao {

	@Autowired
	CustomerRepository customerRepo;

	/**
	 * Create customer object.
	 * 
	 * @param customer
	 * @throws CustomerExistException
	 */
	@Override
	public void create(Customer customer) throws CustomerExistException {
		customerRepo.save(customer);
	}

	/**
	 * Update customer object. Setting all parameters except id(auto by DB).
	 * 
	 * * @param customerId
	 * 
	 * @param name
	 * @param address
	 * @param phone
	 * @throws CustomerNotFoundException
	 * @throws CustomerExistException
	 */
	@Override
	public void update(int customerId, String name, String address, int phone)
			throws CustomerNotFoundException, CustomerExistException {
		customerRepo.update(customerId, name, address, phone);
	}

	/**
	 * Delete a customer by id.
	 * 
	 * @param customerId
	 */
	@Override
	public void delete(int customerId) throws CustomerNotFoundException {
		customerRepo.removeById(customerId);
	}

	/**
	 * Get customer by id
	 * 
	 * @param customerId
	 * @return Optional<Customer> optional of a customer object
	 */
	@Override
	public Optional<Customer> getCustomer(int customerId) {

		Customer customer = customerRepo.findById(customerId);
		return Optional.ofNullable(customer);
	}

	/**
	 * Get customer by its name
	 * 
	 * @param name
	 * @return Customer
	 */
	public Customer getByName(String name) throws CustomerExistException {
		return customerRepo.findByName(name);
	}

	/**
	 * Get list of all customer from the DB.
	 * 
	 * @return ArrayList<Customer> ArrayList of customers.
	 */
	@Override
	public ArrayList<Customer> getAllCustomers() {
		return (ArrayList<Customer>) customerRepo.findAll();
	}

}
