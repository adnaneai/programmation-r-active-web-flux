package net.adnane.webfluxreactive.service;

import net.adnane.webfluxreactive.entities.Transaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionReactiveService {
    Flux<Transaction> getAllTransaction();
    Mono<Transaction> getTransaction(String id);
    Mono<Transaction> createTransaction(Transaction transaction);
    Mono<Transaction> updateTransaction(String id, Transaction transaction);
    Mono<Void> deleteTransaction(String id);
}
