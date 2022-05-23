package com.sgenlecroyant.gomicroservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgenlecroyant.gomicroservices.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long>{

	public Country findByCode(String code);

}
