package com.example.tmf666.Entity;


import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class ExternalIdentifier {

    private String externalIdentifierType;
    private String idValue;
    private String owner;


}
