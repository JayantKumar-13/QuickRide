package com.jayant.QuickRide.stratigies;

import com.jayant.QuickRide.dto.RideRequestDto;
import com.jayant.QuickRide.entities.Driver;

import java.util.List;

public interface DriverMatchingStrategy {

    List<Driver> findMatchingDrivers(RideRequestDto rideRequestDto);
}
