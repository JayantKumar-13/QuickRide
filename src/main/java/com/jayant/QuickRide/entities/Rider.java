package com.jayant.QuickRide.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Rider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne                              // Each Rider is a single User
    @JoinColumn(name = "user_id")                   // foreign Key
    private User user;
    private Double rating;
    
}
