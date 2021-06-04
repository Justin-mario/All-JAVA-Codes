package com.CHAPTER_EIGHT.SavingAccount;

public class SavingAccountInterestRateCalculator {
    public static void main(String[] args) {

        SavingsAccount saver1 = new SavingsAccount ();
        SavingsAccount saver2 = new SavingsAccount ();
        saver1.calculateMonthlyInterestRate ( 3000 );
        saver2.calculateMonthlyInterestRate ( 4000 );
    }

}
