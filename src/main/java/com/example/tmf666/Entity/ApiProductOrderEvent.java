package com.example.tmf666.Entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
public class ApiProductOrderEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private ApiProductOrder productOrder;

}

