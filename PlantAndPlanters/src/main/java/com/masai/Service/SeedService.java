package com.masai.Service;

import java.util.List;

import com.masai.Entity.Seed;
import com.masai.Exception.SeedException;

public interface SeedService {

	public Seed addSeed(Seed seed) throws SeedException;
	
	public Seed updateSeed(Integer id,Seed seed) throws SeedException;
	
	public Seed deleteSeed(Integer seedId) throws SeedException;
	
	public Seed viewSeed(int seedId) throws SeedException;
	
	public List<Seed> viewSeed(String commonName) throws SeedException;
	
	public List<Seed> viewAllSeeds() throws SeedException;
	
	public List<Seed> viewAllSeeds(String typeOfSeed) throws SeedException;
}
