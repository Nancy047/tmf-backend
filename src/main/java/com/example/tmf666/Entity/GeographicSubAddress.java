package com.example.tmf666.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "geographic_sub_address")
public class GeographicSubAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String buildingName;
    private String subUnitNumber;

    @ManyToOne
    @JoinColumn(name = "geographic_address_id")
    private GeographicAddress geographicAddress;
}
