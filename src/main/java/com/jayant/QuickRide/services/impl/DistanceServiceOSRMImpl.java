package com.jayant.QuickRide.services.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jayant.QuickRide.services.DistanceService;
import lombok.Data;
import org.locationtech.jts.geom.Point;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class DistanceServiceOSRMImpl implements DistanceService {

    private static final String OSRM_API_BASE_URL =
            "https://router.project-osrm.org/route/v1/driving/";

    private final RestClient client = RestClient.builder()
            .baseUrl(OSRM_API_BASE_URL)
            .defaultHeader("User-Agent", "QuickRide/1.0")
            .defaultHeader("Accept", MediaType.APPLICATION_JSON_VALUE)
            .build();

    @Override
    public double calculateDistance(Point src, Point dest) {

        String uri =
                src.getX() + "," + src.getY() + ";" +
                        dest.getX() + "," + dest.getY() +
                        "?overview=false";

        OSRMResponseDto response = client
                .get()
                .uri(uri)
                .retrieve()
                .body(OSRMResponseDto.class);

        if (response == null ||
                response.getRoutes() == null ||
                response.getRoutes().isEmpty()) {
            throw new RuntimeException("No route returned from OSRM");
        }

        return response.getRoutes().get(0).getDistance() / 1000.0;
    }
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class OSRMResponseDto {
    private String code;
    private List<OSRMRoute> routes;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class OSRMRoute {
    private Double distance;
    private Double duration;
}
