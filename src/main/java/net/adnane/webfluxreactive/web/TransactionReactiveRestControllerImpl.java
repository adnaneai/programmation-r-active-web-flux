package net.adnane.webfluxreactive.web;

import lombok.AllArgsConstructor;
import net.adnane.webfluxreactive.entities.Transaction;
import net.adnane.webfluxreactive.service.TransactionReactiveService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/transactions")
@AllArgsConstructor
public class TransactionReactiveRestControllerImpl implements TransactionReactiveRestController {
    private TransactionReactiveService transactionReactiveService;
    @Override
    @GetMapping
    public ResponseEntity<Flux<Transaction>> getAllSocietes() {
        Flux<Transaction> transactionFlux = transactionReactiveService.getAllTransaction();
        return ResponseEntity.ok(transactionFlux);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Mono<Transaction>> getSocieteById(@PathVariable String id) {
        Mono<Transaction> transactionMono = transactionReactiveService.getTransaction(id);
        return ResponseEntity.ok(transactionMono);
    }

    @Override
    @PostMapping
    public ResponseEntity<Mono<Transaction>> createSociete(@RequestBody Transaction transaction) {
        Mono<Transaction> transactionMono = transactionReactiveService.createTransaction(transaction);
        return ResponseEntity.ok(transactionMono);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Mono<Transaction>> updateSociete(@PathVariable String id,
                                                           @RequestBody Transaction transaction) {
        Mono<Transaction> transactionMono = transactionReactiveService.updateTransaction(id, transaction);
        return ResponseEntity.ok(transactionMono);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Mono<Void>> deleteSociete(@PathVariable String id) {
        return ResponseEntity.ok(transactionReactiveService.deleteTransaction(id));
    }
}
