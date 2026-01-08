package com.jayant.QuickRide.stratigies;

import com.jayant.QuickRide.dto.RideRequestDto;

public interface RideFareCalculationStrategy {

    double calculateFare(RideRequestDto rideRequestDto);
}
