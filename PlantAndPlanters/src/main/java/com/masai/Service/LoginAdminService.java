package com.masai.Service;

import com.masai.Entity.CurrentAdminSession;
import com.masai.Entity.LoginDTO;
import com.masai.Exception.LoginException;

public interface LoginAdminService {

	public CurrentAdminSession logIntoAccount(LoginDTO dto)throws LoginException;

	public String logOutFromAccount(String key)throws LoginException;
}
