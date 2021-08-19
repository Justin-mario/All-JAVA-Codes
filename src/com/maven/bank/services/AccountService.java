package com.maven.bank.services;

import com.maven.bank.datastore.LoanRequestStatus;
import com.maven.bank.entities.Account;
import com.maven.bank.entities.BankTransaction;
import com.maven.bank.entities.Customer;
import com.maven.bank.datastore.AccountType;
import com.maven.bank.exceptions.MavenBankException;
import com.maven.bank.exceptions.MavenBankInsufficientFundException;
import com.maven.bank.exceptions.MavenBankTransactionException;

import java.math.BigDecimal;

public interface AccountService  {
    long openAccount(Customer customer, AccountType type) throws MavenBankException;
    public long openSavingsAccount(Customer theCustomer) throws MavenBankException;
    public long openCurrentAccount(Customer theCustomer) throws MavenBankException;
    BigDecimal deposit(BigDecimal amount, long accountNumber) throws MavenBankException;
    Account findAccount(long accountNumber) throws MavenBankException;
    Account findAccount(Customer customer, long accountNumber ) throws MavenBankException;
    BigDecimal withdraw(BigDecimal amount, long accountNumber) throws MavenBankInsufficientFundException,MavenBankTransactionException, MavenBankException;
    void applyOverdraft(Account amount);
    LoanRequestStatus applyForLoan(Account theAccount);
    public void addBankTransaction(BankTransaction transaction, Account account) throws MavenBankException;
}
