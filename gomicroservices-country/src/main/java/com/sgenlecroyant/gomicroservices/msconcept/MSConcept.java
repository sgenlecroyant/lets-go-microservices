package com.sgenlecroyant.gomicroservices.msconcept;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class MSConcept {

	private Random random = new Random();
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private static final List<String> names;

	static {
		names = new ArrayList<>();
		names.add("Sinyol Sinna");
		names.add("Jersy Box");
		names.add("Ken Thomson");
		names.add("Jenny Richards");
		names.add("James Palmer");
		names.add("Chad Wresler");
		names.add("Anna Smith");
		names.add("Jenn Johnson");
		names.add("Tom Salt");
		names.add("Maria Jones");
		names.add("Will Johnson");
		names.add("James Bond");
		names.add("Silly Season");
		names.add("Yahmy Silas");
		names.add("Huuricane June");
	}

	@GetMapping(value = "/random-name")
//	@Retry(name = "retry-case", fallbackMethod = "handleRetryMechanism")
	@CircuitBreaker(name = "circuitbreaker-case", fallbackMethod = "handleRetryMechanism")
	public String getSomeName() throws RestClientException, URISyntaxException {
//		String randName = null;
//		int i = 0;
//		while (i < names.size()) {
//			randName = names.get(this.random.nextInt(0, names.size()));
//			break;
//		}
//		System.out.println(randName);
//		return randName;
		this.logger.info("Call Received: ....");
		ResponseEntity<String> forEntity = new RestTemplate()
			.getForEntity(new URI("http://localhost:9898"), String.class)
			;
		return forEntity.getBody();
	}
	
	
	public String handleRetryMechanism(Exception exception) {
		return "Service Down";
	}

}
