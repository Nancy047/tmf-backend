package com.example.tmf666.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "email_contact_medium_organization")
public class EmailContactMediumOrganization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean preferred;
    private String mediumType;
    private String emailAddress;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;
}