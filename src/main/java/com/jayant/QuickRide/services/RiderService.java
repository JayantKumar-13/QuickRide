package com.jayant.QuickRide.services;

import com.jayant.QuickRide.dto.DriverDto;
import com.jayant.QuickRide.dto.RideDto;
import com.jayant.QuickRide.dto.RideRequestDto;
import com.jayant.QuickRide.dto.RiderDto;
import com.jayant.QuickRide.entities.Rider;
import com.jayant.QuickRide.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface RiderService {


    RideRequestDto requestRide(RideRequestDto rideRequestDto);

    RideDto cancelRide(Long rideId);

    DriverDto rateDriver(Long rideId , Integer rating);

    RiderDto getMyProfile();

    Page<RideDto> getAllMyRides(PageRequest pageRequest);

    Rider createNewRider(User savedUser);

    Rider getCurrentRider();
}
