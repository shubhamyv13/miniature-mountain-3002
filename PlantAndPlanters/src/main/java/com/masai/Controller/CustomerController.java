package com.masai.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Entity.Customer;
import com.masai.Exception.CustomerException;
import com.masai.Service.CustomerService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer customer) throws CustomerException {
		
		Customer savedCustomer= customerService.addCustomer(customer);
		
		
		return new ResponseEntity<Customer>(savedCustomer,HttpStatus.CREATED);
	}
	
	@PutMapping("/customers")
	public  ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer,@RequestParam(required = false) String key ) throws CustomerException {
		
		
		Customer updatedCustomer= customerService.updateCustomer(customer, key);
				
		return new ResponseEntity<Customer>(updatedCustomer,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/customers/{customerId}/{token}/{adminId}")
	public  ResponseEntity<Customer> deleteCustomerById(@PathVariable Integer customerId,@PathVariable String token,@PathVariable Integer adminId ) throws CustomerException {
		
		
		Customer deletedCustomer= customerService.deleteCustomer(customerId, token,adminId);
				
		return new ResponseEntity<Customer>(deletedCustomer,HttpStatus.OK);
	}
	
	@GetMapping("/customers/{customerId}/{token}/{adminId}")
	public  ResponseEntity<Customer> getCustomerById(@PathVariable Integer customerId,@PathVariable String token,@PathVariable Integer adminId ) throws CustomerException {
		
		
		Customer customer= customerService.viewCustomer(customerId, token,adminId);
				
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
	
	@GetMapping("/customers/{token}/{adminId}")
	public  ResponseEntity<List<Customer>> getAllCustomer(@PathVariable String token,@PathVariable Integer adminId ) throws CustomerException {
		
		
		List<Customer> customerList = customerService.viewAllCustomer(token,adminId);
				
		return new ResponseEntity<List<Customer>>(customerList,HttpStatus.OK);
	}

}
