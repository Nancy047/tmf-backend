package com.example.tmf666.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationFieldSelection {
    private String id;
    private String type;
    private String href;
    private String approvalStatus;
}
