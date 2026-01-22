package com.jayant.QuickRide.services;

import com.jayant.QuickRide.entities.RideRequest;

public interface RideRequestService {

    RideRequest findRideRequestById(Long rideRequestId);

    void update(RideRequest rideRequest);
}
