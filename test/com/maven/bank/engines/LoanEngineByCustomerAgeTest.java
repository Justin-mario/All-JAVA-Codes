package com.maven.bank.engines;

import com.maven.bank.datastore.CustomerRepo;
import com.maven.bank.datastore.LoanRequestStatus;
import com.maven.bank.datastore.LoanType;
import com.maven.bank.entities.Account;
import com.maven.bank.entities.Customer;
import com.maven.bank.entities.LoanRequest;
import com.maven.bank.entities.SavingsAccount;
import com.maven.bank.exceptions.MavenBankException;
import com.maven.bank.exceptions.MavenBankLoanException;
import com.maven.bank.services.AccountService;
import com.maven.bank.services.AccountServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class LoanEngineByCustomerAgeTest {


    private AccountService accountService;
    private LoanEngine loanEngine;
    private LoanRequest johnLoanRequest;
    private Customer john;
    @BeforeEach
    void setUp() {
        loanEngine = new LoanEngineByCustomerAge ();
        accountService = new AccountServiceImpl ();
        johnLoanRequest = new LoanRequest ();

        johnLoanRequest.setApplyDate ( LocalDateTime.now () );
        johnLoanRequest.setInterestRate ( 0.1 );
        johnLoanRequest.setStatus ( LoanRequestStatus.NEW );
        johnLoanRequest.setTenor ( 24 );
        johnLoanRequest.setTypeOfLoan ( LoanType.SME );
        Optional<Customer> optionalCustomer = CustomerRepo.getCustomers ().values ().stream ().findFirst ();
        john = optionalCustomer.orElse ( null );
        assertNotNull ( john );

    }

    @AfterEach
    void tearDown() {
        LocalDate dob = LocalDate.of(1991, Month.MAY, 12);
        john.setDateOfBirth ( dob );
    }

    @Test
    void approvedLoanRequestWithOutCustomer(){
        assertThrows ( MavenBankLoanException.class, () -> loanEngine.calculateAmountAutoApproved ( null, new SavingsAccount () ) );
    }

    @Test
    void approvedLoanRequestWithNoAccount(){
        assertThrows ( MavenBankLoanException.class, () -> loanEngine.calculateAmountAutoApproved (  john,null ) );
    }

    @Test
    void calculateAmountAutoApprovedForBelowEighteen(){
        try {
            Account johnCurrentAccount = accountService.findAccount ( 2 );
            johnCurrentAccount.setAccountLoanRequest ( johnLoanRequest );
            LocalDate dob = john.getDateOfBirth ().plusYears ( 15 );
            john.setDateOfBirth ( dob );
            BigDecimal approvedLoan = loanEngine.calculateAmountAutoApproved ( john, johnCurrentAccount );
            assertEquals ( BigDecimal.ZERO.intValue (), approvedLoan.intValue () );
        } catch (MavenBankException ex) {
            ex.printStackTrace ();
        }
    }

    @Test
    void calculateAmountAutoApprovedForTwentyOneYearsOld(){
        try {
            Account johnCurrentAccount = accountService.findAccount ( 2 );
            johnCurrentAccount.setAccountLoanRequest ( johnLoanRequest );
            LocalDate dob = john.getDateOfBirth ().plusYears ( 9 );
            john.setDateOfBirth ( dob );
            BigDecimal approvedLoan = loanEngine.calculateAmountAutoApproved ( john, johnCurrentAccount );
            assertEquals ( 1_009_000, approvedLoan.intValue () );
        } catch (MavenBankException ex) {
            ex.printStackTrace ();
        }
    }

    @Test
    void calculateAmountAutoApprovedForThirtyYearsOld(){
        try {
            Account johnCurrentAccount = accountService.findAccount ( 2 );
            johnCurrentAccount.setAccountLoanRequest ( johnLoanRequest );
            BigDecimal approvedLoan = loanEngine.calculateAmountAutoApproved ( john, johnCurrentAccount );
            assertEquals ( 2_018_000, approvedLoan.intValue () );
        } catch (MavenBankException ex) {
            ex.printStackTrace ();
        }
    }

    @Test
    void calculateAmountAutoApprovedForFortyYearsOld(){
        try {
            Account johnCurrentAccount = accountService.findAccount ( 2 );
            johnCurrentAccount.setAccountLoanRequest ( johnLoanRequest );
            LocalDate dob = john.getDateOfBirth ().minusYears (  10);
            john.setDateOfBirth ( dob );
            BigDecimal approvedLoan = loanEngine.calculateAmountAutoApproved ( john, johnCurrentAccount );
            assertEquals ( 3027000, approvedLoan.intValue () );
        } catch (MavenBankException ex) {
            ex.printStackTrace ();
        }
    }

    @Test
    void calculateAmountAutoApprovedForFortySixYearsOld(){
        try {
            Account johnCurrentAccount = accountService.findAccount ( 2 );
            johnCurrentAccount.setAccountLoanRequest ( johnLoanRequest );
            LocalDate dob = john.getDateOfBirth ().minusYears (  16);
            john.setDateOfBirth ( dob );
            BigDecimal approvedLoan = loanEngine.calculateAmountAutoApproved ( john, johnCurrentAccount );
            assertEquals ( 3027000, approvedLoan.intValue () );
        } catch (MavenBankException ex) {
            ex.printStackTrace ();
        }
    }

    @Test
    void calculateAmountAutoApprovedForSixtyYearsOld(){
        try {
            Account johnCurrentAccount = accountService.findAccount ( 2 );
            johnCurrentAccount.setAccountLoanRequest ( johnLoanRequest );
            LocalDate dob = john.getDateOfBirth ().minusYears (  30);
            john.setDateOfBirth ( dob );
            BigDecimal approvedLoan = loanEngine.calculateAmountAutoApproved ( john, johnCurrentAccount );
            assertEquals ( 3027000, approvedLoan.intValue () );
        } catch (MavenBankException ex) {
            ex.printStackTrace ();
        }
    }

    @Test
    void calculateAmountAutoApprovedForSeventyOneYearsOld(){
        try {
            Account johnCurrentAccount = accountService.findAccount ( 2 );
            johnCurrentAccount.setAccountLoanRequest ( johnLoanRequest );
            LocalDate dob = john.getDateOfBirth ().minusYears (  41);
            john.setDateOfBirth ( dob );
            BigDecimal approvedLoan = loanEngine.calculateAmountAutoApproved ( john, johnCurrentAccount );
            assertEquals ( 3027000, approvedLoan.intValue () );
        } catch (MavenBankException ex) {
            ex.printStackTrace ();
        }
    }

    @Test
    void calculateAmountAutoApprovedForSeventySixYearsOld(){
        try {
            Account johnCurrentAccount = accountService.findAccount ( 2 );
            johnCurrentAccount.setAccountLoanRequest ( johnLoanRequest );
            LocalDate dob = john.getDateOfBirth ().minusYears (  46);
            john.setDateOfBirth ( dob );
            BigDecimal approvedLoan = loanEngine.calculateAmountAutoApproved ( john, johnCurrentAccount );
            assertEquals ( BigDecimal.ZERO.intValue (), approvedLoan.intValue () );
        } catch (MavenBankException ex) {
            ex.printStackTrace ();
        }
    }
}