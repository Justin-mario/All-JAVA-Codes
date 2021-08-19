package com.maven.bank.exceptions;

public class MavenBankTransactionException extends MavenBankException{
    public MavenBankTransactionException(String message) {
        super(message);
    }
    public MavenBankTransactionException(Throwable ex){
        super(ex);
    }
}
