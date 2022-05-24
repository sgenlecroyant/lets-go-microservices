package com.sgenlecroyant.gomicroservices;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.sgenlecroyant.gomicroservices.entity.Continent;
import com.sgenlecroyant.gomicroservices.repository.ContinentRepository;

@SpringBootApplication
@EnableEurekaClient
public class GomicroservicesContinentApplication {

	@Autowired
	private ContinentRepository continentRepository;

	public static void main(String[] args) {
		SpringApplication.run(GomicroservicesContinentApplication.class, args);
	}

	@Bean
	public CommandLineRunner getCommandLineRunner() {

		return (args) -> {
			DecimalFormat df = new DecimalFormat("0.00");

			Continent africa = new Continent("AF", "AFRICA", String.format("%.2f", 30.37));
			Continent europe = new Continent("EU", "EUROPE", String.format("%.2f", 10.53));
//			System.out.println(africa.getArea());
			this.continentRepository.saveAll(List.of(africa, europe));
		};
	}

}
