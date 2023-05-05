package com.masai.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Integer plantId;
	
	@NotNull(message = "{null.invalid}")
	@Min(value = 1 , message = "plant height cannot be zero")
	private Double plantHeight;
	
	@NotNull(message = "{null.invalid}")
	@Min(value = 1 , message = "plant spread cannot be zero")
	private Double plantSpread;
	
	@NotBlank(message = "{blank.invalid}")
	@NotNull(message = "{null.invalid}")
	private String commonName;
	
	@NotBlank(message = "{blank.invalid}")
	@NotNull(message = "{null.invalid}")
	private String bloomTime;
	
	@NotBlank(message = "{blank.invalid}")
	@NotEmpty(message = "{empty.invalid}")
	private String medicinalOrCulinaryUse;
	
	@NotBlank(message = "{blank.invalid}")
	@NotEmpty(message = "{empty.invalid}")
	private String difficultyLevel;
	
	@NotBlank(message = "{blank.invalid}")
	@NotEmpty(message = "{empty.invalid}")
	private String temperature;
	
	@NotBlank(message = "{blank.invalid}")
	@NotEmpty(message = "{empty.invalid}")
	private String typeOfPlant;
	
	@NotBlank(message = "{blank.invalid}")
	@NotEmpty(message = "{empty.invalid}")
	@Size(min = 10,message = "Description cannot be less than 10 characters")
	private String plantDescription;
	
	@Min(value = 0 , message = "plant stock cannot be negative")
	@NotNull(message = "{null.invalid}")
	private Integer plantsStock;
	
	@Min(value = 1 , message = "plant cost cannot be zero")
	@NotNull(message = "{null.invalid}")
	private Double plantCost;
}