package com.example.tmf666.Pojo;

import com.example.tmf666.Entity.ApplicationOwner;
import com.example.tmf666.Entity.DigitalIdentity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationResponse {
    private String id;
    private String type;
    private String baseType;
    private String name;
    private String description;
    private String commercialName;
    private String category;
    private String operationalState;
    private String approvalStatus;
    private DigitalIdentity digitalIdentity;
    private ApplicationOwner applicationOwner;
}
