package com.masai.Entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
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
	private Integer customerId;
	
	@NotNull(message = "Name field should not be empty")
	@Column(name =  "customerName")
	private String customerName;
	
	@NotNull(message = "Mobile number field should not be empty")
	@Pattern(regexp = "[6789]{1}[0-9]{9}",message = "Input a valid mobile number")
	@Column(name = "mobileNo")
	private String mobile;
	
	@NotNull(message="Email is mandatory")
	@Pattern(regexp = "^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$",message = "Input a valid email address")
	private String email;
	
	
	@NotNull(message = "Usser_Name cannot be null")
	@Pattern(regexp = "[A-Za-z]{1}[A-Za-z0-9]{5,}", message = "Please enter valid user name" )
	private String userName;
	
	@NotNull(message = "{null.invalid}")
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$", message = "Please enter valid password" )
	private String password;
	
//	@Column(columnDefinition = "boolean default false")
	private Integer isActive = 1;
	
	@Embedded
	@ElementCollection
	@JoinTable(name = "address")
	private Set<Address> addressSet = new HashSet<>();
	
}