package com.rickandmorty.app.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



import com.rickandmorty.app.services.CharacterService;
import com.rickandmorty.app.services.OriginService;
import com.rickandmorty.app.models.Character;
import com.rickandmorty.app.models.Origin;

@Controller
public class CharacterContrller {
	
	@Autowired
	private CharacterService characterService;
	
	@Autowired
	private OriginService originService;
	
	@GetMapping("/character/{id}")
	public ResponseEntity<?> mostrarProducto(@PathVariable int id) {
		Character character = new Character() ;
		Character cleanCharacter = new Character();
		Origin origin = new Origin();
		Map<String, Object> response = new HashMap<>();
		try {
			character = characterService.getCharacter(id);
			character.setEpisodeCount(character.getEpisode().length);
		}catch(Exception e) {
			response.put("error", "No se encontró el personaje");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
			origin = originService.getLocation(character.getOrigin().getName());
		}catch(Exception e) {
			response.put("error", "No se encontro el origen del personaje");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		cleanCharacter = new Character(
				character.getId(),
				character.getName(),
				character.getStatus(),
				character.getSpecies(), 
				character.getSpecies(),
				character.getEpisodeCount(),
				origin);
		
			
		return new ResponseEntity<Character>(cleanCharacter,HttpStatus.OK);

	}
	
}
