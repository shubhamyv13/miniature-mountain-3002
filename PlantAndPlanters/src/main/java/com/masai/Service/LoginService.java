package com.masai.Service;

import com.masai.Exception.LoginException;
import com.masai.Entity.*;

public interface LoginService {
	
	public String logIntoAccount(LoginDTO dto)throws LoginException;

	public String logOutFromAccount(String key)throws LoginException;

}
