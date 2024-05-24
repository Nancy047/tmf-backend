package com.example.tmf666.Entity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@Entity
public class ApplicationOwnerAttributeValueChangeEvent {
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
    private ApplicationOwner event;

}

