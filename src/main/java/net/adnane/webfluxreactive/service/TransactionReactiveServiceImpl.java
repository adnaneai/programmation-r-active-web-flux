package net.adnane.webfluxreactive.service;

import lombok.AllArgsConstructor;
import net.adnane.webfluxreactive.dao.SocieteRepository;
import net.adnane.webfluxreactive.dao.TransactionRepository;
import net.adnane.webfluxreactive.entities.Societe;
import net.adnane.webfluxreactive.entities.Transaction;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionReactiveServiceImpl implements TransactionReactiveService {
    private TransactionRepository transactionRepository;
    private SocieteRepository societeRepository;

    @Override
    public Flux<Transaction> getAllTransaction() {

        return transactionRepository.findAll().flatMap(transaction -> {
                        if (transaction.getSocieteIds() == null || transaction.getSocieteIds().isEmpty()) {
                            transaction.setSocietes(List.of());
                            return Mono.just(transaction);}
                        return Flux.fromIterable(transaction.getSocieteIds())
                                .flatMap(societeRepository::findById)
                                .collectList()
                                .map(societes -> {
                                    transaction.setSocietes(societes);
                                    return transaction;
                                });
                        });
        }

    @Override
    public Mono<Transaction> getTransaction(String id) {

        return transactionRepository.findById(id)
                .flatMap(transaction -> {

                    if (transaction.getSocieteIds() == null ||
                            transaction.getSocieteIds().isEmpty()) {

                        transaction.setSocietes(List.of());

                        return Mono.just(transaction);
                    }

                    return Flux.fromIterable(transaction.getSocieteIds())
                            .flatMap(societeRepository::findById)
                            .collectList()
                            .map(societes -> {

                                transaction.setSocietes(societes);

                                return transaction;
                            });
                });
    }

    @Override
    public Mono<Transaction> createTransaction(Transaction transaction) {

        if (transaction.getSocietes() != null) {

            transaction.setSocieteIds(
                    transaction.getSocietes()
                            .stream()
                            .map(Societe::getId)
                            .toList()
            );
        }

        return transactionRepository.save(transaction);
    }

    @Override
    public Mono<Transaction> updateTransaction(
            String id,
            Transaction transaction) {

        return transactionRepository.findById(id)
                .flatMap(existingTransaction -> {

                    transaction.setId(id);

                    if (transaction.getSocietes() != null) {

                        transaction.setSocieteIds(
                                transaction.getSocietes()
                                        .stream()
                                        .map(Societe::getId)
                                        .toList()
                        );
                    }

                    return transactionRepository.save(transaction);
                });
    }

    @Override
    public Mono<Void> deleteTransaction(String id) {

        return transactionRepository.findById(id)
                .flatMap(transaction ->
                        transactionRepository.deleteById(id)
                );
    }
}