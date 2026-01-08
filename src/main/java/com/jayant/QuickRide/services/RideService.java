package com.jayant.QuickRide.services;

import com.jayant.QuickRide.dto.RideRequestDto;
import com.jayant.QuickRide.entities.Driver;
import com.jayant.QuickRide.entities.Ride;
import com.jayant.QuickRide.entities.enums.RideStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RideService {

    Ride getRideById(Long rideId);

    void matchWithDrivers(RideRequestDto rideRequestDto);

    Ride createNewRide(RideRequestDto rideRequestDto , Driver driver);

    Ride updateRideStatus(Long rideId , RideStatus rideStatus);

    Page<Ride> getAllRidesOfRider(Long riderId , PageRequest pageRequest);

    Page<Ride> getAllRidesOfDriver(Long driverId , PageRequest pageRequest);
}
