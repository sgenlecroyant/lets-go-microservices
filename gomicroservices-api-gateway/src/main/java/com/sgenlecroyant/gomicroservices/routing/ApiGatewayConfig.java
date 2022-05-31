package com.sgenlecroyant.gomicroservices.routing;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {
	
	@Bean
	public RouteLocator getRouteLocator(RouteLocatorBuilder builder) {
		
		return builder
				.routes()
				.route((p) -> p.path("/get")
						
						.filters(f -> {
							System.out.println("path /get: ...");
							return f.addResponseHeader("responseHeader", "Franck Sgen");
							
						})
						
						.uri("http://httpbin.org:80"))
				
				.route((p) -> p.path("/countries-feign/**")
						.uri("lb://country-service"))
				
				.build();
	}

}
