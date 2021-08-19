package com.maven.bank.services;

import com.maven.bank.datastore.CustomerRepo;
import com.maven.bank.datastore.LoanRequestStatus;
import com.maven.bank.datastore.LoanType;
import com.maven.bank.entities.Account;
import com.maven.bank.entities.CurrentAccount;
import com.maven.bank.entities.Customer;
import com.maven.bank.entities.LoanRequest;
import com.maven.bank.exceptions.MavenBankException;
import com.maven.bank.exceptions.MavenBankLoanException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class LoanServiceImplTest {
    private AccountService accountService;
    private LoanService loanService;
    private LoanRequest johnLoanRequest;
    @BeforeEach
    void setUp() {
        loanService = new LoanServiceImpl ();
        accountService = new AccountServiceImpl ();
        johnLoanRequest = new LoanRequest ();


        johnLoanRequest.setApplyDate ( LocalDateTime.now () );
        johnLoanRequest.setInterestRate ( 0.1 );
        johnLoanRequest.setStatus ( LoanRequestStatus.NEW );
        johnLoanRequest.setTenor ( 24 );
        johnLoanRequest.setTypeOfLoan ( LoanType.SME );

    }

    @AfterEach
    void tearDown() {
    }
    @Test
    void approvedLoanRequestWithNullAccount(){
        assertThrows ( MavenBankLoanException.class, () -> loanService.approveLoanRequest ( null ) );
    }

    @Test
    void approvedLoanRequestWithNullLoan(){
        CurrentAccount newCurrentAccount = new CurrentAccount ();
        assertThrows ( MavenBankLoanException.class, () -> loanService.approveLoanRequest ( newCurrentAccount ) );
    }
    @Test
    void approveLoanRequestWithAccountBalance(){
        try {
            Account johnCurrentAccount = accountService.findAccount ( 2 );
            assertNull ( johnCurrentAccount.getAccountLoanRequest () );
            johnLoanRequest.setLoanAmount ( BigDecimal.valueOf ( 9_000_000 ) );
            johnCurrentAccount.setAccountLoanRequest ( johnLoanRequest );
            LoanRequest processedLoanRequest = loanService.approveLoanRequest ( johnCurrentAccount );
            assertNotNull ( processedLoanRequest );
            assertEquals ( LoanRequestStatus.APPROVED, processedLoanRequest.getStatus () );

        }catch (MavenBankException ex) {
            ex.printStackTrace ();
        }
    }

    @Test
    void approveLoanRequestWithLengthRelationship(){
        try {
            Account johnSavingsAccount = accountService.findAccount ( 1 );
            Optional<Customer> optionalCustomer = CustomerRepo.getCustomers ().values ().stream ().findFirst ();
            Customer john = optionalCustomer.isPresent ()? optionalCustomer.get () : null;
            assertNotNull ( john );
            john.setRelationshipStartDate ( johnSavingsAccount.getStartDate () .minusYears ( 2 ) );
            johnLoanRequest.setLoanAmount ( BigDecimal.valueOf ( 3_000_000 ) );
            johnSavingsAccount.setAccountLoanRequest ( johnLoanRequest );

            johnSavingsAccount.setAccountLoanRequest ( johnLoanRequest );
            LoanRequest processedLoanRequest = loanService.approveLoanRequest ( johnSavingsAccount );
            assertNotNull ( processedLoanRequest );
            assertEquals ( LoanRequestStatus.PENDING, processedLoanRequest.getStatus () );

        }catch (MavenBankException ex) {
            ex.printStackTrace ();
        }
    }

    @Test
    void approveLoanRequestWithAccountBalanceAndHighLoanRequestAmount(){
        try {
            Account johnCurrentAccount = accountService.findAccount ( 2 );
            assertNull ( johnCurrentAccount.getAccountLoanRequest () );
            johnLoanRequest.setLoanAmount ( BigDecimal.valueOf ( 90_000_000 ) );
            johnCurrentAccount.setAccountLoanRequest ( johnLoanRequest );
            LoanRequest processedLoanRequest = loanService.approveLoanRequest ( johnCurrentAccount );
            assertNotNull ( processedLoanRequest );
            assertEquals ( LoanRequestStatus.PENDING, processedLoanRequest.getStatus () );

        }catch (MavenBankException ex) {
            ex.printStackTrace ();
        }
    }
    @Test
    void approveLoanRequestWithLengthRelationshipAndTransaction(){
        try {
            Account johnSavingsAccount = accountService.findAccount ( 1 );
            Optional<Customer> optionalCustomer = CustomerRepo.getCustomers ().values ().stream ().findFirst ();
            Customer john = optionalCustomer.orElse ( null );
            assertNotNull ( john );
            john.setRelationshipStartDate ( johnSavingsAccount.getStartDate () .minusYears ( 2 ) );
            assertEquals ( BigDecimal.valueOf ( 450_000 ), johnSavingsAccount.getBalance () );
            johnLoanRequest.setLoanAmount ( BigDecimal.valueOf ( 3_000_000 ) );
            johnSavingsAccount.setAccountLoanRequest ( johnLoanRequest );
            LoanRequest johnLoanRequest = loanService.approveLoanRequest (john, johnSavingsAccount );
            assertEquals ( LoanRequestStatus.APPROVED, johnLoanRequest.getStatus () );
//            johnSavingsAccount.setAccountLoanRequest ( johnLoanRequest );
//            LoanRequest processedLoanRequest = loanService.approveLoanRequest ( johnSavingsAccount );
//            assertNotNull ( processedLoanRequest );
//            assertEquals ( LoanRequestStatus.PENDING, processedLoanRequest.getStatus () );

        }catch (MavenBankException ex) {
            ex.printStackTrace ();
        }
    }
}