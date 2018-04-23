package deloitte.jpa.facade;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deloitte.jpa.beans.Customer;
import deloitte.jpa.customerExceptions.CustomerExistException;
import deloitte.jpa.customerExceptions.CustomerNotFoundException;
import deloitte.jpa.dao.CustomerDB_Dao;

@Component
public class CustomerFacade implements SystemUsers {

	@Autowired
	CustomerDB_Dao custDb;

	/**
	 * Create a customer.
	 * 
	 * @param customer
	 * @throws CustomerExistException
	 *             If the name of the customer exists.
	 */
	public void createCustomer(Customer customer) throws CustomerExistException {
		Optional<Customer> check = Optional.ofNullable(custDb.getByName(customer.getName()));
		if (!(check.isPresent())) {
			custDb.create(customer);
		} else
			throw new CustomerExistException("This user already exist in the system. Please try different name.");
	}

	/**
	 * Delete customer by id.
	 * 
	 * @param customerId
	 * @throws CustomerNotFoundException
	 *             If the customer's id does not exists (customer not found).
	 */
	public void deleteCustomerById(int customerId) throws CustomerNotFoundException {
		if (this.check(customerId).isPresent())
			custDb.delete(customerId);
		else
			throw new CustomerNotFoundException(
					"There is no such customer id: " + customerId + ". The deletion was not executed.");
	}

	/**
	 * Update customer via its id. Setting all parameters except id(auto by DB).
	 * 
	 * @param customerId
	 * @param name
	 * @param address
	 * @param phone
	 * @throws CustomerNotFoundException
	 *             If the customer's id does not exists (customer not found).
	 * @throws CustomerExistException
	 *             If the updated name of the customer exists.
	 */
	public void updateCustomer(int customerId, String name, String address, int phone)
			throws CustomerNotFoundException, CustomerExistException {
		Optional<Customer> custCheck = Optional.ofNullable(custDb.getByName(name));
		if (custCheck.isPresent() && customerId != custCheck.get().getId())
			throw new CustomerExistException("The name is already exist OR there is no such user id.");
		if (this.check(customerId).isPresent())
			custDb.update(customerId, name, address, phone);
		else
			throw new CustomerNotFoundException("There is no such user id ==> user id: " + customerId);
	}

	/**
	 * Get customer by id.
	 * 
	 * @param customerId
	 * @return customer
	 * @throws CustomerNotFoundException
	 *             If the customer's id does not exists (customer not found).
	 */
	public Customer getCustmer(int customerId) throws CustomerNotFoundException {
		if (!(check(customerId).isPresent()))
			throw new CustomerNotFoundException("There is no such user, user id: " + customerId);
		else
			return check(customerId).get();
	}

	/**
	 * Get list of all customers.
	 * 
	 * @return ArrayList<Customer> ArrayList of customers.
	 */
	public ArrayList<Customer> getAllCustomers() {
		return custDb.getAllCustomers();
	}

	//////////////////// private ///////////////////////
	/**
	 * private method to check customers from DB via Optional
	 * 
	 * @param customerId
	 * @return Optional of customer
	 */
	private Optional<Customer> check(int customerId) {
		return custDb.getCustomer(customerId);
	}
}
