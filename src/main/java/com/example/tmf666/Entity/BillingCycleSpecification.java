package com.example.tmf666.Entity;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
@Entity
@Table(name = "BillingCycleSpecification")
public class BillingCycleSpecification {
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Id
private  Long id;
    private String href;
    private Integer billingDateShift;
    private String billingPeriod;
    private Integer chargeDateOffset;
    private Integer creditDateOffset;
    private Integer dateShift;

    private String description;
    private String frequency;

    private boolean isRef = true;
    private Integer mailingDateOffset;

    private String name;
    private Integer paymentDueDateOffset;
    @Embedded
    private TimePeriod validFor;


}

