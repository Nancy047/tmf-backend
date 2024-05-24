package com.example.tmf666.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ApiProductOrderAttributeValueChangeEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String correlationId;
    private String description;
    private String domain;
    private String eventId;
    private LocalDateTime eventTime;
    private String eventType;
    private String priority;
    private LocalDateTime timeOcurred;
    private String title;

    @OneToOne(cascade = CascadeType.ALL)
    private ApiProductOrderEvent event;



    // Getters and Setters
}

