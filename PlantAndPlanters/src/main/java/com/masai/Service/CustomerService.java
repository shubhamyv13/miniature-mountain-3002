package com.masai.Service;

import java.util.List;

import com.masai.Entity.Customer;
import com.masai.Exception.CustomerException;

public interface CustomerService {

	public Customer addCustomer(Customer customer) throws CustomerException;

	public Customer updateCustomer(Customer customer,String token) throws CustomerException;

	public Customer deleteCustomer(Integer customerId, String token, Integer adminId) throws CustomerException;

	public Customer viewCustomer(Integer customerId,String token, Integer adminId) throws CustomerException;

	public List<Customer> viewAllCustomer(String token, Integer adminId) throws CustomerException;

//	public Customer validateCustomer(String userName, String password) throws CustomerException;
}
