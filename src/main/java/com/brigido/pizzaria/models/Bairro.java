package com.brigido.pizzaria.models;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@With
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Bairro {

    @Id
    private String id;
    private String name;
    private double tax;

}
