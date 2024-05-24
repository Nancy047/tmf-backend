package com.example.tmf666.Entity;



import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "api_consumer_role")
public class ApiConsumerRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String baseType;
    private String name;
    @ManyToOne
    @JoinColumn(name = "application_id")
    private ApplicationApproval application;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "apiConsumerRole")
    private List<GrantedPermissionSet> grantedPermissionSet;

}
