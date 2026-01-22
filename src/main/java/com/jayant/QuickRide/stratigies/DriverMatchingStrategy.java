package com.jayant.QuickRide.stratigies;

import com.jayant.QuickRide.entities.Driver;
import com.jayant.QuickRide.entities.RideRequest;

import java.util.List;

public interface DriverMatchingStrategy {

    List<Driver> findMatchingDrivers(RideRequest rideRequest);
}
