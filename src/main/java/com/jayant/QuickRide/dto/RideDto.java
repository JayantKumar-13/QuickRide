package com.jayant.QuickRide.dto;

import com.jayant.QuickRide.entities.enums.PaymentMethod;
import com.jayant.QuickRide.entities.enums.RideStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RideDto {


    private Long id;
    private PointDto pickupLocation;
    private PointDto dropLocation;

    private LocalDateTime createdTime;

    private RiderDto rider;

    private DriverDto driver;
    private PaymentMethod paymentMethod;

    private RideStatus rideStatus;

    private Double fare;

    private LocalDateTime startedAt;
    private LocalDateTime endedAt;

    private String otp;
}
