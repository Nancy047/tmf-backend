package com.example.tmf666.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "organization")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String organizationType;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organization")
    private List<EmailContactMedium> contactMedium;
}
