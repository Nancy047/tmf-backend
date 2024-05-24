package com.example.tmf666.Entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Application implements Serializable {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String type;
    private String baseType;
    private String name;
    private String description;
    private String commercialName;
    private String category;
    private String operationalState;
    private String approvalStatus;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "digitalIdentity_id", referencedColumnName = "clientId")
    private DigitalIdentity digitalIdentity;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "application")
    private List<ApiConsumerRole> apiConsumerRole;
    @ManyToOne
    @JoinColumn(name = "applicationOwner_id", referencedColumnName = "id")
    private ApplicationOwner applicationOwner;
    @ManyToOne
    @JoinColumn(name = "channelPartner_id", referencedColumnName = "id")
    private ChannelPartner channelPartner;

}