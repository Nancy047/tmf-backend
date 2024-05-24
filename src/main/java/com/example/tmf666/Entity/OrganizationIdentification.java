package com.example.tmf666.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "organization_identification")
public class OrganizationIdentification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String identificationType;
    private String identificationId;
    private String issuingAuthority;

    @ManyToOne
    @JoinColumn(name = "application_owner_organization_id")
    private ApplicationOwnerOrganization applicationOwnerOrganization;
}