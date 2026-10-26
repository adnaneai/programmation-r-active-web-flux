package net.adnane.webfluxreactive.service;

import lombok.AllArgsConstructor;
import net.adnane.webfluxreactive.dao.SocieteRepository;
import net.adnane.webfluxreactive.entities.Societe;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class SocieteReactiveServiceImpl implements SocieteReactiveService {
    private SocieteRepository societeRepository;
    @Override
    public Flux<Societe> getAllSociete() {
        return societeRepository.findAll();
    }

    @Override
    public Mono<Societe> getSociete(String id) {
        return societeRepository.findById(id);
    }

    @Override
    public Mono<Societe> createSociete(Societe societe) {
        return societeRepository.save(societe);
    }

    @Override
    public Mono<Societe> updateSociete(String id, Societe societe) {
        Mono<Societe> societeMono = societeRepository.findById(id);
        if (societeMono != null) {
            societe.setId(id);
            return societeRepository.save(societe);
        }else
            return Mono.empty();
    }

    @Override
    public Mono<Void> deleteSociete(String id) {
        Mono<Societe> societeMono = societeRepository.findById(id);
        if (societeMono != null) {
            return  societeRepository.deleteById(id);
        }else
            return  Mono.empty();
    }
}
