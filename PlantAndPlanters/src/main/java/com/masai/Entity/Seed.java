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
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Seed {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Integer seedId;
	
	@NotBlank(message = "{blank.invalid}")
	@NotNull(message = "{null.invalid}")
	@Size(min = 4,message = "Name cannot be less than 4 characters")
	private String commonName;
	
	@NotBlank(message = "{blank.invalid}")
	@NotEmpty(message = "{empty.invalid}")
	private String bloomTime;
	
	@NotBlank(message = "{blank.invalid}")
	@NotEmpty(message = "{empty.invalid}")
	private String watering;
	
	@NotBlank(message = "{blank.invalid}")
	@NotEmpty(message = "{empty.invalid}")
	private String difficultyLevel;
	
	@NotBlank(message = "{blank.invalid}")
	@NotEmpty(message = "{empty.invalid}")
	private String temperature;
	
	@NotBlank(message = "{blank.invalid}")
	@NotEmpty(message = "{empty.invalid}")
	private String typeOfSeeds;
	
	@NotBlank(message = "{blank.invalid}")
	@NotNull(message = "{null.invalid}")
	@NotEmpty(message = "{empty.invalid}")
	@Size(min = 10,message = "Description cannot be less than 10 characters")
	private String seedsDescription;
	
	@Min(value = 0, message = "Seed's stock can't be negative")
	@NotNull(message = "{null.invalid}")
	private Integer seedsStock;
	
	@Min(value = 1, message = "Seed's cost should not be zero")
	@NotNull(message = "{null.invalid}")
	private Double seedsCost;
	
	@Min(value = 1, message = "There cannot be zero seeds in a packet")
	@NotNull(message = "{null.invalid}")
	private Integer seedsPerPacket;
	
	
	
}