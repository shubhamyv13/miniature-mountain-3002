package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Entity.*;

public interface CurrentUserSessionRepository extends JpaRepository<CurrentUserSession, Integer> {

	
	public  CurrentUserSession  findByToken(String token);
}
