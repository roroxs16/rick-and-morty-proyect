package com.rickandmorty.app.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Origin {

	
	private String name;
	private String url;
	private String dimension;
	private List<String> residents;
	@JsonProperty(access = Access.WRITE_ONLY)
	private Origin[] results;
	
	public Origin () {}
	
	public Origin(String name, String url, String dimension, List<String> residents, Origin[] results) {
		this.name = name;
		this.url = url;
		this.dimension = dimension;
		this.residents = residents;
		this.results = results;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDimension() {
		return dimension;
	}
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	public List<String> getResidents() {
		return residents;
	}
	public void setResidents(List<String> residents) {
		this.residents = residents;
	}
	public Origin[] getResults() {
		return results;
	}
	public void setResults(Origin[] results) {
		this.results = results;
	}

	
	

	
}
