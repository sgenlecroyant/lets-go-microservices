package com.sgenlecroyant.gomicroservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.sgenlecroyant.gomicroservices.entity.Country;
import com.sgenlecroyant.gomicroservices.repository.CountryRepository;

@SpringBootApplication
public class GomicroservicesCountryApplication implements CommandLineRunner {

	@Autowired
	private CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(GomicroservicesCountryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Country burundi = new Country("bi", "Burundi", "AF");
		Country rwanda = new Country("rw", "Rwanda", "AF");
		Country france = new Country("fr", "France", "EU");

		this.countryRepository.saveAll(List.of(burundi, rwanda, france));

	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
