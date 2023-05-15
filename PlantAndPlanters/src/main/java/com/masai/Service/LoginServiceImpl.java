package com.masai.Service;



import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entity.CurrentUserSession;
import com.masai.Entity.Customer;
import com.masai.Entity.LoginDTO;
import com.masai.Exception.LoginException;
import com.masai.Repository.CurrentUserSessionRepository;
import com.masai.Repository.CustomerRepository;

import net.bytebuddy.utility.RandomString;


@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CurrentUserSessionRepository currentUserSessionRepository;
		
	@Override
	public CurrentUserSession logIntoAccount(LoginDTO dto)throws LoginException{
		
		
		Customer existingCustomer= customerRepository.findByUserName(dto.getUserName());
		
		if(existingCustomer == null) {
			
			throw new LoginException("Please Enter a valid username number");
				 
		}	
		Optional<CurrentUserSession> validCustomerSessionOpt =  currentUserSessionRepository.findById(existingCustomer.getCustomerId());
		
		if(validCustomerSessionOpt.isPresent()) {
			
			throw new LoginException("User already Logged In with this username");
			
		}
		
		if(existingCustomer.getPassword().equals(dto.getPassword())) {
			
			String key= RandomString.make(6);
//			String token = RandomString.make(6); 
			
			CurrentUserSession currentUserSession = new CurrentUserSession(existingCustomer.getCustomerId(),key,LocalDateTime.now());
			
			currentUserSessionRepository.save(currentUserSession);

			return currentUserSession;
		}
		else
			throw new LoginException("Please Enter a valid password");
		
	}

	@Override
	public String logOutFromAccount(String token)throws LoginException {
		
		CurrentUserSession validCustomerSession = currentUserSessionRepository.findByToken(token);
		
		
		if(validCustomerSession == null) {
			throw new LoginException("User Not Logged In with this number");
			
		}
		
		
		currentUserSessionRepository.delete(validCustomerSession);
		
		
		return "Logged Out !";
		
		
	}


}
