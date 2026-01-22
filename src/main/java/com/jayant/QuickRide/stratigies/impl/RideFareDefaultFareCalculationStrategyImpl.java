package com.jayant.QuickRide.stratigies.impl;

import com.jayant.QuickRide.entities.RideRequest;
import com.jayant.QuickRide.services.DistanceService;
import com.jayant.QuickRide.stratigies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
//@Primary
@Service
public class RideFareDefaultFareCalculationStrategyImpl implements RideFareCalculationStrategy {

    private final DistanceService distanceService;

    @Override
    public double calculateFare(RideRequest rideRequest) {
        double distance = distanceService.calculateDistance(rideRequest.getPickupLocation() , rideRequest.getDropLocation());
        return distance*RIDE_FARE_PRICE_PER_KM;
    }
}
