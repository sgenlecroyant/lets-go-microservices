package com.sgenlecroyant.gomicroservices.httpresponse;

import com.sgenlecroyant.gomicroservices.entity.Country;

public class ContinentResponse {
	
	private Country country;
	private String code;
	private String name;
	private String area;
	private String environment;
	public ContinentResponse() {
		// TODO Auto-generated constructor stub
	}
	
	public ContinentResponse(Country country, String code, String name, String area) {
		this.country = country;
		this.code = code;
		this.name = name;
		this.area = area;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
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

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	@Override
	public String toString() {
		return "ContinentResponse [country=" + country + ", code=" + code + ", name=" + name + ", area=" + area + "]";
	}
	
}
