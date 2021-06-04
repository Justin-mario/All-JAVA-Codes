package com.CHAPTER_EIGHT.SavingAccountTest;

import com.CHAPTER_EIGHT.SavingAccount.SavingsAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {
    double monthlyBalance;
    @Test
        void checkMonthlyInterestRateCanBeCalculatedForFirstMonth
            (){
        SavingsAccount savingsAccount = new SavingsAccount ();
        double monthlyBalance = savingsAccount.calculateMonthlyInterestRate(3000);
        assertEquals ( 3010, monthlyBalance);
    }

    @Test
    void checkMonthlyInterestRateCanBeCalculatedForSecondMonth
            (){
        SavingsAccount savingsAccount = new SavingsAccount ();
        monthlyBalance = savingsAccount.calculateMonthlyInterestRate(3000);
        monthlyBalance = savingsAccount.calculateMonthlyInterestRate(3010);
        assertEquals ( 3020.0333333333333, monthlyBalance);
    }

    @Test
    void checkMonthlyInterestRateCanBeCalculatedForTwelfthMonth
            (){
        SavingsAccount savingsAccount = new SavingsAccount ();
        monthlyBalance = savingsAccount.calculateMonthlyInterestRate(3111.8517894611646);
        assertEquals ( 3238.633432701521, monthlyBalance);
    }
}