package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entity.Seed;
import com.masai.Exception.SeedException;
import com.masai.Repository.SeedsRepository;

@Service
public class SeedServiceImpl implements SeedService {

	@Autowired
	private SeedsRepository seedsRepository;
	
	@Override
	public Seed addSeed(Seed seed) throws SeedException {
		
		
		Seed savedSeed = seedsRepository.save(seed);
		
		System.out.println(savedSeed);
		
		if(savedSeed != null) return savedSeed;
		
		
		throw new SeedException("Input Mis-Match");
	}

	@Override
	public Seed updateSeed(Integer id,Seed seed) throws SeedException {
		
		
		Optional<Seed> optSeed = seedsRepository.findById(id);
		
		if(optSeed.isPresent()) {
			
			Seed currentSeed = optSeed.get();
			
			currentSeed.setWatering(seed.getWatering());
			currentSeed.setTypeOfSeeds(seed.getTypeOfSeeds());
			currentSeed.setTemperature(seed.getTemperature());
			currentSeed.setSeedsStock(seed.getSeedsStock());
			currentSeed.setSeedsPerPacket(seed.getSeedsPerPacket());
			currentSeed.setSeedsDescription(seed.getSeedsDescription());
			currentSeed.setSeedsCost(seed.getSeedsCost());
			currentSeed.setCommonName(seed.getCommonName());
			currentSeed.setDifficultyLevel(seed.getDifficultyLevel());
			currentSeed.setBloomTime(seed.getBloomTime());
			currentSeed.setSeedId(id); // why do we need to pass Id 
			
			Seed savedSeed = seedsRepository.save(currentSeed);
			
			return savedSeed;
		}
		
		throw new SeedException("Seed not found with id :"+id);
	}

	@Override
	public Seed deleteSeed(Integer seedId) throws SeedException {
	
		Optional<Seed> optSeed = seedsRepository.findById(seedId);
		
		if(optSeed.isPresent()) {
			
			Seed deletedSeed = optSeed.get();
			
			seedsRepository.deleteById(seedId);
			
			return deletedSeed;
		}
		
		throw new SeedException("Seed not found with id :"+seedId);
	}

	@Override
	public Seed viewSeed(int seedId) throws SeedException {
	
		Optional<Seed> optSeed = seedsRepository.findById(seedId);
		
		if(optSeed.isPresent()) {
			
			Seed savedSeed = optSeed.get();
			
			return savedSeed;
		}
		
		throw new SeedException("Seed not found with id :"+seedId);
		
	}

	@Override
	public List<Seed> viewSeed(String commonName) throws SeedException {

		List<Seed> seedList = seedsRepository.getByCommonName(commonName);
		
		if(seedList.size() > 0) {
			
			return seedList;
		}
		
		throw new SeedException("No Seed found by this common name :"+ commonName);
	}

	@Override
	public List<Seed> viewAllSeeds() throws SeedException {
		
		List<Seed> seedList = seedsRepository.findAll();
		
		if(seedList.size() > 0) {
			
			return seedList;
		}
		
		throw new SeedException("No Seed found ");
	}

	@Override
	public List<Seed> viewAllSeeds(String typeOfSeed) throws SeedException {

		List<Seed> seedList = seedsRepository.getByTypeOfSeeds(typeOfSeed);
		
		if(seedList.size() > 0) {
			
			return seedList;
		}
		
		throw new SeedException("No Seed found by this type of seed :"+ typeOfSeed);
	}

}
