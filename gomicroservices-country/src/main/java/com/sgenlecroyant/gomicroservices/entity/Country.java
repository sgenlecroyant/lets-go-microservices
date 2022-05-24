package com.sgenlecroyant.gomicroservices.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "countries")
@Table(name = "countries")
public class Country {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String code;
	private String name;
	private String locatedIn;
	
	public Country() {
		// TODO Auto-generated constructor stub
	}

	public Country(String code, String name, String locatedIn) {
		this.code = code;
		this.name = name;
		this.locatedIn = locatedIn;
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

	@Override
	public String toString() {
		return "Country [id=" + id + ", code=" + code + ", name=" + name + ", locatedIn=" + locatedIn + "]";
	}
	
	
	
}
