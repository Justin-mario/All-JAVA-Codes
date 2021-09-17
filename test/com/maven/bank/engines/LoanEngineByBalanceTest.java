package com.maven.bank.engines;

import com.maven.bank.datastore.CustomerRepo;
import enums.LoanRequestStatus;
import enums.LoanType;
import com.maven.bank.entities.Account;
import com.maven.bank.entities.Customer;
import com.maven.bank.entities.LoanRequest;
import com.maven.bank.entities.SavingsAccount;
import com.maven.bank.exceptions.MavenBankException;
import com.maven.bank.exceptions.MavenBankLoanException;
import com.maven.bank.services.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class LoanEngineByBalanceTest {

    private AccountService accountService;
    private LoanEngine loanEngine;
    private LoanRequest johnLoanRequest;
    private Customer john;
    @BeforeEach
    void setUp() {
        loanEngine = new LoanEngineByBalance ();
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
    void calculateAmountAutoApproved() {
        try {
            Account johnCurrentAccount = accountService.findAccount ( 2 );
            johnLoanRequest.setLoanAmount ( BigDecimal.valueOf ( 9_000_000 ) );
            johnCurrentAccount.setAccountLoanRequest ( johnLoanRequest );
            BigDecimal approvedLoan = loanEngine.calculateAmountAutoApproved ( john, johnCurrentAccount );
            assertEquals ( 10_090_000, approvedLoan.intValue () );
        } catch (MavenBankException ex) {
            ex.printStackTrace ();
        }
    }
        @Test
        void calculateAmountAutoApprovedForCustomerWithNegativeBalance(){
            try{
                Account johnCurrentAccount = accountService.findAccount ( 2 );
                johnCurrentAccount.setBalance ( BigDecimal.valueOf (  -900_000 ) );
                johnLoanRequest.setLoanAmount ( BigDecimal.valueOf ( 9_000_000 ) );
                johnCurrentAccount.setAccountLoanRequest ( johnLoanRequest );
                BigDecimal approvedLoan = loanEngine.calculateAmountAutoApproved ( john,johnCurrentAccount  );
                assertEquals (  0 , approvedLoan.intValue () );
            }catch (MavenBankException ex){
                ex.printStackTrace ();
            }
    }



}