package com.jayant.QuickRide.entities;

import com.jayant.QuickRide.entities.enums.TransactionMethod;
import com.jayant.QuickRide.entities.enums.TransactionType;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class WalletTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private Double amount;

    private TransactionType transactionType;

    private TransactionMethod transactionMethod;

    @OneToOne
    private Ride ride;

    private String TransactionId;

    @ManyToOne
    private Wallet wallet;            // One wallet can have many transactions

    private LocalDateTime timeStamp;
}
