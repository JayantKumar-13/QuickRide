package com.jayant.QuickRide.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverDto {

    private UserDto user;
    private Double rating;
    private Long id;
    private Boolean available;
    private String vehicleId;
}
