package com.maven.bank.exceptions;

public class MavenBankInsufficientFundException extends MavenBankTransactionException{
    public MavenBankInsufficientFundException(String message) {
        super ( message );
    }

    public MavenBankInsufficientFundException(Throwable ex) {
        super ( ex );
    }
}
