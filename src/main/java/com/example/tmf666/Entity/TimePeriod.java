package com.example.tmf666.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;


@Setter
@Getter
@Data
@Embeddable
public class TimePeriod {
    private String startDateTime;
    private String endDateTime;
}
