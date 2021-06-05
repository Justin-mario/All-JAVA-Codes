package com.CHAPTER_EIGHT.Account;

import java.math.BigDecimal;

public class AccountWithBigDecimal {
    private String name;
    private BigDecimal balance = BigDecimal.valueOf ( 0.0 );

    public AccountWithBigDecimal(String accountName, BigDecimal accountBalance) {
        name = accountName;
        if (balance.doubleValue () > 0.0)
        balance = accountBalance;

    }

    public BigDecimal deposit(BigDecimal depositAmount) {
        if (depositAmount.doubleValue () > 0.0 ){
        balance = BigDecimal.valueOf ( 0.0 );
        balance = balance.add ( depositAmount ) ;}
        else{
            return balance;
        }
        return balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String setAccountName(String accountName) {
        name = accountName;
        return name;
    }

    public String getAccountName() {
        return name;
    }
}
