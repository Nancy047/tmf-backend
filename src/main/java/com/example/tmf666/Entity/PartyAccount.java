package com.example.tmf666.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Data
@Setter
@Getter

public class PartyAccount {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
private String href;
    private String name;
    private String description;
    private String status;
    private LocalDateTime creationDate;
    private LocalDateTime lastModifiedDate;


}
