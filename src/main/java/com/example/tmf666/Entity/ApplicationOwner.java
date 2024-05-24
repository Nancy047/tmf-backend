package com.example.tmf666.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "application_owner")
public class ApplicationOwner implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    private ApplicationOwnerOrganization engagedParty;

    private String status;

    @OneToOne(cascade = CascadeType.ALL)
    private PartyRoleRef channelPartner;
}