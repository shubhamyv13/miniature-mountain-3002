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

import com.masai.Entity.Seed;
import com.masai.Exception.SeedException;
import com.masai.Service.SeedService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class SeedController {

	@Autowired
	private SeedService seedService;
	
	@PostMapping("/seeds")
	public ResponseEntity<Seed> addNewSeed(@Valid @RequestBody Seed seed) throws SeedException{
		
		Seed seed2 = seedService.addSeed(seed);
		
		return new ResponseEntity<Seed>(seed2,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/seeds/{seedId}")
	public ResponseEntity<Seed> updateSeed(@PathVariable Integer seedId,@RequestBody Seed seed) throws SeedException{
		
		Seed seed2 = seedService.updateSeed(seedId,seed);
		
		return new ResponseEntity<Seed>(seed2,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/seeds/{seedId}")
	public ResponseEntity<Seed> deleteSeed(@PathVariable Integer seedId) throws SeedException{
		
		Seed seed2 = seedService.deleteSeed(seedId);
		
		return new ResponseEntity<Seed>(seed2,HttpStatus.OK);
		
	}
	
	@GetMapping("/seedsById/{seedId}")
	public ResponseEntity<Seed> findSeedById(@PathVariable Integer seedId) throws SeedException{
		
		Seed seed2 = seedService.viewSeed(seedId);
		
		return new ResponseEntity<Seed>(seed2,HttpStatus.FOUND);		
	}
	
	@GetMapping("/seeds")
	public ResponseEntity<List<Seed>> findAllSeeds() throws SeedException{
		
		List<Seed> seedList = seedService.viewAllSeeds();
		
		return new ResponseEntity<List<Seed>>(seedList,HttpStatus.FOUND);
	}
	
	@GetMapping("/seedsByCommonName/{commonName}")
	public ResponseEntity<List<Seed>> findSeedByCommonName(@PathVariable String commonName) throws SeedException{
		
		List<Seed> seedList = seedService.viewSeed(commonName);
		
		return new ResponseEntity<List<Seed>>(seedList,HttpStatus.FOUND);		
	}
	
	@GetMapping("/seedsByTypeOfSeeds/{typeOfSeeds}")
	public ResponseEntity<List<Seed>> findSeedByTypeOfSeeds(@PathVariable String typeOfSeeds) throws SeedException{
		
		List<Seed> seedList = seedService.viewAllSeeds(typeOfSeeds);
		
		return new ResponseEntity<List<Seed>>(seedList,HttpStatus.FOUND);		
	}
	
}
