package com.example.tmf666.Entity;



import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

import java.util.List;


@Entity
@Data
public class ApiProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ElementCollection
    private List<ExternalIdentifier> externalId;

    private String description;

    @OneToMany(mappedBy = "apiProductOrder", cascade = CascadeType.ALL)
    private List<ApiProductOrderItem> productOrderItem;


}
