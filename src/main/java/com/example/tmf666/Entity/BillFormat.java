package com.example.tmf666.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
@Getter
@Setter
@Data
@Entity
public class BillFormat {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String href;
    private String name;
    private String description;
    private int duration;
    private LocalDateTime CreationDate;



}
