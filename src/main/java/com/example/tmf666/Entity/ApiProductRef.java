package com.example.tmf666.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ApiProductRef {
    private String type;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

}
