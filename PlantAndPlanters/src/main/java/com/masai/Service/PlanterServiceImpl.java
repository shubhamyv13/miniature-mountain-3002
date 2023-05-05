package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entity.Plant;
import com.masai.Entity.Planter;
import com.masai.Entity.Seed;
import com.masai.Exception.PlanterException;
import com.masai.Repository.PlanterRepository;

@Service
public class PlanterServiceImpl implements PlanterService{

	@Autowired
	private PlanterRepository planterRepository;
	
	@Override
	public Planter addPlanter(Planter planter) throws PlanterException {
		
		Planter savedPlanter = planterRepository.save(planter);
		
		if(savedPlanter != null) return savedPlanter;
		
		throw new PlanterException("Input Mis-Match");
		
	}

	@Override
	public Planter updatePlanter(Integer planterId,Planter planter) throws PlanterException {
		
		Planter currentPlanter = planterRepository.findById(planterId).orElseThrow(() -> new PlanterException("Planter not found"));
		
		currentPlanter.setPlanterId(currentPlanter.getPlanterId());
		currentPlanter.setPlanterCapacity(planter.getPlanterCapacity());
		currentPlanter.setDrainageHoles(planter.getDrainageHoles());
		currentPlanter.setPlanterColor(planter.getPlanterColor());
		currentPlanter.setPlanterCost(planter.getPlanterCost());
		currentPlanter.setPlanterHeight(planter.getPlanterHeight());
		currentPlanter.setPlanterShape(planter.getPlanterShape());
		currentPlanter.setPlanterStock(planter.getPlanterStock());
		
		if(planter.getSeeds() != null) {
			Seed currentSeed = currentPlanter.getSeeds();
			
			Seed newSeed = planter.getSeeds();
			
			currentSeed.setWatering(newSeed.getWatering());
			currentSeed.setTypeOfSeeds(newSeed.getTypeOfSeeds());
			currentSeed.setTemperature(newSeed.getTemperature());
			currentSeed.setSeedsStock(newSeed.getSeedsStock());
			currentSeed.setSeedsPerPacket(newSeed.getSeedsPerPacket());
			currentSeed.setSeedsDescription(newSeed.getSeedsDescription());
			currentSeed.setSeedsCost(newSeed.getSeedsCost());
			currentSeed.setCommonName(newSeed.getCommonName());
			currentSeed.setDifficultyLevel(newSeed.getDifficultyLevel());
			currentSeed.setBloomTime(newSeed.getBloomTime());
			currentSeed.setSeedId(currentSeed.getSeedId()); 
			
			currentPlanter.setSeeds(newSeed);
		}
		
		if(planter.getPlants() != null) {
			
            Plant existingPlant = currentPlanter.getPlants();
            
            Plant newPlant = planter.getPlants();
			
			existingPlant.setPlantId(existingPlant.getPlantId());
			existingPlant.setPlantHeight(newPlant.getPlantHeight());
			existingPlant.setPlantSpread(newPlant.getPlantSpread());
			existingPlant.setCommonName(newPlant.getCommonName());
			existingPlant.setBloomTime(newPlant.getBloomTime());
			existingPlant.setMedicinalOrCulinaryUse(newPlant.getMedicinalOrCulinaryUse());
			existingPlant.setDifficultyLevel(newPlant.getDifficultyLevel());
			existingPlant.setTemperature(newPlant.getTemperature());
			existingPlant.setTypeOfPlant(newPlant.getTypeOfPlant());
			existingPlant.setPlantDescription(newPlant.getPlantDescription());
			existingPlant.setPlantsStock(newPlant.getPlantsStock());
			existingPlant.setPlantCost(newPlant.getPlantCost());
			
			currentPlanter.setPlants(newPlant);
		}
		
		
		Planter updatePlanter = planterRepository.save(currentPlanter);
		
		if(updatePlanter != null) return updatePlanter;
		
		throw new PlanterException("Input mismatch");
		
	}

	@Override
	public Planter deletePlanter(Integer planterId) throws PlanterException {
		
		Planter existingPlanter = planterRepository.findById(planterId).orElseThrow(() -> new PlanterException("No such planter found for the passed id: " + planterId));
		
	    planterRepository.delete(existingPlanter);
	    
	    existingPlanter.setSeeds(null);
	    existingPlanter.setPlants(null);
		
		return existingPlanter;
	}

	@Override
	public Planter viewPlanterById(Integer planterId) throws PlanterException {
		
		Planter existingPlanter = planterRepository.findById(planterId).orElseThrow(() -> new PlanterException("No such planter found for the passed id: " + planterId));
		
		
		return existingPlanter;
	}

	@Override
	public List<Planter> viewPlantersByShape(String planterShape) throws PlanterException {
		
		List<Planter> allExistingPlantersByShape = planterRepository.findByPlanterShape(planterShape);
		
		if(allExistingPlantersByShape == null) throw new PlanterException("No planter found by the passed planter shape: "+ planterShape);
		
		return allExistingPlantersByShape;
	}

	@Override
	public List<Planter> viewAllPlanters() throws PlanterException {
		
		List<Planter> allExistingPlanter = planterRepository.findAll();
		
		if(allExistingPlanter != null) return allExistingPlanter;
		
		throw new PlanterException("No planter found");
	}

	@Override
	public List<Planter> viewPlantersByCost(Double startCost, Double endCost) throws PlanterException {
		
        List<Planter> allExistingPlanterByCost = planterRepository.findByPlanterCostBetween(startCost, endCost);
		
		if(allExistingPlanterByCost != null) return allExistingPlanterByCost;
		
		throw new PlanterException("No planter found"); 
	}

}
