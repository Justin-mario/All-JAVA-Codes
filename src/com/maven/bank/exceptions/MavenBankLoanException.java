package com.maven.bank.exceptions;

public class MavenBankLoanException extends MavenBankException{
    public MavenBankLoanException() {
    }

    public MavenBankLoanException(String message) {
        super ( message );
    }

    public MavenBankLoanException(Throwable ex) {
        super ( ex );
    }

    public MavenBankLoanException(String message, Throwable ex) {
        super ( message, ex );
    }
}
