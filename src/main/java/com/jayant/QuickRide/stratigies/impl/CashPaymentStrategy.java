package com.jayant.QuickRide.stratigies.impl;

import com.jayant.QuickRide.entities.Driver;
import com.jayant.QuickRide.entities.Payment;
import com.jayant.QuickRide.entities.enums.PaymentStatus;
import com.jayant.QuickRide.entities.enums.TransactionMethod;
import com.jayant.QuickRide.repositories.PaymentRepository;
import com.jayant.QuickRide.services.WalletService;
import com.jayant.QuickRide.stratigies.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CashPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
    private final PaymentRepository paymentRepository;

    @Override
    public void processPayment(Payment payment) {
        Driver driver = payment.getRide().getDriver();

        double platformCommission = payment.getAmount() * PLATFORM_COMMISSION;

        walletService.deductMoneyFromWallet(driver.getUser(), platformCommission, null,
                payment.getRide(), TransactionMethod.RIDE);

        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);

    }
}
