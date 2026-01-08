package com.jayant.QuickRide.entities;

import com.jayant.QuickRide.entities.enums.role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    
    @Column(unique = true)
    private String email;
    private String password;

    @ElementCollection(fetch = FetchType.LAZY)           // Used to create separate table for Roles
    @Enumerated(EnumType.STRING)
    private Set<role> roles;
}
