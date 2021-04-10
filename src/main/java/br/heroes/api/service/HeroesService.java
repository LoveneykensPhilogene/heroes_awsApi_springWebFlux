package br.heroes.api.service;
import org.springframework.stereotype.Service;

import br.heroes.api.document.Heroes;
import br.heroes.api.repository.HeroesRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HeroesService {
	
	private final HeroesRepository heroesRepository ;
	
	public HeroesService(HeroesRepository heroesRepository) {
		this.heroesRepository=heroesRepository;
	}
	
	public Flux<Heroes> findAll(){
		return Flux.fromIterable(this.heroesRepository.findAll());
	}
	
	public Mono <Heroes> findByidheroes(String id){
		return Mono.justOrEmpty(this.heroesRepository.findById(id));
	}
	
	public Mono<Heroes> save(Heroes heroes){
		return Mono.justOrEmpty(this.heroesRepository.save(heroes));
	}
	
	public Mono<Boolean>deleteByIdHeroes(String id){
		heroesRepository.deleteById(id);
		return Mono.justOrEmpty(true);
	}

}
