package com.example.tmf666.Entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Data
@Getter
@Setter
@Embeddable
public class MediumCharacteristic {

    private String city;
    private String contactType;
    private String country;
    private String emailAddress;
    private String faxNumber;
    private String phoneNumber;
    private String postCode;
    private String socialNetworkId;
    private String stateOrProvince;
    private String street1;
    private String street2;
}
