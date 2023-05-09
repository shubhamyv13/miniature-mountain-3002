package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Entity.Plant;
import com.masai.Exception.PlantException;
import com.masai.Service.PlantService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class PlantController {

	@Autowired
	private PlantService plantService;
	
	@PostMapping("/plants")
	public ResponseEntity<Plant> addNewPlant(@Valid @RequestBody Plant plant) throws PlantException{
		
		Plant newPlant = plantService.addPlant(plant);
		
		return new ResponseEntity<Plant>(newPlant,HttpStatus.CREATED);
	}
	
	@PutMapping("/plants/{plantId}")
	public ResponseEntity<Plant> updatePlant(@Valid @PathVariable Integer plantId, @RequestBody Plant plant) throws PlantException{ 
		
		Plant existingPlant = plantService.updatePlant(plantId, plant);
		
		return new ResponseEntity<Plant>(existingPlant,HttpStatus.OK);
	}
	
	@DeleteMapping("/plants/{id}")
	public ResponseEntity<Plant> deletePlant(@PathVariable("id") Integer plantId) throws PlantException{
		
		Plant existingPlant = plantService.deletePlant(plantId);
		
		return new ResponseEntity<Plant>(existingPlant,HttpStatus.OK);
		
	}
	
	@GetMapping("/plants/{plantId}")
	public ResponseEntity<Plant> getPlantById(@PathVariable Integer plantId) throws PlantException{
		
		Plant existingPlant = plantService.viewPlant(plantId);
		
		return new ResponseEntity<Plant>(existingPlant,HttpStatus.FOUND);
		
	}
	
	@GetMapping("/plants")
	public ResponseEntity<List<Plant>> findAllPlants() throws PlantException{
		
		List<Plant> plantList = plantService.viewAllPlants();
		
		return new ResponseEntity<List<Plant>>(plantList,HttpStatus.FOUND);
	}
	
	@GetMapping("/plantByCommonName/{commonName}")
	public ResponseEntity<List<Plant>> findSeedByCommonName(@PathVariable String commonName) throws PlantException{
		
		List<Plant> plantList = plantService.viewPlant(commonName);
		
		return new ResponseEntity<List<Plant>>(plantList,HttpStatus.FOUND);		
	}
	
	@GetMapping("/plantsByTypeOfPlant/{typeOfPlant}")
	public ResponseEntity<List<Plant>> findSeedByTypeOfPlant(@PathVariable String typeOfPlant) throws PlantException{
		
		List<Plant> plantList = plantService.viewAllPlants(typeOfPlant);
		
		return new ResponseEntity<List<Plant>>(plantList,HttpStatus.FOUND);		
	}
	
	
	
	
}
