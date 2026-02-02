package com.jayant.QuickRide.services.impl;

import com.jayant.QuickRide.dto.DriverDto;
import com.jayant.QuickRide.dto.SignUpDto;
import com.jayant.QuickRide.dto.UserDto;
import com.jayant.QuickRide.entities.Driver;
import com.jayant.QuickRide.entities.User;
import com.jayant.QuickRide.entities.enums.role;
import com.jayant.QuickRide.exceptions.ResourceNotFoundException;
import com.jayant.QuickRide.exceptions.RuntimeConflictException;
import com.jayant.QuickRide.repositories.UserRepository;
import com.jayant.QuickRide.security.JWTService;
import com.jayant.QuickRide.services.AuthService;
import com.jayant.QuickRide.services.DriverService;
import com.jayant.QuickRide.services.RiderService;
import com.jayant.QuickRide.services.WalletService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

import static com.jayant.QuickRide.entities.enums.role.DRIVER;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RiderService riderService;
    private final WalletService walletService;
    private final DriverService driverService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    @Override
    public String[] login(String email, String password) {
        Authentication authentication =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email , password));

        User user = (User) authentication.getPrincipal();

        String accessToken = jwtService.generateAccessToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);

        return new String[]{accessToken, refreshToken};
    }

    @Override
    @Transactional
    public UserDto signUp(SignUpDto signUpDto) {
        User user = userRepository.findByEmail(signUpDto.getEmail()).orElse(null);
        if(user != null)
            throw new RuntimeConflictException("Cannot signup, User already exists with email "+signUpDto.getEmail());


        User mappedUser = modelMapper.map(signUpDto, User.class);
        mappedUser.setRoles(Set.of(role.RIDER));         // By default user will be Rider
        mappedUser.setPassword(passwordEncoder.encode(mappedUser.getPassword()));
        User savedUser = userRepository.save(mappedUser);

//        create user related entities
        riderService.createNewRider(savedUser);

        // We Added Transactional so that if the user and rider gets created, but somehow if rider is not
        //created then user will be saved in db , but rider will not . This will create data inconsistency.
        // Transaction help in rollback. If rider is not saved , then user will also not get saved

        walletService.createNewWallet(savedUser);

        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public DriverDto onboardNewDriver(Long userId, String vehicleId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id "+userId));

        if(user.getRoles().contains(DRIVER))
            throw new RuntimeConflictException("User with id "+userId+" is already a Driver");

        Driver createDriver = Driver.builder()
                .user(user)
                .rating(0.0)
                .vehicleId(vehicleId)
                .available(true)
                .build();
        user.getRoles().add(DRIVER);
        userRepository.save(user);
        Driver savedDriver = driverService.createNewDriver(createDriver);
        return modelMapper.map(savedDriver, DriverDto.class);
    }

    @Override
    public String refreshToken(String refreshToken) {
        Long userId = jwtService.getUserIdFromToken(refreshToken);
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found " +
                "with id: "+userId));

        return jwtService.generateAccessToken(user);
    }
}

