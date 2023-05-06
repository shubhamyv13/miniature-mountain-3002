package com.masai.Entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

	@NotNull(message = "{null.invalid}")
	private Integer addressId;
	
	@NotBlank(message = "{blank.invalid}")
	@NotEmpty(message = "{empty.invalid}")
	private String houseNo;
	
	@NotBlank(message = "{blank.invalid}")
	@NotEmpty(message = "{empty.invalid}")
	private String colony;
	
	@NotBlank(message = "{blank.invalid}")
	@NotEmpty(message = "{empty.invalid}")
	private String city;
	
	@NotBlank(message = "{blank.invalid}")
	@NotEmpty(message = "{empty.invalid}")
	private String state;
	
	@Pattern(regexp = "[1-9]{1}[0-9]{5}",message = " Please enter a valid 6 digit pincode ") // @Size 6
	@NotNull(message = "{null.invalid}")
	private Integer pinCode;
	
	
	@NotNull(message = "{null.invalid}")
	private String addressType; //Home , office , etc. 

}