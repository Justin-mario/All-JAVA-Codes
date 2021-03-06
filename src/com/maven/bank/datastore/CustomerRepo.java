package com.maven.bank.datastore;

import com.maven.bank.entities.*;
import enums.BankTransactionType;
import enums.EmploymentLevel;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
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
        LocalDate dob = LocalDate.of(1991, Month.MAY, 12);
        john.setDateOfBirth ( dob );
        john.setEmail ( "Johndoe@yahoo.com" );
        john.setFirstName ( "John" );
        john.setSurname ( "Doe" );
        john.setPhoneNumber ( "08067650222" );

        Company odogwuAssociates = new Company ( "0d768754", "odogwu Enterprise" );
        Employment salesBoy = new Employment ( odogwuAssociates, LocalDate.of ( 2010, Month.APRIL, 01 ), LocalDate.of ( 2014, Month.AUGUST, 31  ), BigDecimal.valueOf ( 360000 ) );
        salesBoy.setLevel ( EmploymentLevel.ENTRY );
        john.getEmploymentHistory ().add ( salesBoy );

        Company utiva = new Company ( "ut688768", "Utiva" );
        Employment customerSuccess = new Employment ( utiva, LocalDate.of ( 2018, Month.JUNE, 01 ),LocalDate.of ( 2020, Month.DECEMBER, 31 ), BigDecimal.valueOf ( 12000000 ) );
        customerSuccess.setLevel ( EmploymentLevel.SUPERVISOR );
        john.getEmploymentHistory ().add ( customerSuccess );

        Company kpmg = new Company ( "kp8768768", "KPMG" );
        Employment forensicAnalyst = new Employment ( kpmg, LocalDate.of ( 2021, Month.SEPTEMBER, 20 ), BigDecimal.valueOf ( 12000000 ));
        forensicAnalyst.setLevel ( EmploymentLevel.ENTRY );

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
        dob = LocalDate.of(2000, Month.JANUARY, 21);
        jane.setDateOfBirth ( dob );
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
