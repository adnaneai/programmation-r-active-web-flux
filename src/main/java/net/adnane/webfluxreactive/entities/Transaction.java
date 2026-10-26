package net.adnane.webfluxreactive.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import reactor.core.publisher.Flux;


import java.time.Instant;
import java.util.List;

@Document(collection = "transactions")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class Transaction {
    @Id
    private String id;
    private Instant instant;
    private double price;
    @JsonIgnore
    private List<String> societeIds;
    @Transient
    private List<Societe> societes;
}

