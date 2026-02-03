package com.paytmclone.wallet_system.controller;

import com.paytmclone.wallet_system.model.Transaction;
import com.paytmclone.wallet_system.service.WalletService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    // Get wallet balance
    @GetMapping("/balance")
    public BigDecimal getBalance(@RequestParam Long userId) {
        return walletService.getBalance(userId);
    }

    // Transfer money
    @PostMapping("/transfer")
    public String transfer(@RequestParam Long fromUserId,
                           @RequestParam Long toUserId,
                           @RequestParam BigDecimal amount) {

        walletService.transfer(fromUserId, toUserId, amount);
        return "Transfer successful";
    }

    // Transaction history
    @GetMapping("/transactions")
    public List<Transaction> getTransactions(@RequestParam Long userId) {
        return walletService.getTransactions(userId);
    }
}
