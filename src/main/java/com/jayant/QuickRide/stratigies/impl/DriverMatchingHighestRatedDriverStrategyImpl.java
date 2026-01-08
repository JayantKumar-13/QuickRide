package com.jayant.QuickRide.stratigies.impl;

import com.jayant.QuickRide.dto.RideRequestDto;
import com.jayant.QuickRide.entities.Driver;
import com.jayant.QuickRide.stratigies.DriverMatchingStrategy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverMatchingHighestRatedDriverStrategyImpl implements DriverMatchingStrategy {
    @Override
    public List<Driver> findMatchingDrivers(RideRequestDto rideRequestDto) {
        return List.of();
    }
}
