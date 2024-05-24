package com.example.tmf666.Entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
@Table(name="api_assert_grp")
public class ApiConsumerPermissionManagedAssetGroup {
    private String type;
    private String baseType;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ApiProduct> apiProducts;
}