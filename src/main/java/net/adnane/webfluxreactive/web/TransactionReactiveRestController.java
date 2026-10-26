package net.adnane.webfluxreactive.web;

import net.adnane.webfluxreactive.entities.Societe;
import net.adnane.webfluxreactive.entities.Transaction;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionReactiveRestController {
    ResponseEntity<Flux<Transaction>> getAllSocietes();
    ResponseEntity<Mono<Transaction>> getSocieteById(String id);
    ResponseEntity<Mono<Transaction>> createSociete(Transaction transaction);
    ResponseEntity<Mono<Transaction>> updateSociete(String id,
                                                    Transaction transaction);
    ResponseEntity<Mono<Void>> deleteSociete(String id);
}
