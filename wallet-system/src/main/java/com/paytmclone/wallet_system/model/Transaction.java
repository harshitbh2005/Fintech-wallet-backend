package com.paytmclone.wallet_system.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long fromUser;
    private Long toUser;

    private BigDecimal amount;

    private String status;   // SUCCESS, FAILED

    private LocalDateTime time;

    public Long getId() {
        return id;
    }

    public Long getFromUser() {
        return fromUser;
    }

    public Long getToUser() {
        return toUser;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFromUser(Long fromUser) {
        this.fromUser = fromUser;
    }

    public void setToUser(Long toUser) {
        this.toUser = toUser;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
