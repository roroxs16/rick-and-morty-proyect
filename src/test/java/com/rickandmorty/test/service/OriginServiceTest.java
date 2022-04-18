package com.rickandmorty.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import com.rickandmorty.app.models.Origin;
import com.rickandmorty.app.services.OriginService;

public class OriginServiceTest {

	private OriginService originService;

	private static final String RICKANDMORTY_URL = "https://rickandmortyapi.com/api/";
	private final WebClient webClient = WebClient.builder().baseUrl(RICKANDMORTY_URL).build();

	@BeforeEach
	public void setUp() {
		this.originService = new OriginService(webClient.mutate());
	}

	@Test
	public void givenAnOriginNameReturnExistingOrigin() {

		Origin origin1 = new Origin();
		Origin origin2 = new Origin();
		String originName = "Earth (C-137)";
		String originUrl = "https://rickandmortyapi.com/api/location/1";
		String originDimension = "Dimension C-137";
		List<String> originResidents = new ArrayList<String>();

		originResidents.add("https://rickandmortyapi.com/api/character/38");
		originResidents.add("https://rickandmortyapi.com/api/character/45");
		originResidents.add("https://rickandmortyapi.com/api/character/71");
		originResidents.add("https://rickandmortyapi.com/api/character/82");
		originResidents.add("https://rickandmortyapi.com/api/character/83");
		originResidents.add("https://rickandmortyapi.com/api/character/92");
		originResidents.add("https://rickandmortyapi.com/api/character/112");
		originResidents.add("https://rickandmortyapi.com/api/character/114");
		originResidents.add("https://rickandmortyapi.com/api/character/116");
		originResidents.add("https://rickandmortyapi.com/api/character/117");
		originResidents.add("https://rickandmortyapi.com/api/character/120");
		originResidents.add("https://rickandmortyapi.com/api/character/127");
		originResidents.add("https://rickandmortyapi.com/api/character/155");
		originResidents.add("https://rickandmortyapi.com/api/character/169");
		originResidents.add("https://rickandmortyapi.com/api/character/175");
		originResidents.add("https://rickandmortyapi.com/api/character/179");
		originResidents.add("https://rickandmortyapi.com/api/character/186");
		originResidents.add("https://rickandmortyapi.com/api/character/201");
		originResidents.add("https://rickandmortyapi.com/api/character/216");
		originResidents.add("https://rickandmortyapi.com/api/character/239");
		originResidents.add("https://rickandmortyapi.com/api/character/271");
		originResidents.add("https://rickandmortyapi.com/api/character/302");
		originResidents.add("https://rickandmortyapi.com/api/character/303");
		originResidents.add("https://rickandmortyapi.com/api/character/338");
		originResidents.add("https://rickandmortyapi.com/api/character/343");
		originResidents.add("https://rickandmortyapi.com/api/character/356");
		originResidents.add("https://rickandmortyapi.com/api/character/394");

		origin1.setName(originName);
		origin1.setUrl(originUrl);
		origin1.setDimension(originDimension);
		origin1.setResidents(originResidents);

		origin2 = originService.getOrigin(origin1.getName());
		assertEquals(origin1.getDimension(), origin2.getDimension());
		assertEquals(origin1.getName(), origin2.getName());
		assertEquals(origin1.getUrl(), origin2.getUrl());
		assertEquals(origin1.getResidents(), origin2.getResidents());

	}

	@Test
	public void givenAnIdReturnACharacter() {
		
		Origin origin1 = new Origin();
		String originName = "Earth (Unknown dimension)";
		origin1 = originService.getOrigin(originName);
		assertEquals(origin1.getClass(),Origin.class);
	}

	@Test
	public void givenAnIdReturnOriginNotNull() {
		Origin origin1 = new Origin();
		String originName = "Earth (Replacement Dimension)";
		origin1 = originService.getOrigin(originName);
		assertNotNull(origin1);
	}

	@Test
	public void givenAnIdReturnException() {
		String originDimension = "Earth no exist";
		Throwable thrown = catchThrowable(() -> originService.getOrigin(originDimension));
		assertThat(thrown).isInstanceOf(Exception.class);

	}

}
