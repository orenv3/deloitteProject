package deloitte.jpa.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import deloitte.jpa.beans.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

	/**
	 * Update customer object. Setting all parameters except id(auto by DB).
	 */
	@Transactional
	@Modifying
	@Query("UPDATE Customer cust SET cust.name = :name , cust.address = :address, cust.phone = :phone WHERE cust.id =:customerId")
	void update(@Param("customerId") int customerId, @Param("name") String name, @Param("address") String address,
			@Param("phone") int phone);

	/**
	 * Find customer by id.
	 * 
	 * @param customerId
	 * @return Customer object
	 */
	Customer findById(int customerId);

	/**
	 * Get customer by its name
	 * 
	 * @param name
	 * @return
	 */
	Customer findByName(String name);

	/**
	 * Delete a customer by id.
	 * 
	 * @param customerId
	 */
	@Transactional
	@Modifying
	@Query("DELETE FROM Customer cust WHERE cust.id = :customerId")
	void removeById(@Param("customerId") int customerId);

}
