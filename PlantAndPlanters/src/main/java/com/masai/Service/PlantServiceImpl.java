package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entity.Plant;
import com.masai.Exception.PlantException;
import com.masai.Repository.PlantRepository;

@Service
public class PlantServiceImpl implements PlantService {
	
	@Autowired
	private PlantRepository plantRepository;

	@Override
	public Plant addPlant(Plant plant) throws PlantException {
		// TODO Auto-generated method stub
		Plant addNewPlant = plantRepository.save(plant);
		
		if(addNewPlant != null) return addNewPlant;
		
		throw new PlantException("Input Mis-Match");
	}

	@Override
	public Plant updatePlant(Integer platId,Plant plant) throws PlantException {
		// TODO Auto-generated method stub
		
		Optional<Plant> optPlant = plantRepository.findById(platId);
		
		if(optPlant.isPresent()) {
			Plant existingPlant = optPlant.get();
			
			existingPlant.setPlantId(platId);
			existingPlant.setPlantHeight(plant.getPlantHeight());
			existingPlant.setPlantSpread(plant.getPlantSpread());
			existingPlant.setCommonName(plant.getCommonName());
			existingPlant.setBloomTime(plant.getBloomTime());
			existingPlant.setMedicinalOrCulinaryUse(plant.getMedicinalOrCulinaryUse());
			existingPlant.setDifficultyLevel(plant.getDifficultyLevel());
			existingPlant.setTemperature(plant.getTemperature());
			existingPlant.setTypeOfPlant(plant.getTypeOfPlant());
			existingPlant.setPlantDescription(plant.getPlantDescription());
			existingPlant.setPlantsStock(plant.getPlantsStock());
			existingPlant.setPlantCost(plant.getPlantCost());
			
			plantRepository.save(existingPlant);
			
			return existingPlant;
		}
		
		throw new PlantException("Plant not found");
	}

	@Override
	public Plant deletePlant(Integer plantId) throws PlantException {
		// TODO Auto-generated method stub
		
		Optional<Plant> optPlant = plantRepository.findById(plantId);
		
		if(optPlant.isPresent()) {
			
			Plant existingPlant = optPlant.get();
			
			plantRepository.deleteById(plantId);
			
			return existingPlant;

		}
		
		throw new PlantException("Plant not found");
	}

	@Override
	public Plant viewPlant(Integer plantId) throws PlantException {
		// TODO Auto-generated method stub
		Optional<Plant> optPlant = plantRepository.findById(plantId);
		
		if(optPlant.isPresent()) {
			
			Plant existingPlant = optPlant.get();

			return existingPlant;
		}
		
		throw new PlantException("Plant not found");
	}

	@Override
	public List<Plant> viewPlant(String commonName) throws PlantException {
		// TODO Auto-generated method stub
		
		List<Plant> plantList = plantRepository.getByCommonName(commonName);
		
		if(plantList.size()>0) {
			return plantList;
		}
		
		throw new PlantException("No Plant found with common name :"+commonName);
		
	}

	@Override
	public List<Plant> viewAllPlants() throws PlantException {
		// TODO Auto-generated method stub
		
		List<Plant> plantList = plantRepository.findAll();
		
		if(plantList.size()>0) {
			return plantList;
		}
		
		throw new PlantException("No Plant found");
	}

	@Override
	public List<Plant> viewAllPlants(String typeOfPlant) throws PlantException {
		// TODO Auto-generated method stub

		List<Plant> plantList = plantRepository.getByTypeOfPlant(typeOfPlant);
		
		if(plantList.size()>0) {
			return plantList;
		}
		
		throw new PlantException("No Plant found with type of plant :"+typeOfPlant);
		
	}

}
