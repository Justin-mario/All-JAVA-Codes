package com.maven.bank.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CurrentAccount extends Account{
    public CurrentAccount() {
        setStartDate ( LocalDateTime.now () );
    }

    public CurrentAccount(long accountNumber){
        this();
        setAccountNumber ( accountNumber );
    }
    public CurrentAccount(long accountNumber, BigDecimal balance){
        this(accountNumber);
        setBalance ( balance );
    }

}
