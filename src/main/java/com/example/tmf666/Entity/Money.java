package com.example.tmf666.Entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Setter
@Getter
@Data
@Embeddable
public class Money {
    @Column(name = "unit", insertable = false, updatable = false)
    private String unit;

    @Column(name = "balance_value")
    private float value;
}
