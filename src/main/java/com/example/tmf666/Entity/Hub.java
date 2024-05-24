package com.example.tmf666.Entity;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Data
@Table(name = "hubaccount")
public class Hub {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String href;
    private String callback;
    private String query;


}