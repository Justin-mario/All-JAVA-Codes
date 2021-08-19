package com.maven.bank.services;

import com.maven.bank.entities.Account;
import com.maven.bank.entities.Customer;
import com.maven.bank.entities.LoanRequest;
import com.maven.bank.exceptions.MavenBankLoanException;

public interface LoanService {
     LoanRequest approveLoanRequest(Account accountSeekingLoan) throws MavenBankLoanException;
     LoanRequest approveLoanRequest(Customer customer, Account accountSeekingLoan ) throws MavenBankLoanException;


}
