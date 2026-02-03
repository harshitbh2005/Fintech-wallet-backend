package com.paytmclone.wallet_system.repository;

import com.paytmclone.wallet_system.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByFromUserOrToUser(Long fromUser, Long toUser);
}
