package net.adnane.webfluxreactive.service;

import net.adnane.webfluxreactive.entities.Societe;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SocieteReactiveService {
    Flux<Societe> getAllSociete();
    Mono<Societe> getSociete(String id);
    Mono<Societe> createSociete(Societe societe);
    Mono<Societe> updateSociete(String id, Societe societe);
    Mono<Void> deleteSociete(String id);
}
