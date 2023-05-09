package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.masai.Entity.CurrentAdminSession;

public interface CurrentAdminSessionRepository extends JpaRepository<CurrentAdminSession, Integer> {

	public CurrentAdminSession findByToken(String token);
}
