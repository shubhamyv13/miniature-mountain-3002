package com.masai.Entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@JsonIgnore
	private Integer customerId;
	
	@NotNull(message = "Name field should not be empty")
	private String customerName;
	
	@NotNull(message = "Mobile number field should not be empty")
	@Pattern(regexp = "[6789]{1}[0-9]{9}",message = "Input a valid mobile number")
	private String mobile;
	
	@NotNull(message="Email is mandatory")
	@Pattern(regexp = "^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$",message = "Input a valid email address")
	private String email;
	
	
	@NotNull(message = "User_Name cannot be null")
	@Pattern(regexp = "[A-Za-z]{1}[A-Za-z0-9]", message = "Please enter valid user name" )
	private String userName;
	
	@NotNull(message = "{null.invalid}")
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$", message = "Please enter valid password" )
	private String password;
	
	@Embedded
	@ElementCollection
	private Set<Address> addressSet = new HashSet<>();
	
}