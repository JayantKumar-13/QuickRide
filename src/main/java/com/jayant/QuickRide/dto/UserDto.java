package com.jayant.QuickRide.dto;

import com.jayant.QuickRide.entities.enums.role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String name;
    private String email;
    private Set<role> roles;
}
