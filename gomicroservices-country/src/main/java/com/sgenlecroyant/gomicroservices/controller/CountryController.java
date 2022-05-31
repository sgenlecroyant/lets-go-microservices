package com.sgenlecroyant.gomicroservices.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sgenlecroyant.gomicroservices.config.CountryConfig;
import com.sgenlecroyant.gomicroservices.entity.Country;
import com.sgenlecroyant.gomicroservices.httpcall.ContinentProxy;
import com.sgenlecroyant.gomicroservices.httpresponse.ContinentResponse;
import com.sgenlecroyant.gomicroservices.repository.CountryRepository;

@RestController
public class CountryController {
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ContinentProxy continentProxy;
	
	private final String url = "http://CONTINENT-SERVICE/continents-feign/{code}";
	private ContinentResponse continentResponse;
	
	@Autowired
	private CountryConfig config;
	
	@Autowired
	private CountryRepository countryRepository;
	
	@GetMapping(value = "/country", produces = MediaType.APPLICATION_JSON_VALUE)
	private Country getCountry() {
//		Country country = new Country("bi", "Burundi");
		Country country = config.getCountryConfigProps();
		return country;
	}
	
	@GetMapping(value = "/countries/{code}")
	public ContinentResponse getCountryByCode(@PathVariable String code) {
		Country country = this.countryRepository.findByCode(code);
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("code", country.getLocatedIn());
		ResponseEntity<ContinentResponse> responseEntity = this.restTemplate.getForEntity(url, ContinentResponse.class, uriVariables);
		ContinentResponse continent = responseEntity.getBody();
		
		this.continentResponse = new ContinentResponse(country, continent.getCode(), continent.getName(), continent.getArea());
		return continentResponse;
	}
	
	@GetMapping(value = "/countries-feign/{code}")
	public ContinentResponse getCountryByCodeFeign(@PathVariable String code) {
		Country country = this.countryRepository.findByCode(code);
		
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put(code, country.getLocatedIn());
		ContinentResponse continentResponse = this.continentProxy.getContinentResponseFeign(country.getLocatedIn());
		System.out.println("Before: "+continentResponse);
		continentResponse.setCountry(country);
		System.out.println("After: "+continentResponse);
		return continentResponse;
	}
	
}
