package com.maven.bank.services;

import com.maven.bank.datastore.*;
import com.maven.bank.entities.*;
import com.maven.bank.exceptions.MavenBankException;
import com.maven.bank.exceptions.MavenBankInsufficientFundException;
import com.maven.bank.exceptions.MavenBankTransactionException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceImplTest {
    private AccountService accountService;
    private Customer abu;
    private Customer bessie;
    private Account abuAccount;


    @BeforeEach
    void setUp() {
        accountService = new AccountServiceImpl ();
        abu = new Customer ();
        abuAccount = new SavingsAccount ();

        try {
            abuAccount.setAccountPin ( "9090" );
        }catch (MavenBankTransactionException ex){
            ex.printStackTrace ();
        }
        bessie = new Customer ();



    }

    @AfterEach
    void tearDown() {
        BankService.tearDown ();
        CustomerRepo.tearDown ( abu.getBvn () );
        CustomerRepo.tearDown ( bessie.getBvn () );
        CustomerRepo.reset ();


    }

    @Test
    void openAccount() {
        assertFalse ( CustomerRepo.getCustomers ().isEmpty () );
        assertEquals ( 3, BankService.getCurrentAccountNumber () );
        assertEquals ( 2, BankService.getCurrentBVN () );
        try {
            long newAccountNumber = accountService.openAccount ( abu, AccountType.SAVINGSACCOUNT );
            assertFalse ( CustomerRepo.getCustomers ().isEmpty () );
            assertEquals ( 4, BankService.getCurrentAccountNumber () );
            assertTrue ( CustomerRepo.getCustomers ().containsKey ( abu.getBvn () ) );
            assertFalse ( abu.getAccounts ().isEmpty () );
            assertEquals ( newAccountNumber, abu.getAccounts ().get ( 0 ).getAccountNumber () );
        } catch (MavenBankException ex) {
            ex.printStackTrace ();
        }
    }

    @Test
    void openAccountWithNoCustomer() {
        assertThrows ( MavenBankException.class, () -> accountService.openAccount ( null, AccountType.SAVINGSACCOUNT ) );

    }

    @Test
    void openSameTypeOfAccountForSameCustomer() {
        Optional<Customer> johnOptional = CustomerRepo.getCustomers ().values ().stream ().findFirst ();
        Customer john = (johnOptional.isEmpty ()) ? null : johnOptional.get ();
        assertEquals ( 3, BankService.getCurrentAccountNumber () );
        assertNotNull ( john );
        assertNotNull ( john.getAccounts () );
        assertFalse ( john.getAccounts ().isEmpty () );
        assertEquals ( AccountType.SAVINGSACCOUNT.toString (),
                john.getAccounts ().get ( 0 ).getClass ().getSimpleName ().toUpperCase () );
        assertThrows ( MavenBankException.class, () -> accountService.openAccount ( john, AccountType.SAVINGSACCOUNT ) );
        assertEquals ( 3, BankService.getCurrentAccountNumber () );
        assertEquals ( 2, john.getAccounts ().size () );
    }

    @Test
    void openSameTypeOfAccountForSavings() {
        try {
            Customer john;
            long newAccountNumber = accountService.openAccount ( abu, AccountType.SAVINGSACCOUNT);
            assertFalse ( CustomerRepo.getCustomers ().isEmpty () );
            assertEquals ( 4, BankService.getCurrentAccountNumber () );
            assertTrue ( CustomerRepo.getCustomers ().containsKey ( abu.getBvn () ) );
            assertFalse ( abu.getAccounts ().isEmpty () );
            assertEquals ( newAccountNumber, abu.getAccounts ().get ( 0 ).getAccountNumber () );
        } catch (MavenBankException ex) {
            ex.printStackTrace ();
        }
        assertThrows ( MavenBankException.class, () -> accountService.openAccount ( abu, AccountType.SAVINGSACCOUNT ) );
        assertEquals ( 4, BankService.getCurrentAccountNumber () );
        assertEquals ( 1, abu.getAccounts ().size () );
    }

    @Test
    void openAccountForCurrentAccount() {
        try {
            long newAccountNumber = accountService.openAccount ( abu, AccountType.CURRENTACCOUNT );
            assertFalse ( CustomerRepo.getCustomers ().isEmpty () );
            assertEquals ( 4, BankService.getCurrentAccountNumber () );
            assertTrue ( CustomerRepo.getCustomers ().containsKey ( abu.getBvn () ) );
            assertFalse ( abu.getAccounts ().isEmpty () );
            assertEquals ( newAccountNumber, abu.getAccounts ().get ( 0 ).getAccountNumber () );
            newAccountNumber = accountService.openAccount ( abu, AccountType.SAVINGSACCOUNT );
            assertEquals ( 5, BankService.getCurrentAccountNumber () );
        } catch (MavenBankException ex) {
            ex.printStackTrace ();
        }


    }

    @Test
    void OpenDifferentTypeOfAccountForSameCustomer() {
        try {
            long newAccountNumber = accountService.openAccount ( abu, AccountType.SAVINGSACCOUNT );
            assertFalse ( CustomerRepo.getCustomers ().isEmpty () );
            assertEquals ( 4, BankService.getCurrentAccountNumber () );
            assertTrue ( CustomerRepo.getCustomers ().containsKey ( abu.getBvn () ) );
            assertEquals ( 1, abu.getAccounts ().size () );
            assertFalse ( abu.getAccounts ().isEmpty () );
            assertEquals ( newAccountNumber, abu.getAccounts ().get ( 0 ).getAccountNumber () );

            newAccountNumber = accountService.openAccount ( abu, AccountType.CURRENTACCOUNT );
            assertEquals ( 5, BankService.getCurrentAccountNumber () );
            assertEquals ( 2, abu.getAccounts ().size () );
            assertEquals ( newAccountNumber, abu.getAccounts ().get ( 1 ).getAccountNumber () );
        } catch (MavenBankException ex) {
            ex.printStackTrace ();
        }

    }

    @Test
    void openTwoAccountSavings() {
        try {
            long newAccountNumber = accountService.openAccount ( abu, AccountType.SAVINGSACCOUNT );
            assertFalse ( CustomerRepo.getCustomers ().isEmpty () );
            assertEquals ( 4, BankService.getCurrentAccountNumber () );
            assertTrue ( CustomerRepo.getCustomers ().containsKey ( abu.getBvn () ) );
            assertFalse ( abu.getAccounts ().isEmpty () );
            assertEquals ( newAccountNumber, abu.getAccounts ().get ( 0 ).getAccountNumber () );

            newAccountNumber = accountService.openAccount ( bessie, AccountType.SAVINGSACCOUNT );
            assertFalse ( CustomerRepo.getCustomers ().isEmpty () );
            assertEquals ( 5, BankService.getCurrentAccountNumber () );
            assertTrue ( CustomerRepo.getCustomers ().containsKey ( bessie.getBvn () ) );
            assertFalse ( bessie.getAccounts ().isEmpty () );
            assertEquals ( newAccountNumber, bessie.getAccounts ().get ( 0 ).getAccountNumber () );
        } catch (MavenBankException ex) {
            ex.printStackTrace ();
        }
    }

    @Test
    void OpenDifferentTypeOfAccountForDifferentCustomer() {
        try {
            long newAccountNumber = accountService.openAccount ( abu, AccountType.SAVINGSACCOUNT );
            assertFalse ( CustomerRepo.getCustomers ().isEmpty () );
            assertEquals ( 4, BankService.getCurrentAccountNumber () );
            assertTrue ( CustomerRepo.getCustomers ().containsKey ( abu.getBvn () ) );
            assertEquals ( 1, abu.getAccounts ().size () );
            assertFalse ( abu.getAccounts ().isEmpty () );
            assertEquals ( newAccountNumber, abu.getAccounts ().get ( 0 ).getAccountNumber () );

            newAccountNumber = accountService.openAccount ( bessie, AccountType.CURRENTACCOUNT );
            assertEquals ( 5, BankService.getCurrentAccountNumber () );
            assertEquals ( 1, bessie.getAccounts ().size () );
            assertEquals ( newAccountNumber, bessie.getAccounts ().get ( 0 ).getAccountNumber () );
        } catch (MavenBankException ex) {
            ex.printStackTrace ();
        }

    }

    @Test
    void openTwoAccountCurrent() {
        try {
            long newAccountNumber = accountService.openAccount ( abu, AccountType.CURRENTACCOUNT );
            assertFalse ( CustomerRepo.getCustomers ().isEmpty () );
            assertEquals ( 4, BankService.getCurrentAccountNumber () );
            assertTrue ( CustomerRepo.getCustomers ().containsKey ( abu.getBvn () ) );
            assertFalse ( abu.getAccounts ().isEmpty () );
            assertEquals ( newAccountNumber, abu.getAccounts ().get ( 0 ).getAccountNumber () );

            newAccountNumber = accountService.openAccount ( bessie, AccountType.CURRENTACCOUNT );
            assertFalse ( CustomerRepo.getCustomers ().isEmpty () );
            assertEquals ( 5, BankService.getCurrentAccountNumber () );
            assertTrue ( CustomerRepo.getCustomers ().containsKey ( bessie.getBvn () ) );
            assertFalse ( bessie.getAccounts ().isEmpty () );
            assertEquals ( newAccountNumber, bessie.getAccounts ().get ( 0 ).getAccountNumber () );
        } catch (MavenBankException ex) {
            ex.printStackTrace ();
        }
    }

    @Test
    void deposit() {
        try {
            long newAccountNumber = accountService.openAccount ( abu, AccountType.SAVINGSACCOUNT );
            Account johnSavingsAccount = accountService.findAccount ( 1 );
            assertEquals ( BigDecimal.ZERO, johnSavingsAccount.getBalance () );

            assertFalse ( CustomerRepo.getCustomers ().isEmpty () );
            assertEquals ( BigDecimal.ZERO, abu.getAccounts ().get ( 0 ).getBalance () );

            BigDecimal accountBalance = accountService.deposit ( BigDecimal.valueOf ( 5000 ), 1 );
            johnSavingsAccount = accountService.findAccount ( 1 );
            assertEquals ( BigDecimal.valueOf ( 5000 ), johnSavingsAccount.getBalance () );
        } catch (MavenBankException ex) {
            ex.printStackTrace ();
        }

    }

    @Test
    void findAccount() {
        try {

            Account janeSavingsAccount = accountService.findAccount ( 2 );
            assertNotNull ( janeSavingsAccount );
            assertEquals ( 2, janeSavingsAccount.getAccountNumber () );

        } catch (MavenBankException ex) {
            ex.printStackTrace ();
        }

    }
    @Test
    void depositWithIncorrectAccountNumber(){
        try {
            long newAccountNumber = accountService.openAccount ( abu, AccountType.SAVINGSACCOUNT );
            Account johnSavingsAccount = accountService.findAccount ( 1 );
           assertThrows ( MavenBankException.class, ()->accountService.deposit ( BigDecimal.valueOf ( 5000 ), 8 ) );
        } catch (MavenBankException ex) {
            ex.printStackTrace ();
        }

    }

    @Test
    void depositNegativeNumber() {

        assertThrows ( MavenBankTransactionException.class, () -> accountService.deposit ( BigDecimal.valueOf ( -5000 ), 1 ) );

    }

    @Test
    void depositWithVeryLargeDepositAmount() {
        try {
            Account johnCurrentAccount = accountService.findAccount ( 1 );
            assertEquals ( BigDecimal.ZERO, johnCurrentAccount.getBalance () );
            BigDecimal depositAmount = new BigDecimal ( "10000000000000000000" );
            BigDecimal accountBalance = accountService.deposit ( depositAmount, 1 );
            johnCurrentAccount = accountService.findAccount ( 1 );
            assertEquals ( depositAmount, johnCurrentAccount.getBalance () );
        }catch (MavenBankException ex) {
            ex.printStackTrace ();
        }
    }



    @Test
    void withdrawFromSavingAccount(){
        try {
            Account johnCurrentAccount = accountService.findAccount ( 1 );
            assertEquals ( BigDecimal.ZERO, johnCurrentAccount.getBalance () );
            BigDecimal depositAmount = new BigDecimal ( 5000 );
            BigDecimal accountBalance = accountService.deposit ( depositAmount, 1 );
            johnCurrentAccount = accountService.findAccount ( 1 );
            assertEquals ( depositAmount, johnCurrentAccount.getBalance () );

             BigDecimal newBalance = new BigDecimal ( 4000 );
            accountBalance = accountService.withdraw(BigDecimal.valueOf ( 1000 ), 1);
            assertEquals ( newBalance, johnCurrentAccount.getBalance () );
        }catch (MavenBankException ex) {
            ex.printStackTrace ();
        }
    }

    @Test
    void withdrawFromCurrentAccount(){
        try {
            long newAccountNumber = accountService.openAccount ( abu, AccountType.CURRENTACCOUNT );
            assertFalse ( CustomerRepo.getCustomers ().isEmpty () );
            assertEquals ( 4, BankService.getCurrentAccountNumber () );
            assertTrue ( CustomerRepo.getCustomers ().containsKey ( abu.getBvn () ) );
            assertFalse ( abu.getAccounts ().isEmpty () );
            assertEquals ( newAccountNumber, abu.getAccounts ().get ( 0 ).getAccountNumber () );
            Account abu = accountService.findAccount ( 4 );
            assertEquals ( BigDecimal.ZERO, abu.getBalance () );
            BigDecimal depositAmount = new BigDecimal ( 99000.50 );
            BigDecimal accountBalance = accountService.deposit ( depositAmount, 4 );
            abu = accountService.findAccount ( 4 );
            assertEquals ( depositAmount, abu.getBalance () );
            BigDecimal withdrawalAmount = new BigDecimal ( 1000 );
            accountBalance = accountService.withdraw(withdrawalAmount, 4);
            assertEquals ( BigDecimal.valueOf ( 98000.50 ), abu.getBalance () );

        } catch (MavenBankException ex) {
            ex.printStackTrace ();
        }
    }

    @Test
    void canNotWithdrawNegativeAmount(){
        try {
            Account johnCurrentAccount = accountService.findAccount ( 1 );
            assertEquals ( BigDecimal.ZERO, johnCurrentAccount.getBalance () );
            BigDecimal depositAmount = new BigDecimal ( 5000 );
            BigDecimal accountBalance = accountService.deposit ( depositAmount, 1 );
            johnCurrentAccount = accountService.findAccount ( 1 );
            assertEquals ( depositAmount, johnCurrentAccount.getBalance () );
            assertThrows ( MavenBankTransactionException.class, ()-> accountService.withdraw(new BigDecimal(-2000), 1));
            assertEquals ( BigDecimal.valueOf ( 5000 ), johnCurrentAccount.getBalance () );
        }catch (MavenBankException ex) {
            ex.printStackTrace ();
        }

    }
    @Test
    void canNotWithdrawAmountMoreThanBalanceAmount(){
        try {
            Account johnCurrentAccount = accountService.findAccount ( 2 );
            BigDecimal depositAmount = new BigDecimal ( 500 );
            BigDecimal accountBalance = accountService.deposit ( depositAmount, 2 );
            johnCurrentAccount = accountService.findAccount ( 2 );
            assertEquals ( new BigDecimal(50000500), johnCurrentAccount.getBalance () );
            BigDecimal withdrawalAmount = new BigDecimal ( 500005000 );
            assertThrows ( MavenBankInsufficientFundException.class, ()-> accountService.withdraw(withdrawalAmount, 2));
            assertEquals ( BigDecimal.valueOf ( 50000500 ), johnCurrentAccount.getBalance () );
        }catch (MavenBankException ex) {
            ex.printStackTrace ();
        }

    }

    @Test
    void withdrawWithInvalidAccountNumber(){
        try {
            Account johnCurrentAccount = accountService.findAccount ( 1 );
            BigDecimal depositAmount = new BigDecimal ( 5000 );
            BigDecimal accountBalance = accountService.deposit ( depositAmount, 1 );
            johnCurrentAccount = accountService.findAccount ( 1 );
            assertEquals ( depositAmount, johnCurrentAccount.getBalance () );

            BigDecimal newBalance = new BigDecimal ( 4000 );
            assertThrows ( MavenBankTransactionException.class,()-> accountService.withdraw(BigDecimal.valueOf ( 1000 ), 8) );
        }catch (MavenBankException ex) {
            ex.printStackTrace ();
        }
    }
    @Test
    void applyForLoan(){
        LoanRequest johnLoanRequest = new LoanRequest ();
        johnLoanRequest.setLoanAmount ( BigDecimal.valueOf ( 50_000_000 ) );
        johnLoanRequest.setApplyDate ( LocalDateTime.now () );
        johnLoanRequest.setInterestRate ( 0.1 );
        johnLoanRequest.setStatus ( LoanRequestStatus.NEW );
        johnLoanRequest.setTenor ( 24 );
        johnLoanRequest.setTypeOfLoan ( LoanType.SME );

        try {
            Account johnCurrentAccount = accountService.findAccount ( 2 );
            johnCurrentAccount.setAccountLoanRequest ( johnLoanRequest );
           assertNotNull ( johnCurrentAccount.getAccountLoanRequest () );
        }catch (MavenBankException ex) {
            ex.printStackTrace ();
        }
    }
    @Test
    void addBankTransactionWithNullTransaction(){
        assertThrows ( MavenBankTransactionException.class,
                () -> accountService.addBankTransaction ( null,abuAccount ) );
    }

    @Test
    void addBankTransactionWithNullAccount(){
        BankTransaction transaction = new BankTransaction ( BankTransactionType.DEPOSIT,BigDecimal.valueOf ( 400 ) );
        assertThrows ( MavenBankException.class,
                () -> accountService.addBankTransaction (transaction ,null ) );
    }

    @Test
    void addBankTransactionWithDeposit(){
        try{
            Account janeSavingAccount = accountService.findAccount ( 3 );
            assertNotNull ( janeSavingAccount );
            assertEquals ( BigDecimal.ZERO, janeSavingAccount.getBalance () );
            assertEquals ( 0, janeSavingAccount.getTransactions ().size () );
            BankTransaction janeDeposit = new BankTransaction ( BankTransactionType.DEPOSIT,BigDecimal.valueOf ( 10000 ) );
            accountService.addBankTransaction ( janeDeposit,janeSavingAccount );
            assertEquals ( BigDecimal.valueOf ( 10_000 ), janeSavingAccount.getBalance () );
            assertEquals ( 1, janeSavingAccount.getTransactions ().size () );
        }catch (MavenBankException ex){
            ex.printStackTrace ();
        }
    }

    @Test
    void addBankTransactionWithNegativeDeposit() {

        try {
            Account janeSavingAccount = accountService.findAccount ( 3 );
            assertNotNull ( janeSavingAccount );
            assertEquals ( BigDecimal.ZERO, janeSavingAccount.getBalance () );
            assertEquals ( 0, janeSavingAccount.getTransactions ().size () );

            BankTransaction janeDeposit = new BankTransaction ( BankTransactionType.DEPOSIT, BigDecimal.valueOf ( -10000 ) );
            assertThrows ( MavenBankTransactionException.class, ()-> accountService.addBankTransaction ( janeDeposit, janeSavingAccount ));

            assertEquals ( BigDecimal.valueOf ( 0 ), janeSavingAccount.getBalance () );
            assertEquals ( 0, janeSavingAccount.getTransactions ().size () );
        } catch (MavenBankException ex) {
            ex.printStackTrace ();
        }
    }

    @Test
    void addBankTransactionForWithdrawal(){
        try{
            Account janeSavingsAccount = accountService.findAccount ( 3 );
            assertNotNull ( janeSavingsAccount );
            BankTransaction depositTransaction = new BankTransaction ( BankTransactionType.DEPOSIT, BigDecimal.valueOf ( 50_000 ) );
            accountService.addBankTransaction ( depositTransaction, janeSavingsAccount );
            assertEquals ( BigDecimal.valueOf ( 50_000 ), janeSavingsAccount.getBalance () );
            assertEquals ( 1, janeSavingsAccount.getTransactions ().size () );

            BankTransaction withdrawTx = new BankTransaction ( BankTransactionType.WITHDRAWAL, BigDecimal.valueOf ( 20_000 ) );
            accountService.addBankTransaction ( withdrawTx,janeSavingsAccount );
            assertEquals ( BigDecimal.valueOf ( 30_000 ), janeSavingsAccount.getBalance () );
            assertEquals ( 2, janeSavingsAccount.getTransactions ().size () );
        }catch (MavenBankException ex){
            ex.printStackTrace ();
        }
    }

    @Test
    void addBankTransactionForNegativeWithdrawal(){
        try{
            Account janeSavingsAccount = accountService.findAccount ( 3 );
            BankTransaction withdrawTx = new BankTransaction ( BankTransactionType.WITHDRAWAL, BigDecimal.valueOf ( -20_000 ) );
            assertEquals ( 0, janeSavingsAccount.getTransactions ().size());
            assertThrows ( MavenBankTransactionException.class, ()->
                    accountService.addBankTransaction ( withdrawTx,janeSavingsAccount ));
            assertEquals ( BigDecimal.valueOf ( 0 ), janeSavingsAccount.getBalance () );
            assertEquals ( 0, janeSavingsAccount.getTransactions ().size () );



        }catch (MavenBankException ex){
            ex.printStackTrace ();
        }
    }

}