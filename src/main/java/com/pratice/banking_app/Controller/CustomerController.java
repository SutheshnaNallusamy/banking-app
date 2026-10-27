package com.pratice.banking_app.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratice.banking_app.Entity.Customer;
import com.pratice.banking_app.Service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	private final CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
	    this.customerService = customerService;
	}
	
	
	@GetMapping("/hello")
	public String hello() {
		return "Welcome to My Banking application";
	}
	
	@PostMapping("/create")
	public Customer createCustomer(@Valid @RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}
	
	@GetMapping("/all")
	public List<Customer> allCustomer() {
		return  customerService.allCustomer();
		
	}
    
	@GetMapping("/{id}")
	public Optional<Customer> getCustomerById(@PathVariable Long id){
	   return customerService.getCustomerById(id);	
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteCustomerById(@PathVariable Long id) {
		customerService.deleteCustomerById(id);
	}
	
	@PutMapping("/update/{id}")
	public Customer updateCustomerById(@PathVariable Long id,@Valid @RequestBody Customer customer) {
		return customerService.updateCustomerById(id,customer);
	}
	
}
