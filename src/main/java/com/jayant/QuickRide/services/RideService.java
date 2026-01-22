package com.jayant.QuickRide.services;

import com.jayant.QuickRide.dto.RideRequestDto;
import com.jayant.QuickRide.entities.Driver;
import com.jayant.QuickRide.entities.Ride;
import com.jayant.QuickRide.entities.RideRequest;
import com.jayant.QuickRide.entities.Rider;
import com.jayant.QuickRide.entities.enums.RideStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RideService {

    Ride getRideById(Long rideId);

    void matchWithDrivers(RideRequestDto rideRequestDto);

    Ride createNewRide(RideRequest rideRequest , Driver driver);

    Ride updateRideStatus(Ride ride , RideStatus rideStatus);

    Page<Ride> getAllRidesOfRider(Rider rider , PageRequest pageRequest);

    Page<Ride> getAllRidesOfDriver(Driver driver , PageRequest pageRequest);
}
