package com.example.tmf666.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "external_reference")
public class ExternalReferences {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String externalReferenceType;

    @ManyToOne
    @JoinColumn(name = "application_owner_organization_id")
    private ApplicationOwnerOrganization applicationOwnerOrganization;
}
