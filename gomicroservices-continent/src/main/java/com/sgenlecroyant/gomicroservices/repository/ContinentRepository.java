package com.sgenlecroyant.gomicroservices.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgenlecroyant.gomicroservices.entity.Continent;

@Repository
public interface ContinentRepository extends JpaRepository<Continent, Long>{
	
	public Optional<Continent> findByCode(String code);
	
}
