package com.maven.bank.services;

import enums.LoanRequestStatus;
import com.maven.bank.entities.*;
import enums.AccountType;
import com.maven.bank.datastore.CustomerRepo;
import enums.BankTransactionType;
import com.maven.bank.exceptions.MavenBankException;
import com.maven.bank.exceptions.MavenBankInsufficientFundException;
import com.maven.bank.exceptions.MavenBankTransactionException;

import java.math.BigDecimal;

public class AccountServiceImpl implements AccountService {

    @Override
    public long openAccount(Customer theCustomer, AccountType type) throws MavenBankException {
        long accountNumber = BigDecimal.ZERO.longValue ();
        if (type == AccountType.SAVINGSACCOUNT){
           accountNumber = openSavingsAccount ( theCustomer );
        }
        else if(type == AccountType.CURRENTACCOUNT){
           accountNumber = openCurrentAccount ( theCustomer );
        }
     return accountNumber;
    }

    @Override
    public long openSavingsAccount(Customer theCustomer) throws MavenBankException {
        if (theCustomer == null) {
            throw new MavenBankException ( "No customer added " );
        }
        SavingsAccount newAccount = new SavingsAccount ();
        if (accountTypeExists ( theCustomer, newAccount.getClass ().getTypeName ())) {
            throw new MavenBankException ( "Customer Exits" );
        }


        newAccount.setAccountNumber ( BankService.getGenerateAccountNumber () );

        theCustomer.getAccounts ().add ( newAccount );
        CustomerRepo.getCustomers ().put ( theCustomer.getBvn (), theCustomer );
        return newAccount.getAccountNumber ();

    }

    @Override
    public long openCurrentAccount(Customer theCustomer) throws MavenBankException {
        if (theCustomer == null) {
            throw new MavenBankException ( "No customer added " );
        }
        CurrentAccount newAccount = new CurrentAccount ();
        if (accountTypeExists ( theCustomer,newAccount.getClass ().getTypeName ())  ) {
            throw new MavenBankException ( "Customer Exits" );
        }

        ;
        newAccount.setAccountNumber ( BankService.getGenerateAccountNumber () );

        theCustomer.getAccounts ().add ( newAccount );
        CustomerRepo.getCustomers ().put ( theCustomer.getBvn (), theCustomer );
        return newAccount.getAccountNumber ();


    }

    @Override
    public BigDecimal deposit(BigDecimal amount, long accountNumber) throws MavenBankException {
        BankTransactionType type = BankTransactionType.DEPOSIT;
        Account account = findAccount ( accountNumber );
        validate ( amount, account );
        try {
            account = findAccount ( accountNumber );
        } catch (MavenBankException e) {
            e.printStackTrace ();
        }

        BigDecimal accountBalance = account.getBalance ();
        accountBalance = accountBalance.add ( amount );
        account.setBalance ( accountBalance );
        return accountBalance;
    }

    @Override
    public Account findAccount(long accountNumber) throws MavenBankException {
        Account foundAccount = null;
        boolean accountFound = false;

        for (Customer customer : CustomerRepo.getCustomers ().values ()) {
            for (Account aAccount : customer.getAccounts ()) {
                if (aAccount.getAccountNumber () == accountNumber) {
                    foundAccount = aAccount;
                    accountFound = true;
                    break;

                }
            }
            if (accountFound) {
                break;
            }
        }
        return foundAccount;
    }

    @Override
    public Account findAccount(Customer customer, long accountNumber) throws MavenBankException {
        return null;
    }

    @Override
    public BigDecimal withdraw(BigDecimal amount, long accountNumber) throws MavenBankInsufficientFundException, MavenBankTransactionException, MavenBankException {
//        BankTransactionType type = BankTransactionType.WITHDRAWAL;
        Account account = findAccount ( accountNumber );
        validate ( amount, account );
        try{
            checkForSufficientBalance ( amount, account);
        }catch (MavenBankInsufficientFundException ex){
            this.applyOverdraft ( account );
            throw ex;

        }

//        BigDecimal accountBalance = account.getBalance ();

        BigDecimal newBalance = debitAccount ( amount, accountNumber );
        return newBalance;
    }

    @Override
    public void applyOverdraft(Account amount) {
       //TODO
    }

    @Override
    public LoanRequestStatus applyForLoan(Account theAccount) {
    return null;
    }

    @Override
    public void addBankTransaction(BankTransaction transaction, Account account) throws MavenBankException {
if (transaction == null || account == null){
    throw new MavenBankTransactionException ("Transaction And Account is required to add transaction");
}

if (transaction.getType () == BankTransactionType.DEPOSIT){
    deposit (transaction.getAmount (), account.getAccountNumber ());

}else if (transaction.getType () == BankTransactionType.WITHDRAWAL){
    withdraw ( transaction.getAmount (), account.getAccountNumber () );
}
        account.getTransactions ().add ( transaction );
    }


    private BigDecimal debitAccount(BigDecimal amount, long accountNumber) throws MavenBankException {
        Account account = findAccount ( accountNumber );
        BigDecimal accountBalance = account.getBalance ();
        accountBalance = accountBalance.subtract ( amount );
        account.setBalance ( accountBalance );
        return accountBalance;
    }


    private boolean accountTypeExists(Customer aCustomer, String typeName) {
        boolean accountTypeExists = false;
        for (Account customerAccount : aCustomer.getAccounts ()) {
            if (customerAccount.getClass ().getTypeName () .equals ( typeName )) {
                accountTypeExists = true;
                break;
            }
        }
        return accountTypeExists;
    }

    private void validate(BigDecimal amount, Account account) throws MavenBankInsufficientFundException, MavenBankTransactionException, MavenBankException {

                if (account == null) {
                    throw new MavenBankTransactionException ( "Invalid Account" );
                }
                if (amount.compareTo ( BigDecimal.ZERO ) < 0) {
                    throw new MavenBankTransactionException ( "Deposit Cannot be Negative" );
                }


                if (account == null) {
                    throw new MavenBankTransactionException ( "Invalid Account" );
                }
                if (amount.compareTo ( BigDecimal.ZERO ) < BigDecimal.ONE.intValue ()) {
                    throw new MavenBankTransactionException ( "You Cannot Withdraw negative amount" );
                }



            }


//        BigDecimal accountBalance = account.getBalance ();
//        if (type == BankTransactionType.WITHDRAWAL && amount.compareTo ( accountBalance ) > 0){
//            throw new MavenBankInsufficientFundException ( "Insufficient Balance" );
//               }
//        }


    private  void checkForSufficientBalance(BigDecimal amount, Account account)throws MavenBankException{
        BigDecimal accountBalance = account.getBalance ();
        if (amount.compareTo ( accountBalance ) > 0) {
            throw new MavenBankInsufficientFundException ( "Insufficient Balance" );
        }
    }



}


