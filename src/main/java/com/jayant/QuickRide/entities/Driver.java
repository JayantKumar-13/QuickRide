package com.jayant.QuickRide.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Point;

@Entity
@Getter
@Setter
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne                              // Each Driver is a single User
    @JoinColumn(name = "user_id")                   // foreign Key
    private User user;
    private Double rating;
    private Boolean available;

    private String VehicleId;

    // Geometry for Hibernate to identify it as Spatial
    @Column(columnDefinition = "Geometry(Point,4326)")     // 4326 -> We are dealing with earth locations
    private Point currentLocation;

}
