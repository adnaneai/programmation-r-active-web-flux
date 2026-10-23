package net.adnane.webfluxreactive.web;

import lombok.AllArgsConstructor;
import net.adnane.webfluxreactive.entities.Societe;
import net.adnane.webfluxreactive.service.SocieteReactiveService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/societes")
@AllArgsConstructor
public class SocieteReactiveRestControllerImpl implements SocieteReactiveRestController {
    private SocieteReactiveService societeReactiveService;
    @Override
    @GetMapping
    public ResponseEntity<Flux<Societe>> findAllSocietes() {
        Flux<Societe> societeFlux = societeReactiveService.getAllSociete();
        return ResponseEntity.ok(societeFlux);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Mono<Societe>> findSociete(@PathVariable String id) {
        Mono<Societe> societeMono = societeReactiveService.getSociete(id);
        return ResponseEntity.ok(societeMono);
    }

    @Override
    @PostMapping
    public ResponseEntity<Mono<Societe>> saveSociete(@RequestBody Societe societe) {
        Mono<Societe> societeMono = societeReactiveService.createSociete(societe);
        return ResponseEntity.ok(societeMono);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Mono<Societe>> updateSociete(@PathVariable String id,
                                                       @RequestBody Societe societe) {
        Mono<Societe> societeMono = societeReactiveService.updateSociete(id, societe);
        return ResponseEntity.ok(societeMono);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Mono<Void>> deleteSociete(@PathVariable String id) {
        return ResponseEntity.ok(societeReactiveService.deleteSociete(id));
    }
}
