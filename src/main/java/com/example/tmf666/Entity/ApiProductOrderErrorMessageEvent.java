package com.example.tmf666.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class ApiProductOrderErrorMessageEvent {
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
    private ProductOrder event;
}