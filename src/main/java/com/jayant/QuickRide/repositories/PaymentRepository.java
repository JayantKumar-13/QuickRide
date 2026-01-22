package com.jayant.QuickRide.repositories;

import com.jayant.QuickRide.entities.Payment;
import com.jayant.QuickRide.entities.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findByRide(Ride ride);
}