package com.example.tmf666.Entity;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Data
@Table(name = "settlementaccount")
public class SettlementAccount {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String href;
    private String accountType;
    private String description;
    private LocalDateTime lastModified;
    private String name;
    private String paymentStatus;
    private String state;


    private String relationshipType;


    private Integer billingDateShift;
    private String billingPeriod;
    private Integer chargeDateOffset;
    private Integer creditDateOffset;
    private Integer dateShift;

    private String frequency;

    private boolean isRef = true;
    private Integer mailingDateOffset;

    private Integer paymentDueDateOffset;
    private String reason;
    private String issuingJurisdiction;
    private String certificateNumber;


    @Column(name = "number_of_payments")
    private Integer numberOfPayments;

    private String paymentFrequency;
    private String planType;
    private Integer priority;
    private String status;


    @Embedded
    private Money totalAmount;

    @Embedded
    private TimePeriod validFor;



}
