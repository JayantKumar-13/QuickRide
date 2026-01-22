package com.jayant.QuickRide.stratigies.impl;

import com.jayant.QuickRide.entities.Driver;
import com.jayant.QuickRide.entities.RideRequest;
import com.jayant.QuickRide.repositories.DriverRepository;
import com.jayant.QuickRide.stratigies.DriverMatchingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverMatchingHighestRatedDriverStrategyImpl implements DriverMatchingStrategy {

    private final DriverRepository driverRepository;

    @Override
    public List<Driver> findMatchingDrivers(RideRequest rideRequest) {
        return driverRepository.findTenNearbyTopRatedDrivers(rideRequest.getPickupLocation());
    }


}
