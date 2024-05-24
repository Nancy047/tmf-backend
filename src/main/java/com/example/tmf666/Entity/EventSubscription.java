package com.example.tmf666.Entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Setter
@Getter
public class EventSubscription {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private  String callback;
    private  String query;

}
