package com.jayant.QuickRide.services;

import com.jayant.QuickRide.dto.DriverDto;
import com.jayant.QuickRide.dto.SignUpDto;
import com.jayant.QuickRide.dto.UserDto;

public interface AuthService {

    String[] login(String email , String password);

    UserDto signUp(SignUpDto signUpDto);

    DriverDto onboardNewDriver(Long userId, String vehicleId);

    String refreshToken(String refreshToken);
}
