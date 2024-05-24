package com.example.tmf666.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.net.URI;

@Data
@Setter
@Getter

public class Error {


    private String code;
    private String reason;
    private String message;
    private String status;
    private URI referenceError;
}

