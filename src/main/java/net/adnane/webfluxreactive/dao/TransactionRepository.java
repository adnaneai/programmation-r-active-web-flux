package net.adnane.webfluxreactive.dao;

import net.adnane.webfluxreactive.entities.Transaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TransactionRepository extends ReactiveMongoRepository<Transaction, String> {

}
