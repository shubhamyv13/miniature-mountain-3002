package com.masai.Service;

import java.util.List;

import com.masai.Entity.Plant;
import com.masai.Exception.PlantException;

public interface PlantService {


	public Plant addPlant(Plant plant) throws PlantException;

	public Plant updatePlant(Integer platId,Plant plant) throws PlantException;

	public Plant deletePlant(Integer plantId) throws PlantException;

	public Plant viewPlant(Integer plantId) throws PlantException;

	public List<Plant> viewPlant(String commonName) throws PlantException;

	public List<Plant> viewAllPlants() throws PlantException;

	public List<Plant> viewAllPlants(String typeOfPlant) throws PlantException;
}
