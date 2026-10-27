package com.pratice.banking_app.Service;

import java.util.List;
import java.util.Optional;




import com.pratice.banking_app.Entity.Customer;


public interface CustomerService {

	 Customer saveCustomer(Customer customer);

	List<Customer> allCustomer();

	Optional<Customer> getCustomerById(Long id);
	
	void deleteCustomerById(Long id);

	Customer updateCustomerById(Long id, Customer customer);
}
