package com.example.tmf666.Entity;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Data
@Table(name = "BillingMedia")
public class BillingPresentationMedia {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(name = "href")
    private String href;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;


}