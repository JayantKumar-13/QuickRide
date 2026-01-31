package com.jayant.QuickRide.repositories;

import com.jayant.QuickRide.entities.Driver;
import com.jayant.QuickRide.entities.User;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    @Query(value = "SELECT d.*, ST_Distance(d.current_location, :pickupLocation) AS distance " +
            "FROM driver d " +
            "WHERE d.available = true AND ST_DWithin(d.current_location, :pickupLocation, 10000) " +
            "ORDER BY distance " +
            "LIMIT 10", nativeQuery = true)
    List<Driver> findNearestDrivers(Point pickupLocation);


    //nativeQuery = true -> This means it is a Sql Query


    //TODO ST_Distance and ST_DWithin are special functions from the
    // geospatial database which is used to calculate distance

    //When we add colon(:) :pickupLocation , variable under the function is picked as the parameter
    //From here findNearestDrivers(Point pickupLocation);
    //TODO Add space after every line , o/w our query will break



    @Query(value = "SELECT d.* " +
            "FROM driver d " +
            "WHERE d.available = true AND ST_DWithin(d.current_location, :pickupLocation, 15000) " +
            "ORDER BY d.rating DESC " +
            "LIMIT 10", nativeQuery = true)
    List<Driver> findTenNearbyTopRatedDrivers(Point pickupLocation);

    Optional<Driver> findByUser(User user);
}
