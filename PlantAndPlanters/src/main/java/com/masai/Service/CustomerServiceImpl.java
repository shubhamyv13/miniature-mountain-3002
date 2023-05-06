package com.masai.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entity.Customer;
import com.masai.Exception.CustomerException;
import com.masai.Repository.CurrentUserSessionRepository;
import com.masai.Repository.CustomerRepository;
import com.masai.Entity.*;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CurrentUserSessionRepository currentUserSessionRepository;
	

	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		
		Customer existingCustomer= customerRepository.findByUserName(customer.getUserName());
		
		if(existingCustomer != null) 
			throw new CustomerException("Customer Already Registered with user name");
		
			return customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer, String token) throws CustomerException {
		// TODO Auto-generated method stub
		CurrentUserSession loggedInUser= currentUserSessionRepository.findByToken(token);
		
		if(loggedInUser == null) {
			throw new CustomerException("Please provide a valid key to update a customer");
		}
		
		if(customer.getCustomerId() == loggedInUser.getUserId()) {
			//If LoggedInUser id is same as the id of supplied Customer which we want to update
			return customerRepository.save(customer);
		}
		else
			throw new CustomerException("Invalid Customer Details, please login first");
	}

	@Override
	public Customer deleteCustomer(Integer customerId, String token) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer viewCustomer(int customerId) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> viewAllCustomer() throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer validateCustomer(String userName, String password) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

}
