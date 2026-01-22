package com.jayant.QuickRide.stratigies.impl;

import com.jayant.QuickRide.entities.RideRequest;
import com.jayant.QuickRide.services.DistanceService;
import com.jayant.QuickRide.stratigies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideFareSurgePricingFareCalculationStrategyImpl implements RideFareCalculationStrategy {
    private final DistanceService distanceService;
    private static final double SURGE_FACTOR = 2;           // It can change due to weather say rain

    @Override
    public double calculateFare(RideRequest rideRequest) {
        double distance = distanceService.calculateDistance(rideRequest.getPickupLocation(),
                rideRequest.getDropLocation());
        return distance*RIDE_FARE_PRICE_PER_KM*SURGE_FACTOR;
    }
}
