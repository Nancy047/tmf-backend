package com.example.tmf666.Entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
public class ApplicationApproval {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String href;
    private String approvalStatus;


    public void setOperationalState(String operationalState) {
    }
}
