package com.jayant.QuickRide.services.impl;

import com.jayant.QuickRide.dto.DriverDto;
import com.jayant.QuickRide.dto.RideDto;
import com.jayant.QuickRide.dto.RideRequestDto;
import com.jayant.QuickRide.dto.RiderDto;
import com.jayant.QuickRide.services.RiderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiderServiceImpl implements RiderService {
    @Override
    public RideRequestDto requestRide(RideRequestDto rideRequestDto) {
        return null;
    }

    @Override
    public RideDto cancelRide(Long rideId) {
        return null;
    }

    @Override
    public DriverDto rateDriver(Long rideId, Integer rating) {
        return null;
    }

    @Override
    public RiderDto getMyProfile() {
        return null;
    }

    @Override
    public List<RideDto> getAllMyRides() {
        return List.of();
    }
}
