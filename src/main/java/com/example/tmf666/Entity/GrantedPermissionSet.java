package com.example.tmf666.Entity;



import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Data
@Table(name = "granted_permission_set")
public class GrantedPermissionSet {
    @Id
    private String id;
    private String type;
    private String baseType;
    private LocalDateTime creationDate;
    @Embedded
    private ValidFor validFor;
    @OneToOne(cascade = CascadeType.ALL)
    private ApiConsumerPermissionManagedAssetGroup apiConsumerPermissionManagedAssetGroup;

    @ManyToOne
    @JoinColumn(name = "api_consumer_role_id")
    private ApiConsumerRole apiConsumerRole;

}