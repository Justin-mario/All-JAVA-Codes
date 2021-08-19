package com.maven.bank.exceptions;

public class MavenBankException extends Exception{
    public MavenBankException(){
        super();
    }
    public MavenBankException(String message){
        super(message);
    }

    public MavenBankException(Throwable ex){
        super(ex);
    }

    public MavenBankException(String message, Throwable ex){
        super(message,ex);
    }
}
