package com.jayant.QuickRide.stratigies;

import com.jayant.QuickRide.entities.Payment;

public interface PaymentStrategy {

    Double PLATFORM_COMMISSION = 0.3;
    void processPayment(Payment payment);
}
