package src.main.java.com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

}
