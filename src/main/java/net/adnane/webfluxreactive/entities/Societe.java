package net.adnane.webfluxreactive.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "societes")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class Societe {
    @Id
    private String id;
    private String name;
    private double price;
}
