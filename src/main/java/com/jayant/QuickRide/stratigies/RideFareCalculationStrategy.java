package com.jayant.QuickRide.stratigies;

import com.jayant.QuickRide.entities.RideRequest;

public interface RideFareCalculationStrategy {

    double RIDE_FARE_PRICE_PER_KM = 10;

    double calculateFare(RideRequest rideRequest);
}
