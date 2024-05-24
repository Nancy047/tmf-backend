package com.example.tmf666.Entity;


import lombok.Data;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;
@Embeddable
@Data
public class ValidFor {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
