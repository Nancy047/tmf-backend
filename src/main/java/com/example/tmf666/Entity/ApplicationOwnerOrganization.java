package com.example.tmf666.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "application_owner_organization")
public class ApplicationOwnerOrganization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String tradingName;
    private boolean isLegalEntity;
    private String organizationType;
    private String jurisdiction;
    private String privacyPolicyURL;
    private String taxNumber;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrganizationIdentification> organizationIdentification;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ExternalReferences> externalReference;

    @OneToOne(cascade = CascadeType.ALL)
    private GeographicAddress registeredGeopraphicAddress;

    @OneToMany(cascade = CascadeType.ALL)
    private List<EmailContactMedium> contactMedium;

    @OneToOne(cascade = CascadeType.ALL)
    private Organization dataProtectionOfficer;
}