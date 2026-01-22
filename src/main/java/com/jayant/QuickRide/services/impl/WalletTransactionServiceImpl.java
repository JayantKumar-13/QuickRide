package com.jayant.QuickRide.services.impl;

import com.jayant.QuickRide.entities.WalletTransaction;
import com.jayant.QuickRide.repositories.WalletTransactionRepository;
import com.jayant.QuickRide.services.WalletTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletTransactionServiceImpl implements WalletTransactionService {


    private final WalletTransactionRepository walletTransactionRepository;

    @Override
    public void createNewWalletTransaction(WalletTransaction walletTransaction) {
        walletTransactionRepository.save(walletTransaction);
    }
}
