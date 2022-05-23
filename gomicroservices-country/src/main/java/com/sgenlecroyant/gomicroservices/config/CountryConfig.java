package com.sgenlecroyant.gomicroservices.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.sgenlecroyant.gomicroservices.entity.Country;

@Configuration
@ConfigurationProperties(prefix = "country-service")
public class CountryConfig {
	
	private String code;
	private String name;
	private String locatedIn;
	
	public Country getCountryConfigProps() {
		Country country = new Country(code, name, locatedIn);
		return country;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getLocatedIn() {
		return locatedIn;
	}
	public void setLocatedIn(String locatedIn) {
		this.locatedIn = locatedIn;
	}
	

}
