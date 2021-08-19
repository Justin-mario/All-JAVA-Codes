package com.meven.bank;

import com.maven.bank.entities.Account;
import com.maven.bank.entities.Customer;
import com.maven.bank.datastore.AccountType;
import com.maven.bank.datastore.CustomerRepo;
import com.maven.bank.exceptions.MavenBankTransactionException;
import com.maven.bank.services.BankService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    Customer john;
    Account johnAccount;
    @BeforeEach
    void setUp(){
        john = new Customer();
//        johnAccount = new Account ();
    }

    @Test
    void openAccount(){
        john.setBvn ( BankService.generateBVN () );
        john.setEmail ( "Johndoe@yahoo.com" );
        john.setFirstName ( "John" );
        john.setSurname ( "Doe" );
        john.setPhoneNumber ( "08067650222" );
        try {
            johnAccount.setAccountNumber ( 1 );
//      johnAccount.setBalance ( new BigDecimal(5000) );
            johnAccount.setAccountPin ( "1000" );
            john.getAccounts ().add ( johnAccount );
            long accountNumber = johnAccount.getAccountNumber ();
            assertTrue ( CustomerRepo.getCustomers ().isEmpty () );
            assertEquals ( 1, accountNumber );
        }catch (MavenBankTransactionException ex){
            ex.printStackTrace ();
        }
    }
}
