package br.heroes.api.controllerTest;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import  static br.heroes.api.constant.HeroesConstant.HEROES_ENDPOINT_LOCAL;
import br.heroes.api.repository.HeroesRepository;

@RunWith(SpringRunner.class)
@DirtiesContext
@AutoConfigureWebTestClient
@SpringBootTest
class HeroesControllerTest {
	
	@Autowired
	private WebTestClient webTestClient;
	
	@Autowired
	private HeroesRepository  heroesRepositoryTest;
	
	@Test
	public void getOneHeroeById() {
		webTestClient.get().uri(HEROES_ENDPOINT_LOCAL.concat("/{id})"),"25")
		.exchange()
		.expectStatus().isOk()
		.expectBody();
	
	}

	@Test
	public void getOneHeroeNotFound(){
		webTestClient.get()
		.exchange()
		.expectStatus().isNotFound();
	}
	
	@Test
	public void deleteHeroeById() {
		webTestClient.delete()
		.uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"),"1")
		.accept(MediaType.APPLICATION_JSON)
		.exchange()
		.expectStatus().isNotFound()
		.expectBody(Void.class);
		
	}
	

}
