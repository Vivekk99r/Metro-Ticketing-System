package com.metro.model;

import jakarta.persistence.*;

@Entity
public class UserCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;
    private String userName;
    private double balance;

    // Getters and Setters
}
