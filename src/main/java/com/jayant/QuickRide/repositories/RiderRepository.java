package com.jayant.QuickRide.repositories;

import com.jayant.QuickRide.entities.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiderRepository extends JpaRepository<Rider , Long> {
}
