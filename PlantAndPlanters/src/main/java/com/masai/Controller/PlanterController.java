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

import com.masai.Entity.Planter;
import com.masai.Exception.PlanterException;
import com.masai.Service.PlanterService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class PlanterController {

	@Autowired
	private PlanterService planterService;
	
	@PostMapping("/planters")
	public ResponseEntity<Planter> addNewPlanter(@Valid @RequestBody Planter planter) throws PlanterException{
		
		Planter savedPlanter = planterService.addPlanter(planter);
		
		return new ResponseEntity<Planter>(savedPlanter,HttpStatus.CREATED);
	}
	
	@PutMapping("/planters/{planterId}")
	public ResponseEntity<Planter> updatePlanter(@PathVariable Integer planterId, @Valid @RequestBody Planter planter) throws PlanterException{
		
		System.out.println(planter);
		
		Planter updatedPlanter = planterService.updatePlanter(planterId, planter);
		
		return new ResponseEntity<Planter>(updatedPlanter,HttpStatus.OK);
	}
	
	@DeleteMapping("/planters/{planterId}")
	public ResponseEntity<Planter> deletePlanter(@PathVariable Integer planterId) throws PlanterException{
		
		Planter deletedPlanter = planterService.deletePlanter(planterId);
		
		return new ResponseEntity<Planter>(deletedPlanter, HttpStatus.OK);
	}
	
	@GetMapping("/planters/{planterId}")
	public ResponseEntity<Planter> getPlanterById(@PathVariable Integer planterId) throws PlanterException{
		
		Planter planter = planterService.viewPlanterById(planterId);
		
		return new ResponseEntity<Planter>(planter, HttpStatus.FOUND);
	}
	
	@GetMapping("/planters")
	public ResponseEntity<List<Planter>> getAllPlanters() throws PlanterException{
		
		List<Planter> planterList = planterService.viewAllPlanters();
		
		return new ResponseEntity<List<Planter>>(planterList, HttpStatus.FOUND);
	}
	
	@GetMapping("/planters/{startCost}/{endCost}")
	public ResponseEntity<List<Planter>> getAllPlanterByCost(@PathVariable Double startCost, @PathVariable Double endCost) throws PlanterException{
		
		List<Planter> planterList = planterService.viewPlantersByCost(startCost, endCost);
		
		return new ResponseEntity<List<Planter>>(planterList, HttpStatus.FOUND);
	}
	
	@GetMapping("/plantersByShape/{planterShape}")
	public ResponseEntity<List<Planter>> getPlanterById(@PathVariable String planterShape) throws PlanterException{
		
		List<Planter> planterList = planterService.viewPlantersByShape(planterShape);
		
		return new ResponseEntity<List<Planter>>(planterList, HttpStatus.FOUND);
	}
}
