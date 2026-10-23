package net.adnane.webfluxreactive.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.Instant;

@Document(collection = "transactions")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class Transaction {
    @Id
    private String id;
    private Instant instant;
    private double price;
    @DBRef
    private Societe societe;
}
