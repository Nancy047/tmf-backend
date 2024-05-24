package com.example.tmf666.Entity;

import javax.persistence.*;

@Entity
@Table(name = "PARTY_ROLE_REF")
public class PartyRoleRef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "channelPartner_id")
    private Long id;

}
