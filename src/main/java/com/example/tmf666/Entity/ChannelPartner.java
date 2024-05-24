package com.example.tmf666.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "channel_partner")
public class ChannelPartner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;

}
