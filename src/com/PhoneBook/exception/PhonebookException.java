package com.PhoneBook.exception;

public class PhonebookException extends Exception{
    public PhonebookException() {
    }

    public PhonebookException(String message) {
        super ( message );
    }

    public PhonebookException(String message, Throwable cause) {
        super ( message, cause );
    }

    public PhonebookException(Throwable cause) {
        super ( cause );
    }

    public PhonebookException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super ( message, cause, enableSuppression, writableStackTrace );
    }
}
