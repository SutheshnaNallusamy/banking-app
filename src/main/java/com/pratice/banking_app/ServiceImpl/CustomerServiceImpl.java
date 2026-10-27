package com.pratice.banking_app.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pratice.banking_app.Entity.Customer;
import com.pratice.banking_app.Repository.CustomerRepo;
import com.pratice.banking_app.Service.CustomerService;

@Service
public  class CustomerServiceImpl implements CustomerService {
	
	private final CustomerRepo customerRepo;
	
	public CustomerServiceImpl (CustomerRepo customerRepo) {
		this.customerRepo=customerRepo;
	}
	
	@Override
	public Customer saveCustomer(Customer customer) {
	        return customerRepo.save(customer);
	    }

	@Override
	public List<Customer> allCustomer() {
		return customerRepo.findAll();
	}

	@Override
	public Optional<Customer> getCustomerById(Long id) {
		return customerRepo.findById(id);
	}

	@Override
	public void deleteCustomerById(Long id) {
		 customerRepo.deleteById(id);
		
	}

	@Override
	public Customer updateCustomerById(Long id, Customer customer) {
		
		//1) Finding by id, not existing throw error
		Customer existing = customerRepo.findById(id)
				             .orElseThrow(()-> new RuntimeException("Customer can't find with this Id:"+id));
		
		//2) Setting the values
		existing.setName(customer.getName());
		existing.setEmail(customer.getEmail());
		existing.setAccountNumber(customer.getAccountNumber());
		existing.setCreditLimit(customer.getCreditLimit());
		existing.setId(customer.getId());
		
		//3)Saving the values
		return customerRepo.save(existing);
	}

}
