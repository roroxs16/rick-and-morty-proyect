package com.rickandmorty.app.services;

import org.springframework.stereotype.Service;

import org.springframework.web.reactive.function.client.WebClient;


import com.rickandmorty.app.models.Origin;


@Service
public class OriginService {

	private static final String RICKANDMORTY_URL = "https://rickandmortyapi.com/api/";
	private final WebClient webClient;
	
	
	public OriginService(WebClient.Builder builder) {
		webClient = builder.baseUrl(RICKANDMORTY_URL).build();
	}
	
	public Origin getOrigin(String name) {
		Origin response= webClient
				.get()
				.uri(uriBuilder -> uriBuilder
						.path("location/")
						.queryParam("name",name)
						.build())
				.retrieve()
				.bodyToMono(Origin.class).block();
		Origin cleanOrigin = new Origin();
		Origin[] resultsResponse= response.getResults();
		if(resultsResponse.length>0) {
			
			for(Origin origin: resultsResponse) {
				
				cleanOrigin.setName(origin.getName());
				cleanOrigin.setDimension(origin.getDimension());
				cleanOrigin.setUrl(origin.getUrl());
				cleanOrigin.setResidents(origin.getResidents());
			}
			
			
		}
		
		

		return cleanOrigin;
	}
	
}
