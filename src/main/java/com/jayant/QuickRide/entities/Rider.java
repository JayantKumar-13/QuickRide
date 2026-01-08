package com.jayant.QuickRide.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Rider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne                              // Each Rider is a single User
    @JoinColumn(name = "user_id")                   // foreign Key
    private User user;
    private Double rating;
    
}
