package com.rickandmorty.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import com.rickandmorty.app.services.CharacterService;
import com.rickandmorty.app.models.Character;
public class CharacterServiceTest {

	private CharacterService characterService;
	
	
	private static final String RICKANDMORTY_URL = "https://rickandmortyapi.com/api/";
	private final WebClient webClient = WebClient.builder().baseUrl(RICKANDMORTY_URL).build(); 
	
	@BeforeEach
    public void setUp() {
		this.characterService = new CharacterService(webClient.mutate());
    }
	
	@Test
	public void givenAnIdCompareWithExistingCharacter() {
		int id = 1;
		Character character = new Character();
		Character character2 = new Character();
		character.setId(id);
		character.setName("Rick Sanchez");
		character.setStatus("Alive");
		character.setSpecies("Human");
		character.setType("");
		character.setEpisodeCount(51);
		character2=characterService.getCharacter(id);
		character2.setEpisodeCount(character2.getEpisode().length);
		assertEquals(character.getId(),character2.getId());
		assertEquals(character.getName(),character2.getName());
		assertEquals(character.getEpisodeCount(),character2.getEpisodeCount());
		assertEquals(character.getSpecies(),character2.getSpecies());
		assertEquals(character.getStatus(),character2.getStatus());
		assertEquals(character.getType(),character2.getType());
	
	}
		
	@Test
	public void givenAnIdReturnACharacter() {
		int id = 2;
		Character character1 = new Character();
		character1=characterService.getCharacter(id);
		character1.setEpisodeCount(character1.getEpisode().length);
		assertEquals(character1.getClass(),Character.class);
		
	}
	
	@Test
	public void givenAnIdReturnNotNull() {
		int id = 3;
		Character character2 = new Character();
		character2=characterService.getCharacter(id);
		character2.setEpisodeCount(character2.getEpisode().length);
		assertNotNull(character2);
		
	}
	
	@Test
	public void givenAnIdReturnException() {
		int id = 8852;
		Throwable thrown = catchThrowable(() -> characterService.getCharacter(id));
		assertThat(thrown).isInstanceOf(Exception.class);
	}
	
	
}
