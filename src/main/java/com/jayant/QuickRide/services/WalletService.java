package com.jayant.QuickRide.services;

import com.jayant.QuickRide.entities.Ride;
import com.jayant.QuickRide.entities.User;
import com.jayant.QuickRide.entities.Wallet;
import com.jayant.QuickRide.entities.enums.TransactionMethod;

public interface WalletService {

    Wallet addMoneyToWallet(User user, Double amount,String transactionId, Ride ride, TransactionMethod transactionMethod);

    Wallet deductMoneyFromWallet(User user, Double amount, String transactionId, Ride ride, TransactionMethod transactionMethod);

    void withdrawAllMyMoneyFromWallet();

    Wallet findWalletById(Long walletId);

    Wallet createNewWallet(User user);

    Wallet findByUser(User user);

}
