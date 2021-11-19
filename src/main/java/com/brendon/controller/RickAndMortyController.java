package com.brendon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brendon.client.RickAndMortyClient;
import com.brendon.response.CharacterResponse;
import com.brendon.response.EpisodeResponse;
import com.brendon.response.ListOfEpisodeResponse;
import com.brendon.response.LocationResponse;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/webclient")
@AllArgsConstructor
public class RickAndMortyController {

	@Autowired
	private RickAndMortyClient rickAndMortyClient;
	
	@GetMapping("/character/{id}")
	public Mono<CharacterResponse> getCharacterById(@PathVariable String id) {
		
		return rickAndMortyClient.findACharacterById(id);
	}
	
	@GetMapping("/location/{id}")
	public Mono<LocationResponse> getLocationById(@PathVariable String id) {
		
		return rickAndMortyClient.findALocationById(id);
	}
	
	@GetMapping("/episode/{id}")
	public Mono<EpisodeResponse> getEpisodeById(@PathVariable String id) {		
		return rickAndMortyClient.findAEpisodeById(id);
	}
	
	@GetMapping("/episodes")
	public Flux<ListOfEpisodeResponse> getAllEpisode() {		
		return rickAndMortyClient.AllEpisode();
	}
}