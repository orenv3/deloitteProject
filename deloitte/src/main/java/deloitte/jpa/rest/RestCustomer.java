package deloitte.jpa.rest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import deloitte.jpa.beans.Customer;
import deloitte.jpa.customerExceptions.CustomerExistException;
import deloitte.jpa.customerExceptions.CustomerNotFoundException;
import deloitte.jpa.facade.CustomerFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "restCustomerSwagger", produces = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping(value = "/restCustomer")
@CrossOrigin(origins = "*")
public class RestCustomer {

	@Autowired
	CustomerFacade cf;

	/**
	 * Create a customer.
	 * 
	 * @param customer
	 * @throws CustomerExistException
	 *             If the name of the customer exists.
	 */
	@ApiOperation("Create a customer. All fields are necessary.")
	@RequestMapping(value = "/createCustomer", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity createCustomer(@RequestBody Customer customer) {
		try {
			cf.createCustomer(customer);
		} catch (CustomerExistException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.TEXT_PLAIN).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN)
				.body("The customer " + customer + "created successfully.");
	}

	/**
	 * Delete customer.
	 * 
	 * @param customer
	 * @throws CustomerNotFoundException
	 *             If the customer's id does not exists (customer not found).
	 */
	@ApiOperation("Delete customer (delete by id). To test it just edit the customer id.")
	@RequestMapping(value = "/deleteCustomer", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity deleteCustomer(@RequestBody Customer customer) {
		try {
			cf.deleteCustomerById(customer.getId());
		} catch (CustomerNotFoundException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.TEXT_PLAIN).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN)
				.body("Customer with id:" + customer.getId() + " deleted successfully");
	}

	/**
	 * Update customer via its id. The update set all except id(Auto by DB).
	 * 
	 * @param customer
	 * @throws CustomerNotFoundException
	 *             If the customer's id does not exists (customer not found).
	 * @throws CustomerExistException
	 *             If the name switched && this name exists on DB.
	 */
	@ApiOperation("Update customer via its id. The update set all except id(Auto by DB).")
	@RequestMapping(value = "/updateCustomer/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity updateCustomer(@RequestBody Customer customer) {
		try {
			cf.updateCustomer(customer.getId(), customer.getName(), customer.getAddress(), customer.getPhone());
		} catch (CustomerNotFoundException | CustomerExistException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.TEXT_PLAIN).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN)
				.body("The customer updated successfully to: " + customer);
	}

	/**
	 * Get customer by id.
	 * 
	 * @param customerId
	 * @return customer
	 * @throws CustomerNotFoundException
	 *             If the customer's id does not exists (customer not found).
	 */
	@ApiOperation("Get customer by id")
	@RequestMapping(value = "/getCustomer/{customerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getCustomer(@PathVariable("customerId") int customerId) {
		Customer cust = null;
		try {
			cust = cf.getCustmer(customerId);
		} catch (CustomerNotFoundException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.TEXT_PLAIN).body(e.getMessage());
		}
		return (ResponseEntity) ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(cust);
	}

	/**
	 * Get list of all customers.
	 * 
	 * @return ArrayList<Customer> ArrayList of customers.
	 */
	@ApiOperation("Get list of all customers.")
	@RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<Customer> getAllCustomers() {
		return cf.getAllCustomers();
	}
}
