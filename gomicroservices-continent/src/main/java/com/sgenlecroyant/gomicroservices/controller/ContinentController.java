package com.sgenlecroyant.gomicroservices.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgenlecroyant.gomicroservices.entity.Continent;
import com.sgenlecroyant.gomicroservices.repository.ContinentRepository;

@RestController
public class ContinentController {
	
	@Autowired
	private ContinentRepository continentRepository;
	
	@GetMapping(value = "/continents/{code}")
	public Continent getContinentByCode(String code) {
		Optional<Continent> fetchedContinent = this.continentRepository.findByCode(code);
//		Optional<Continent> fetchedContinent = this.continentRepository.findById(id);
		// assuming it was found
		return fetchedContinent.get();
	}

}
