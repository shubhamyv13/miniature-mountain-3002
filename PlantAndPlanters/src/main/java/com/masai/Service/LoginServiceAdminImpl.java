package com.masai.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entity.Admin;
import com.masai.Entity.CurrentAdminSession;
import com.masai.Entity.LoginDTO;
import com.masai.Exception.LoginException;
import com.masai.Repository.AdminRepository;
import com.masai.Repository.CurrentAdminSessionRepository;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceAdminImpl implements LoginAdminService {
	
	@Autowired
	private CurrentAdminSessionRepository currentAdminSessionRepository;
	@Autowired
	private AdminRepository adminRepository;
	

	@Override
	public CurrentAdminSession logIntoAccount(LoginDTO dto) throws LoginException {
		
		Admin currentAdmin = adminRepository.findByUserName(dto.getUserName());
		
		if(currentAdmin == null) {
			
			throw new LoginException("Please Enter a valid user name");
				 
		}	
		Optional<CurrentAdminSession> validAdminSessionOpt =  currentAdminSessionRepository.findById(currentAdmin.getAdminId());
		
		if(validAdminSessionOpt.isPresent()) {
			
			throw new LoginException("User already Logged In with this number");
			
		}
		
		if(currentAdmin.getPassword().equals(dto.getPassword())) {
			
			String key= RandomString.make(6);
//			String token = RandomString.make(6); 
			
			CurrentAdminSession currentAdminSession = new CurrentAdminSession(currentAdmin.getAdminId(),key,LocalDateTime.now());
			
			currentAdminSessionRepository.save(currentAdminSession);

			return currentAdminSession;
		}
		else
			throw new LoginException("Please Enter a valid password");
		
	}

	@Override
	public String logOutFromAccount(String token)throws LoginException {
		
		CurrentAdminSession validAdminSession = currentAdminSessionRepository.findByToken(token);
		
		
		if(validAdminSession == null) {
			throw new LoginException("User Not Logged In with this number");
			
		}
		
		
		currentAdminSessionRepository.delete(validAdminSession);
		
		
		return "Logged Out !";
		
		
	}
}
