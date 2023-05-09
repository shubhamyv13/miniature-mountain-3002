package com.masai.Service;

import com.masai.Entity.Admin;
import com.masai.Exception.AdminException;

public interface AdminService {

	public Admin addAdmin(Admin admin) throws AdminException;

}
