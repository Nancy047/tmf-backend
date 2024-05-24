package com.example.tmf666.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
@Table(name = "Account_Balance")
public class AccountBalance {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long accountBalance_id;

    private String balanceType;
    @Embedded
    private Money amount;
    @Embedded
    private TimePeriod validFor;

    @ManyToOne
    @JoinColumn(name = "financial_account_id")
    private FinancialAccount financialAccount;

}
