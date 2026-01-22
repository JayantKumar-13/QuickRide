package com.jayant.QuickRide.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor         // For jackson
public class PointDto {
    // This is made to help serialize and Deserialize the Point data for Jackson
    private double[] coordinates;
    private String type = "Point";

    public PointDto(double[] coordinates) {
        this.coordinates = coordinates;
    }
}
