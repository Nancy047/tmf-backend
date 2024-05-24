package com.example.tmf666.Entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Data
public class ApplicationOwnerApprovalStatusChangeEvent {
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
    private LocalDateTime timeOccurred;
    private String title;
    private String baseType;
    private String type;

    @OneToOne(cascade = CascadeType.ALL)
    private ApplicationApproval application;

}
