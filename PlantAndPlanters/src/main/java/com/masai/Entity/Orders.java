package com.masai.Entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Integer bookingOrderId;
	
	@JsonFormat(pattern = "DD-MM-YYYY")
	@NotBlank(message = "{blank.invalid}")
	private LocalDate orderDate;
	
	@NotEmpty(message = "{empty.invalid}")
	@NotBlank(message = "{blank.invalid}")
	private String transactionMode;
	
	@NotNull(message = "{null.invalid}")
	private Integer quantity;
	
	@NotNull(message = "{null.invalid}")
	private Double totalCost;
	
	@NotNull(message = "{null.invalid}")
	private Integer customerId;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Planter> planters;

}
