package com.paytmclone.wallet_system.service;

import com.paytmclone.wallet_system.model.*;
import com.paytmclone.wallet_system.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class WalletService {

    private final WalletRepository walletRepository;
    private final TransactionRepository transactionRepository;

    public WalletService(WalletRepository walletRepository,
                         TransactionRepository transactionRepository) {
        this.walletRepository = walletRepository;
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public void transfer(Long fromUserId, Long toUserId, BigDecimal amount) {

        Wallet sender = walletRepository.findByUserId(fromUserId)
                .orElseThrow(() -> new RuntimeException("Sender wallet not found"));

        Wallet receiver = walletRepository.findByUserId(toUserId)
                .orElseThrow(() -> new RuntimeException("Receiver wallet not found"));

        if (sender.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Insufficient balance");
        }

        sender.setBalance(sender.getBalance().subtract(amount));
        receiver.setBalance(receiver.getBalance().add(amount));

        walletRepository.save(sender);
        walletRepository.save(receiver);

        Transaction tx = new Transaction();
        tx.setFromUser(fromUserId);
        tx.setToUser(toUserId);
        tx.setAmount(amount);
        tx.setStatus("SUCCESS");
        tx.setTime(LocalDateTime.now());

        transactionRepository.save(tx);
    }

    public BigDecimal getBalance(Long userId) {
        Wallet wallet = walletRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Wallet not found"));
        return wallet.getBalance();
    }

    public List<Transaction> getTransactions(Long userId) {
        return transactionRepository.findByFromUserOrToUser(userId, userId);
    }
}
