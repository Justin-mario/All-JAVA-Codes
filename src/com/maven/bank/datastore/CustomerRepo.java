package com.maven.bank.datastore;

import com.maven.bank.entities.BankTransaction;
import com.maven.bank.entities.CurrentAccount;
import com.maven.bank.entities.Customer;
import com.maven.bank.entities.SavingsAccount;
import com.maven.bank.exceptions.MavenBankException;
import com.maven.bank.services.AccountService;
import com.maven.bank.services.AccountServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class CustomerRepo {
    private static Map<Long, Customer> customers = new HashMap<> ();

    public static Map<Long, Customer> getCustomers() {
        return customers;
    }


    private  void setCustomers(Map<Long, Customer> customers) {
        this.customers = customers;
    }
    static {
        reset();
    }


    public static void reset() {
        Customer john = new Customer ();
        john.setBvn ( 1 );

        john.setEmail ( "Johndoe@yahoo.com" );
        john.setFirstName ( "John" );
        john.setSurname ( "Doe" );
        john.setPhoneNumber ( "08067650222" );

        SavingsAccount johnSavingsAccount = new SavingsAccount ( 1 );
        john.setRelationshipStartDate ( johnSavingsAccount.getStartDate () );

        BankTransaction initialDeposit = new BankTransaction ( BankTransactionType.DEPOSIT, BigDecimal.valueOf ( 300_000 ) );
        johnSavingsAccount.setBalance ( BigDecimal.valueOf ( 300_000 ) );
        johnSavingsAccount.getTransactions ().add ( initialDeposit );

        BankTransaction mayAllowance = new BankTransaction ( BankTransactionType.DEPOSIT, BigDecimal.valueOf ( 50_000 ) );
        mayAllowance.setDateTime ( LocalDateTime.now ().minusMonths ( 3 ) );
        johnSavingsAccount.getTransactions ().add ( mayAllowance);

        BankTransaction juneAllowance = new BankTransaction ( BankTransactionType.DEPOSIT, BigDecimal.valueOf ( 50_000 ) );
        juneAllowance.setDateTime ( LocalDateTime.now ().minusMonths ( 2 ) );
        johnSavingsAccount.getTransactions ().add ( juneAllowance);
        BankTransaction julyAllowance = new BankTransaction ( BankTransactionType.DEPOSIT, BigDecimal.valueOf ( 50_000 ) );
        julyAllowance.setDateTime ( LocalDateTime.now ().minusMonths ( 1 ) );
        johnSavingsAccount.getTransactions ().add ( julyAllowance);
        johnSavingsAccount.setBalance ( BigDecimal.valueOf ( 450_000 ) );

        john.getAccounts().add( johnSavingsAccount );
        customers.put ( john.getBvn (), john );

        CurrentAccount johnCurrentAccount = new CurrentAccount ( 2, BigDecimal.valueOf ( 50_000_000 ) );
        john.setRelationshipStartDate ( johnCurrentAccount.getStartDate () );
        john.getAccounts ().add( johnCurrentAccount );
         Customer jane = new Customer ();
        jane.setBvn ( 2);

        jane.setEmail ( "Janebessie@yahoo.com" );
        jane.setFirstName ( "Jane" );
        jane.setSurname ( "Bessie" );
        jane.setPhoneNumber ( "07067650211" );
        SavingsAccount janeSavingsAccount =  new SavingsAccount( 3 );
        jane.setRelationshipStartDate ( janeSavingsAccount.getStartDate () );
        jane.getAccounts ().add ( janeSavingsAccount );
        customers.put ( jane.getBvn (), jane );
    }

    public static void tearDown(long bvn){
        customers.remove(bvn);
    }
}
