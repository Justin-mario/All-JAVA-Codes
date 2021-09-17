package com.maven.bank.engines;

import com.maven.bank.datastore.CustomerRepo;
import com.maven.bank.entities.*;
import com.maven.bank.exceptions.MavenBankException;
import com.maven.bank.exceptions.MavenBankLoanException;
import com.maven.bank.services.AccountService;
import com.maven.bank.services.AccountServiceImpl;
import com.maven.bank.services.BankService;
import enums.EmploymentLevel;
import enums.LoanRequestStatus;
import enums.LoanType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class LoanEngineByCareerHistoryTest {

    private AccountService accountService;
    private LoanEngine loanEngine;
    private LoanRequest johnLoanRequest;
    private Customer john;
    @BeforeEach
    void setUp() {
        loanEngine = new LoanEngineByCareerHistory ();
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
    void approveLoanRequestForVeryEarlyCareer(){
        try {
            Account johnCurrentAccount = accountService.findAccount ( 2 );
            johnCurrentAccount.setAccountLoanRequest ( johnLoanRequest );

            SortedSet<Employment> jobs = new TreeSet<> ();
            Company odogwuAssociates = new Company ( "0d768754", "odogwu Enterprise" );
            LocalDate start = LocalDate.now ();
            start = start.minusMonths ( 6 );
            Employment salesBoy = new Employment ( odogwuAssociates, start, BigDecimal.valueOf ( 360000 ) );
            salesBoy.setLevel ( EmploymentLevel.ENTRY );
            jobs.add ( salesBoy );
            john.setEmploymentHistory ( jobs );

            BigDecimal approvedLoan = loanEngine.calculateAmountAutoApproved ( john, johnCurrentAccount );
            assertEquals ( 0, approvedLoan.intValue () );
        } catch (MavenBankException ex) {
            ex.printStackTrace ();
        }
    }

    @Test
    void approveLoanRequestForEarlyCareer(){
        try {
            Account johnCurrentAccount = accountService.findAccount ( 2 );
            johnCurrentAccount.setAccountLoanRequest ( johnLoanRequest );

            SortedSet<Employment> jobs = new TreeSet<> ();
            Company odogwuAssociates = new Company ( "0d768754", "odogwu Enterprise" );
            LocalDate start = LocalDate.now ();
            start = start.minusYears ( 2 );
            Employment salesBoy = new Employment ( odogwuAssociates, start, BigDecimal.valueOf ( 360000 ) );
            salesBoy.setLevel ( EmploymentLevel.ENTRY );
            jobs.add ( salesBoy );
            john.setEmploymentHistory ( jobs );

            BigDecimal approvedLoan = loanEngine.calculateAmountAutoApproved ( john, johnCurrentAccount );
            assertEquals ( 1800, approvedLoan.intValue () );
        } catch (MavenBankException ex) {
            ex.printStackTrace ();
        }
    }

    @Test
    void approveLoanRequestForMidCareer(){
        try {
            Account johnCurrentAccount = accountService.findAccount ( 2 );
            johnCurrentAccount.setAccountLoanRequest ( johnLoanRequest );

            SortedSet<Employment> jobs = new TreeSet<> ();
            Company odogwuAssociates = new Company ( "0d768754", "odogwu Enterprise" );
            LocalDate start = LocalDate.now ();
            start = start.minusYears ( 2 );
            Employment salesBoy = new Employment ( odogwuAssociates, LocalDate.of ( 2016, Month.JUNE, 01 ),LocalDate.of ( 2028, Month.MAY, 31 ), BigDecimal.valueOf ( 360000 ) );
            salesBoy.setLevel ( EmploymentLevel.ENTRY );
            jobs.add ( salesBoy );
            john.setEmploymentHistory ( jobs );

            Company utiva = new Company ( "ut688768", "Utiva" );
            Employment customerSuccess = new Employment ( utiva, LocalDate.of ( 2018, Month.JUNE, 01 ),LocalDate.of ( 2020, Month.MAY, 31 ), BigDecimal.valueOf ( 1200000 ) );
            customerSuccess.setLevel ( EmploymentLevel.SUPERVISOR );
            jobs.add ( customerSuccess );

            BigDecimal approvedLoan = loanEngine.calculateAmountAutoApproved ( john, johnCurrentAccount );
            assertEquals ( 12000, approvedLoan.intValue () );
        } catch (MavenBankException ex) {
            ex.printStackTrace ();
        }
    }

    @Test
    void approveLoanRequestForMidSeniorCareer(){
        try {
            Account johnCurrentAccount = accountService.findAccount ( 2 );
            johnCurrentAccount.setAccountLoanRequest ( johnLoanRequest );
            BigDecimal approvedLoan = loanEngine.calculateAmountAutoApproved ( john, johnCurrentAccount );
            assertEquals ( 180000, approvedLoan.intValue () );
        } catch (MavenBankException ex) {
            ex.printStackTrace ();
        }
    }

    @Test
    void approveLoanRequestForSeniorCareer() {
        try {
            Account johnCurrentAccount = accountService.findAccount ( 2 );
            johnCurrentAccount.setAccountLoanRequest ( johnLoanRequest );
            Employment firstJob = john.getEmploymentHistory ().first ();
            LocalDate newStart = firstJob.getStartDate ().withYear ( 2000 );
            firstJob.setStartDate ( newStart );
            john.getEmploymentHistory ().add ( firstJob );
            BigDecimal approvedLoan = loanEngine.calculateAmountAutoApproved ( john, johnCurrentAccount );
            assertEquals ( 240000, approvedLoan.intValue () );
        } catch (MavenBankException ex) {
            ex.printStackTrace ();
        }
    }
}