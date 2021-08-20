package com.maven.bank.engines;

import com.maven.bank.entities.Account;
import com.maven.bank.entities.Customer;
import com.maven.bank.exceptions.MavenBankLoanException;

import java.math.BigDecimal;

public interface LoanEngine {
    BigDecimal calculateAmountAutoApproved(Customer customer, Account accountSeekingLoan) throws MavenBankLoanException;

    default void validateLoanRequest(Customer customer, Account accountSeekingLoan) throws MavenBankLoanException {
        if (customer == null) {
            throw new MavenBankLoanException ( "No Customer Provided" );
        }
        validateLoanRequest ( accountSeekingLoan );
    }
    default void validateLoanRequest(Account accountSeekingLoan) throws MavenBankLoanException {
        if (accountSeekingLoan == null) {
            throw new MavenBankLoanException ( "Account is required" );
        }
        if (accountSeekingLoan.getAccountLoanRequest () == null) {
            throw new MavenBankLoanException ( "no loan Request provided For Processing" );
        }

    }
}
