package com.example.tmf666.Entity;
import javax.persistence.*;

import lombok.*;

import java.util.List;


@Data
@Entity
@Table(name = "financial_accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FinancialAccount {
    @Column(name = "financial_account_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "href")
    private String href;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "description")
    private String description;

    @Column(name = "last_modified")
    private String lastModified;

    @Column(name = "name")
    private String name;

    @Column(name = "state")
    private String state;
    private String mediumType;
    private boolean preferred;
    private String role;
//    @Embedded
//    private MediumCharacteristic characteristic;
    private String relationshipType;
    private String contactName;
    private String contactType;
    private String partyRoleType;
    private String reason;
    private String issuingJurisdiction;
    private String certificateNumber;
    @OneToMany(mappedBy = "financialAccount", cascade = CascadeType.ALL)
    private List<AccountBalance> accountBalances;



}
