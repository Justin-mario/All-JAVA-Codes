package com.CHAPTER_EIGHT.SavingAccount;

public class SavingsAccount {
    private static double annualInterestRate = 0.04;
    private double savingsBalance;
    private int monthsInAYear = 12;
    double newMonthlyInterestRate;


    public double calculateMonthlyInterestRate(double savingBalance) {
        savingsBalance = savingBalance;
        for (int i = 1; i <= 12; i++){
        double monthlyInterestRate = savingBalance * annualInterestRate/monthsInAYear;
        savingBalance = savingBalance + monthlyInterestRate; }

        newMonthlyInterestRate = savingBalance * modifyInterestRate () /monthsInAYear;
        double newSavingBalance = newMonthlyInterestRate + savingBalance;
        System.out.println ("Savings Account Balance After 12 Months\t" + savingBalance + "\n");
        System.out.println ("Final Saving Account Balance After Change in Interest Rate To 5%\t" + newSavingBalance + "\n");
        return savingBalance;

    }

    public static double modifyInterestRate(){
        annualInterestRate = 0.05;
        return annualInterestRate;
    }
}
