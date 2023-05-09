package com.masai.Service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entity.Address;
import com.masai.Entity.CurrentAdminSession;
import com.masai.Entity.CurrentUserSession;
import com.masai.Entity.Customer;
import com.masai.Exception.CustomerException;
import com.masai.Repository.AdminRepository;
import com.masai.Repository.CurrentAdminSessionRepository;
import com.masai.Repository.CurrentUserSessionRepository;
import com.masai.Repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CurrentUserSessionRepository currentUserSessionRepository;
	
	@Autowired
	private CurrentAdminSessionRepository currentAdminSessionRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	

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
	public Customer deleteCustomer(Integer customerId, String token, Integer adminId) throws CustomerException {
		// TODO Auto-generated method stub
		CurrentAdminSession loggedInAdmin= currentAdminSessionRepository.findByToken(token);
		
		if(loggedInAdmin == null) throw new CustomerException("Please provide a valid key to update a customer");

		if(adminId == loggedInAdmin.getUserId()) {
			
			Customer currentCustomer = customerRepository.findById(customerId).orElseThrow(()-> new CustomerException("Customer Not founde by id :"));
				
			    Set<Address> addressSet = currentCustomer.getAddressSet();
			    
			    addressSet = null;
			    
				customerRepository.deleteById(customerId);
				
				return currentCustomer;
		}
		
		
		throw new CustomerException("Invalid Admin Details, please login first");
	}

	@Override
	public Customer viewCustomer(Integer customerId,String token, Integer adminId) throws CustomerException {
		// TODO Auto-generated method stub
		
		CurrentAdminSession loggedInAdmin= currentAdminSessionRepository.findByToken(token);
		
		if(loggedInAdmin == null) throw new CustomerException("Please provide a valid key to update a customer");

		if(adminId == loggedInAdmin.getUserId()) {
			
			Customer currentCustomer = customerRepository.findById(customerId).orElseThrow(()-> new CustomerException("Customer Not founde by id :"));	
			return currentCustomer;
		}
		
		
		throw new CustomerException("Invalid Admin Details, please login first");
		
	}

	@Override
	public List<Customer> viewAllCustomer(String token, Integer adminId) throws CustomerException {
		// TODO Auto-generated method stub.
		
		CurrentAdminSession loggedInAdmin= currentAdminSessionRepository.findByToken(token);
		
		if(loggedInAdmin == null) throw new CustomerException("Please provide a valid key to update a customer");

		if(adminId == loggedInAdmin.getUserId()) {
			
			List<Customer> customerList = customerRepository.findAll(); 
				
			if(customerList.size()>0) return customerList;
			
			else {				
				throw new CustomerException("No Customer Founded");
			}
		}
		
		
		throw new CustomerException("Invalid Admin Details, please login first");
	}

//	@Override
//	public Customer validateCustomer(String userName, String password) throws CustomerException {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
