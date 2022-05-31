package com.sgenlecroyant.gomicroservices.controller;

import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sgenlecroyant.gomicroservices.entity.Continent;
import com.sgenlecroyant.gomicroservices.repository.ContinentRepository;

@RestController
public class ContinentController {
	
	@Autowired
	private ContinentRepository continentRepository;
	
	@Autowired
	private Environment environment;
	
	@GetMapping(value = "/continents-feign/{code}")
	public Continent getContinentByCode(@PathVariable String code, HttpServletRequest request) {
			Optional<Continent> fetchedContinent = this.continentRepository.findByCode(code);
//			Optional<Continent> fetchedContinent = this.continentRepository.findById(id);
			// assuming it was found
			Continent continent = fetchedContinent.get();
			String enviroment = this.environment.getProperty("local.server.port");
			continent.setEnvironment(enviroment);
			System.out.println("request ...");
			return continent;
	}

}
