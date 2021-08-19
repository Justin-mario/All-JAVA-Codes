package com.maven.bank.services;

public class BankService {
    private static long currentBVN = 2;
    private static long currentAccountNumber = 3;
    private static long currentTransactionId = 0;
    public static long generateBVN(){
        currentBVN++;
        return currentBVN;
    }

    public static long getGenerateAccountNumber(){
        ++currentAccountNumber;
        return currentAccountNumber;
    }
    public static long getGenerateTransactionId(){
        ++currentTransactionId;
        return currentTransactionId;
    }

    public static long getCurrentBVN() {
        return currentBVN;
    }

    private static void setCurrentBVN(long currentBVN) {
        BankService.currentBVN = currentBVN;
    }

    public static long getCurrentAccountNumber() {
        return currentAccountNumber;
    }

    public static void setCurrentAccountNumber(long currentAccountNumber) {
        BankService.currentAccountNumber = currentAccountNumber;
    }

    public static long getCurrentTransactionId() {
        return currentTransactionId;
    }

    private static void setCurrentTransactionId(long currentTransactionId) {
        BankService.currentTransactionId = currentTransactionId;
    }

    public static void tearDown() {
        currentAccountNumber = 3;
        currentBVN = 2;
    }
}
