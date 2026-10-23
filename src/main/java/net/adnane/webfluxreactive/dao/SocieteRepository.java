package net.adnane.webfluxreactive.dao;

import net.adnane.webfluxreactive.entities.Societe;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface SocieteRepository extends ReactiveMongoRepository<Societe, String> {
}
