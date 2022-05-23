package com.sgenlecroyant.gomicroservices.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "continents")
@Table(name = "continents")
public class Continent {
	
	@Id
	private Long id;
	private String code;
	private String name;
	private float area;
	
	public Continent(String code, String name, float area) {
		this.code = code;
		this.name = name;
		this.area = area;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public float getArea() {
		return area;
	}

	public void setArea(float area) {
		this.area = area;
	}
	
	
	
	

}
