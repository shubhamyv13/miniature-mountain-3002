package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.masai.Entity.Admin;
import com.masai.Entity.Customer;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

	public Admin findByUserName(String userName);
	
}
