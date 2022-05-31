package com.sgenlecroyant.gomicroservices.config;

import java.time.Duration;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.common.circuitbreaker.configuration.CircuitBreakerConfigCustomizer;

public class Resilience4J {
	
	
	public CircuitBreakerConfigCustomizer customizeCircuitBreaker() {
		return CircuitBreakerConfigCustomizer
				.of("default-one", (builer) -> builer.failureRateThreshold(60.0f)
						.enableAutomaticTransitionFromOpenToHalfOpen()
						.maxWaitDurationInHalfOpenState(Duration.ofSeconds(10))
						.permittedNumberOfCallsInHalfOpenState(10)
						.build())
				;
	}
	

}
