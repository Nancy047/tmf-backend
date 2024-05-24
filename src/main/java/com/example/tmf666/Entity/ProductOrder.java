package com.example.tmf666.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
public class ProductOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String baseType;
    private String href;
    private String status;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductOrderErrorMessage> productOrderErrorMessage;
}