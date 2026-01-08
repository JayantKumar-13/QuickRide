package com.jayant.QuickRide.dto;

import com.jayant.QuickRide.entities.Driver;
import com.jayant.QuickRide.entities.Rider;
import com.jayant.QuickRide.entities.enums.PaymentMethod;
import com.jayant.QuickRide.entities.enums.RideStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Data
public class RideDto {


    private Long id;
    private Point pickupLocation;
    private Point dropLocation;

    private LocalDateTime createdTime;

    private RiderDto rider;

    private DriverDto driver;
    private PaymentMethod paymentMethod;

    private RideStatus rideStatus;

    private Double fare;

    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
}
