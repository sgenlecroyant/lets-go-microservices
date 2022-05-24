package com.sgenlecroyant.gomicroservices.httpcall;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sgenlecroyant.gomicroservices.httpresponse.ContinentResponse;

@FeignClient(value = "continent-service", url = "http://localhost:8001")
public interface ContinentProxy {
	
	@GetMapping(value = "/continents/{code}")
	public ContinentResponse getContinentResponse(@PathVariable String code);

}
