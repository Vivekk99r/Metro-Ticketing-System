package com.metro.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @ManyToOne
    private UserCard userCard;

    private String sourceStation;
    private String destinationStation;
    private double fare;
    private LocalDateTime timestamp;

    // Getters and Setters
}
