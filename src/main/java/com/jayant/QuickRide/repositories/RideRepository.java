package com.jayant.QuickRide.repositories;

import com.jayant.QuickRide.entities.Driver;
import com.jayant.QuickRide.entities.Ride;
import com.jayant.QuickRide.entities.Rider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRepository extends JpaRepository<Ride, Long> {


    Page<Ride> findByRider(Rider rider, Pageable pageRequest);                  // Yaha pe Pageable likhe h , still kaise kaam kr rha kyuki service me to PageRequest h

    Page<Ride> findByDriver(Driver driver, Pageable pageRequest);
}
