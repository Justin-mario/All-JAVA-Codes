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
import com.maven.bank.services.BankService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class LoanEngineByRelationshipLengthTest {
    private AccountService accountService;
    private LoanEngine loanEngine;
    private LoanRequest johnLoanRequest;
    private Customer john;
    @BeforeEach
    void setUp() {
        loanEngine = new LoanEngineByRelationshipLength ();
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
        BankService.tearDown ();
        CustomerRepo.reset ();
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
    void calculateAmountAutoApprovedThreeMonthsFor() {
        try {
            Account johnCurrentAccount = accountService.findAccount ( 2 );
            johnCurrentAccount.setStartDate ( johnCurrentAccount.getStartDate ().minusMonths ( 3 ) );
            johnCurrentAccount.setAccountLoanRequest ( johnLoanRequest );
            BigDecimal approvedLoan = loanEngine.calculateAmountAutoApproved ( john, johnCurrentAccount );
            assertEquals ( 1_009_000, approvedLoan.intValue () );
        } catch (MavenBankException ex) {
            ex.printStackTrace ();
        }
    }

    @Test
    void calculateAmountAutoApprovedBetweenTwoAndThreeMonths() {
        try {
            Account johnCurrentAccount = accountService.findAccount ( 2 );
            johnCurrentAccount.setAccountLoanRequest ( johnLoanRequest );
            john.setRelationshipStartDate ( LocalDateTime.now ().minusDays ( 75 ) );
//            johnCurrentAccount.setStartDate (johnCurrentAccount.getStartDate ().minusDays ( 75 ) );
            BigDecimal approvedLoan = loanEngine.calculateAmountAutoApproved ( john, johnCurrentAccount );
            assertEquals ( BigDecimal.ZERO.intValue (), approvedLoan.intValue () );
        } catch (MavenBankException ex) {
            ex.printStackTrace ();
        }
    }


    @Test
    void calculateAmountAutoApprovedFourMonthsFor() {
        try {
            Account johnCurrentAccount = accountService.findAccount ( 2 );
            johnCurrentAccount.setStartDate ( johnCurrentAccount.getStartDate ().minusMonths ( 4 ) );
            johnCurrentAccount.setAccountLoanRequest ( johnLoanRequest );
            BigDecimal approvedLoan = loanEngine.calculateAmountAutoApproved ( john, johnCurrentAccount );
            assertEquals ( 1_009_000, approvedLoan.intValue () );
        } catch (MavenBankException ex) {
            ex.printStackTrace ();
        }
    }

    @Test
    void calculateAmountAutoApprovedForSixMonths() {
        try {
            Account johnCurrentAccount = accountService.findAccount ( 2 );
            johnCurrentAccount.setStartDate ( johnCurrentAccount.getStartDate ().minusMonths ( 6 ) );
            johnCurrentAccount.setAccountLoanRequest ( johnLoanRequest );
            BigDecimal approvedLoan = loanEngine.calculateAmountAutoApproved ( john, johnCurrentAccount );
            assertEquals ( 2_018_000, approvedLoan.intValue () );
        } catch (MavenBankException ex) {
            ex.printStackTrace ();
        }
    }

    @Test
    void calculateAmountAutoApprovedForTwelveMonths() {
        try {
            Account johnCurrentAccount = accountService.findAccount ( 2 );
            johnCurrentAccount.setStartDate ( johnCurrentAccount.getStartDate ().minusMonths ( 12 ) );
            johnCurrentAccount.setAccountLoanRequest ( johnLoanRequest );
            BigDecimal approvedLoan = loanEngine.calculateAmountAutoApproved ( john, johnCurrentAccount );
            assertEquals ( 30_27_000, approvedLoan.intValue () );
        } catch (MavenBankException ex) {
            ex.printStackTrace ();
        }
    }

    @Test
    void calculateAmountAutoApprovedForEighteenMonths() {
        try {
            Account johnCurrentAccount = accountService.findAccount ( 2 );
            johnCurrentAccount.setStartDate ( johnCurrentAccount.getStartDate ().minusMonths ( 18 ) );
            johnCurrentAccount.setAccountLoanRequest ( johnLoanRequest );
            BigDecimal approvedLoan = loanEngine.calculateAmountAutoApproved ( john, johnCurrentAccount );
            assertEquals ( 40_36_000, approvedLoan.intValue () );
        } catch (MavenBankException ex) {
            ex.printStackTrace ();
        }
    }

    @Test
    void calculateAmountAutoApprovedForTwoYearsMonths() {
        try {
            Account johnCurrentAccount = accountService.findAccount ( 2 );
            johnCurrentAccount.setStartDate ( johnCurrentAccount.getStartDate ().minusYears ( 2 ));
            johnCurrentAccount.setAccountLoanRequest ( johnLoanRequest );
            BigDecimal approvedLoan = loanEngine.calculateAmountAutoApproved ( john, johnCurrentAccount );
            assertEquals ( 50_45_000, approvedLoan.intValue () );
        } catch (MavenBankException ex) {
            ex.printStackTrace ();
        }
    }

    @Test
    void calculateAmountAutoApprovedForFutureRelationshipStartDateMonths() {
        try {
            Account johnCurrentAccount = accountService.findAccount ( 2 );
            johnCurrentAccount.setStartDate ( johnCurrentAccount.getStartDate ().plusMonths ( 3 ) );
            johnCurrentAccount.setAccountLoanRequest ( johnLoanRequest );
            assertThrows ( MavenBankLoanException.class, ()-> loanEngine.calculateAmountAutoApproved ( john, johnCurrentAccount ));
//            BigDecimal approvedLoan = loanEngine.calculateAmountAutoApproved ( john, johnCurrentAccount );
//            assertEquals ( 30_27_000, approvedLoan.intValue () );
        } catch (MavenBankException ex) {
            ex.printStackTrace ();
        }
    }
}