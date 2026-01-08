package com.jayant.QuickRide.services;

import com.jayant.QuickRide.dto.DriverDto;
import com.jayant.QuickRide.dto.RideDto;
import com.jayant.QuickRide.dto.RideRequestDto;
import com.jayant.QuickRide.dto.RiderDto;

import java.util.List;

public interface RiderService {


    RideRequestDto requestRide(RideRequestDto rideRequestDto);

    RideDto cancelRide(Long rideId);

    DriverDto rateDriver(Long rideId , Integer rating);

    RiderDto getMyProfile();

    List<RideDto> getAllMyRides();
}
