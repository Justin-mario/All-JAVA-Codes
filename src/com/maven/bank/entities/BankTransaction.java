package com.maven.bank.entities;

import enums.BankTransactionType;
import com.maven.bank.services.BankService;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BankTransaction {
    private long id;
    private LocalDateTime dateTime;
    private BankTransactionType type;
    private BigDecimal amount;


    public BankTransaction( BankTransactionType type, BigDecimal txtAmount) {
        this.id = BankService.getGenerateTransactionId ();
        this.dateTime = LocalDateTime.now ();
        this.type = type;
        this.amount = txtAmount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public BankTransactionType getType() {
        return type;
    }

    public void setType(BankTransactionType type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
