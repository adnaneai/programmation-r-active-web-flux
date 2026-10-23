package net.adnane.webfluxreactive.web;

import net.adnane.webfluxreactive.entities.Societe;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SocieteReactiveRestController {
    ResponseEntity<Flux<Societe>> findAllSocietes();
    ResponseEntity<Mono<Societe>> findSociete(String id);
    ResponseEntity<Mono<Societe>> saveSociete(Societe societe);
    ResponseEntity<Mono<Societe>> updateSociete(String id,
                                                Societe societe);
    ResponseEntity<Mono<Void>> deleteSociete(String id);
}
