package com.sgenlecroyant.gomicroservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class GomicroservicesConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GomicroservicesConfigServerApplication.class, args);
	}

}
