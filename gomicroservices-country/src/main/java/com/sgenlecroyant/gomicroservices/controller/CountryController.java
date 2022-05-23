package com.sgenlecroyant.gomicroservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sgenlecroyant.gomicroservices.config.CountryConfig;
import com.sgenlecroyant.gomicroservices.entity.Country;
import com.sgenlecroyant.gomicroservices.repository.CountryRepository;

@RestController
public class CountryController {
	
	@Autowired
	private CountryConfig config;
	
	@Autowired
	private CountryRepository countryRepository;
	
	@GetMapping(value = "/country}", produces = MediaType.APPLICATION_JSON_VALUE)
	private Country getCountry() {
//		Country country = new Country("bi", "Burundi");
		Country country = config.getCountryConfigProps();
		return country;
	}
	
	@GetMapping(value = "/countries/{code}")
	public Country getCountryByCode(@PathVariable String code) {
		Country country = this.countryRepository.findByCode(code);
		return country;
	}
}
