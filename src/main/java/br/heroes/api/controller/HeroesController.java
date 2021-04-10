package br.heroes.api.controller;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.heroes.api.document.Heroes;
import br.heroes.api.repository.HeroesRepository;
import br.heroes.api.service.HeroesService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import  static br.heroes.api.constant.HeroesConstant.HEROES_ENDPOINT_LOCAL;

@RestController
@Slf4j
@RequestMapping("/api")
public class HeroesController {
	
	HeroesService heroesService;
	
	HeroesRepository heroesRepository ;
	
	private static final Logger log=LoggerFactory.getLogger(HeroesController.class);
	
	public HeroesController(HeroesService heroesService,HeroesRepository heroesRepository) {
		this.heroesRepository=heroesRepository;
		this.heroesService=heroesService;
	}
	
	@GetMapping(HEROES_ENDPOINT_LOCAL)
	public Flux<Heroes> getAllItems(){
		log.info("Requesting the list off all heroes");
		return heroesService.findAll();
	}
	
	@GetMapping(HEROES_ENDPOINT_LOCAL+"/id")
	public Mono<ResponseEntity<Heroes>>findByIdHeroes(@PathVariable String id){
		log.info("Requesting the hero with id{}",id);
		return heroesService.findByidheroes(id)
				.map((item)->new ResponseEntity<>(item,HttpStatus.OK))
				.defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		
	}
	
	@PostMapping(HEROES_ENDPOINT_LOCAL)
	@ResponseStatus(code=HttpStatus.CREATED)
	public 
	Mono<Heroes> createHeroes(@RequestBody Heroes heroes){
		log.info("A new hero was created");
		return heroesService.save(heroes);
  }
	
	
	@DeleteMapping(HEROES_ENDPOINT_LOCAL+"/id")
	@ResponseStatus(code=HttpStatus.CONTINUE)
	public Mono<HttpStatus>deleteByIdHeroes(@PathVariable String id){
	       heroesService.deleteByIdHeroes(id);
	       log.info("deleting a hero with id {}",id);
	       
	       return Mono.justOrEmpty(HttpStatus.CONTINUE);
	    	
	}
	
	
	
	

}
