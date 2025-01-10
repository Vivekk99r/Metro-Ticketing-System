package com.metro.model;

import jakarta.persistence.*;

@Entity
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stationId;
    private String name;

    // Getters and Setters
}
