package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Entity.Admin;
import com.masai.Exception.AdminException;
import com.masai.Service.AdminService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping("/admins")
	public ResponseEntity<Admin> saveAdmin(@Valid @RequestBody Admin admin) throws AdminException {
		
		System.out.println("Controller strated");
		
		Admin savedAdmin= adminService.addAdmin(admin);
		
		System.out.println(savedAdmin);
		
		return new ResponseEntity<Admin>(savedAdmin,HttpStatus.CREATED);
	}
}
