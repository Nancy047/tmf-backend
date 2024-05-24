package com.example.tmf666.Entity;


import lombok.Data;

import javax.persistence.*;

@Entity
    @Data
    @Table(name = "api_product")
    public class ApiProduct {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String type;

    }

