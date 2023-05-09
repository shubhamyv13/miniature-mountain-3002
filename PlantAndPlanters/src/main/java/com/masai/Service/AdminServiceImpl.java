package com.masai.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entity.Admin;
import com.masai.Exception.AdminException;
import com.masai.Repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public Admin addAdmin(Admin admin) throws AdminException {
		// TODO Auto-generated method stub
		
		Admin currentAdmin = adminRepository.findByUserName(admin.getUserName());
		
		if(currentAdmin != null) throw new AdminException("Admin already exists");
		
		return adminRepository.save(admin);
	}

	

	

}
