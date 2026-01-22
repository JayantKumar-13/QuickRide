package com.jayant.QuickRide.services;

import com.jayant.QuickRide.entities.Payment;
import com.jayant.QuickRide.entities.Ride;
import com.jayant.QuickRide.entities.enums.PaymentStatus;

public interface PaymentService {

    void processPayment(Ride ride);

    Payment createNewPayment(Ride ride);

    void updatePaymentStatus(Payment payment, PaymentStatus status);
}