package com.rickandmorty.app.services;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.rickandmorty.app.models.Character;
@Service
public class CharacterService {
	
	private static final String RICKANDMORTY_URL = "https://rickandmortyapi.com/api/";
	private final WebClient webClient;
	
	public CharacterService(WebClient.Builder builder) {
		webClient = builder.baseUrl(RICKANDMORTY_URL).build();
	}
	
	public Character getCharacter(int id) {
		return ( webClient
				.get()
				.uri("character/"+id)
				.retrieve()
				.bodyToMono(Character.class).block());
	}


}
