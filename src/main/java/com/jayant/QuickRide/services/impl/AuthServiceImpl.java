package com.jayant.QuickRide.services.impl;

import com.jayant.QuickRide.dto.DriverDto;
import com.jayant.QuickRide.dto.SignUpDto;
import com.jayant.QuickRide.dto.UserDto;
import com.jayant.QuickRide.entities.User;
import com.jayant.QuickRide.entities.enums.role;
import com.jayant.QuickRide.exceptions.RuntimeConflictException;
import com.jayant.QuickRide.repositories.UserRepository;
import com.jayant.QuickRide.services.AuthService;
import com.jayant.QuickRide.services.RiderService;
import com.jayant.QuickRide.services.WalletService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RiderService riderService;
    private final WalletService walletService;

    @Override
    public String login(String email, String password) {
        return "";
    }

    @Override
    @Transactional
    public UserDto signUp(SignUpDto signUpDto) {
        User user = userRepository.findByEmail(signUpDto.getEmail()).orElse(null);
        if(user != null)
            throw new RuntimeConflictException("Cannot signup, User already exists with email "+signUpDto.getEmail());


        User mappedUser = modelMapper.map(signUpDto, User.class);
        mappedUser.setRoles(Set.of(role.RIDER));         // By default user will be Rider
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
    public DriverDto onBoardNewDriver(Long userId) {
        return null;
    }
}

