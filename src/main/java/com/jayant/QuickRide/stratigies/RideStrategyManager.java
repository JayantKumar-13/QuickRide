package com.jayant.QuickRide.stratigies;

import com.jayant.QuickRide.stratigies.impl.DriverMatchingHighestRatedDriverStrategyImpl;
import com.jayant.QuickRide.stratigies.impl.DriverMatchingNearestDriverStrategyImpl;
import com.jayant.QuickRide.stratigies.impl.RideFareDefaultFareCalculationStrategyImpl;
import com.jayant.QuickRide.stratigies.impl.RideFareSurgePricingFareCalculationStrategyImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@RequiredArgsConstructor
public class RideStrategyManager {        // It is used to return any strategy

    private final DriverMatchingHighestRatedDriverStrategyImpl highestRatedDriverStrategy;
    private final DriverMatchingNearestDriverStrategyImpl nearestDriverStrategy;
    private final RideFareSurgePricingFareCalculationStrategyImpl surgePricingFareCalculationStrategy;
    private final RideFareDefaultFareCalculationStrategyImpl defaultFareCalculationStrategy;


    public DriverMatchingStrategy driverMatchingStrategy(double riderRating) {
        if(riderRating >= 4.8) {
            return highestRatedDriverStrategy;
        } else {
            return nearestDriverStrategy;
        }
    }

    public RideFareCalculationStrategy rideFareCalculationStrategy() {

//        6PM to 9PM is SURGE TIME
        LocalTime surgeStartTime = LocalTime.of(18, 0);
        LocalTime surgeEndTime = LocalTime.of(21, 0);
        LocalTime currentTime = LocalTime.now();

        boolean isSurgeTime = currentTime.isAfter(surgeStartTime) && currentTime.isBefore(surgeEndTime);

        if(isSurgeTime) {
            return surgePricingFareCalculationStrategy;
        } else {
            return defaultFareCalculationStrategy;
        }
    }
}
