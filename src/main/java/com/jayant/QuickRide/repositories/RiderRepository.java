package com.jayant.QuickRide.repositories;

import com.jayant.QuickRide.entities.Rider;
import com.jayant.QuickRide.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RiderRepository extends JpaRepository<Rider , Long> {
    Optional<Rider> findByUser(User user);
}
