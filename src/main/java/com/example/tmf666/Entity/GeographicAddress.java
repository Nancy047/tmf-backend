package com.example.tmf666.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "geographic_address")
public class GeographicAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private String locality;
    private String country;
    private String postcode;
    private String stateOrProvince;
    private String streetMane;
    private String streetType;
    private String streetNr;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "geographicAddress")
    private List<GeographicSubAddress> geographicSubAddress;
}
