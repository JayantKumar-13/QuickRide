package com.jayant.QuickRide.dto;

import com.jayant.QuickRide.entities.enums.PaymentMethod;
import com.jayant.QuickRide.entities.enums.RideRequestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideRequestDto {


    private Long id;

    private PointDto pickupLocation;

    private PointDto dropLocation;

    private LocalDateTime requestedTime;

    private RiderDto rider;

    private Double fare;

    private PaymentMethod paymentMethod;

    private RideRequestStatus rideRequestStatus;
}
