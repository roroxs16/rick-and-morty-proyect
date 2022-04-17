package com.rickandmorty.app.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = Character.class)
public class Character {

	private Integer id;
	private String name;
	private String status;
	private String species;
	private String type;

	@JsonProperty(access = Access.WRITE_ONLY)
	private String[] episode;

	private Integer episodeCount;

	private Origin origin;

	public Character() {
	}

	public Character(int id, String name, String status, String species, String type, int episodeCount, Origin origin) {

		this.id = id;
		this.name = name;
		this.status = status;
		this.species = species;
		this.type = type;
		this.episodeCount = episodeCount;
		this.origin = origin;
	}

	public String[] getEpisode() {
		return episode;
	}

	public void setEpisode(String[] episode) {
		this.episode = episode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getEpisodeCount() {
		return episodeCount;
	}

	public void setEpisodeCount(Integer episodeCount) {
		this.episodeCount = episodeCount;
	}

	public Origin getOrigin() {
		return origin;
	}

	public void setOrigin(Origin origin) {
		this.origin = origin;
	}

}
