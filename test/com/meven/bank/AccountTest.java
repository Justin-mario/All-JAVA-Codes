package com.meven.bank;

import com.maven.bank.entities.Account;
import com.maven.bank.entities.Customer;
import com.maven.bank.datastore.CustomerRepo;
import com.maven.bank.entities.SavingsAccount;
import com.maven.bank.exceptions.MavenBankTransactionException;
import com.maven.bank.services.BankService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    Customer john;
    Account johnAccount;
    @BeforeEach
    void setUp(){
        john = new Customer();

    }
    @AfterEach
    void tearDown(){
        BankService.tearDown ();
        CustomerRepo.reset ();
    }

    @Test
    void openAccount(){
        johnAccount = new SavingsAccount ();
        john.setBvn ( 1 );
        john.setEmail ( "Johndoe@yahoo.com" );
        john.setFirstName ( "John" );
        john.setSurname ( "Doe" );
        john.setPhoneNumber ( "08067650222" );
        try {
            johnAccount.setAccountNumber ( 1 );
            johnAccount.setBalance ( new BigDecimal (5000) );
            johnAccount.setAccountPin ( "1000" );
            john.getAccounts ().add ( johnAccount );
            long accountNumber = johnAccount.getAccountNumber ();
            assertFalse ( CustomerRepo.getCustomers ().isEmpty () );
            assertEquals ( 1, accountNumber );
        }catch (MavenBankTransactionException ex){
            ex.printStackTrace ();
        }
    }
}
