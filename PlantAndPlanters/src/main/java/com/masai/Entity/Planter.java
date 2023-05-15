package com.masai.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Planter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@JsonIgnore
	private Integer planterId;
	
	private String url;
	
	@Min(value=1 , message = "Planter height should be more than 0")
	@NotNull(message = "{null.invalid}")
	private Double planterHeight;
	
	@Min(value=1 , message = "Planter capacity cannot be 0")
	@NotNull(message = "{null.invalid}")
	private Double planterCapacity;
	
	@Min(value=5 , message = "Drainage holes should not be 5")
	@NotNull(message = "{null.invalid}")
	private Integer drainageHoles;
	
	@NotBlank(message = "{blank.invalid}")
	@NotEmpty(message = "{empty.invalid}")
	private String planterColor;
	
	@NotBlank(message = "{blank.invalid}")
	@NotEmpty(message = "{empty.invalid}")
	private String planterShape;
	
	@Min(value=1 , message = "Planter stock should be atleast 1")
	@NotNull(message = "{null.invalid}")
	private Integer planterStock;
	
	@Min(value=1 , message = "Planter cost cannot be 0")
	@NotNull(message = "{null.invalid}")
	private Integer planterCost;
	
	@OneToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private Seed Seeds;
	
	@OneToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private Plant Plants;
	
	
	
}