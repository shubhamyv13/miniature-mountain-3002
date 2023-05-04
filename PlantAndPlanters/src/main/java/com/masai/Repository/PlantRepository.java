package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Entity.Plant;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Integer>{

}
