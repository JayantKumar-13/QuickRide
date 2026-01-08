package com.jayant.QuickRide.stratigies.impl;

import com.jayant.QuickRide.dto.RideRequestDto;
import com.jayant.QuickRide.stratigies.RideFareCalculationStrategy;
import org.springframework.stereotype.Service;

@Service
public class RideFareDefaultFareCalculationStrategyImpl implements RideFareCalculationStrategy {
    @Override
    public double calculateFare(RideRequestDto rideRequestDto) {
        return 0;
    }
}
