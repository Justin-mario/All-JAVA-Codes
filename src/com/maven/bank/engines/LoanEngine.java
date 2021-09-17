package com.maven.bank.engines;

import com.maven.bank.entities.Account;
import com.maven.bank.entities.Customer;
import com.maven.bank.exceptions.MavenBankLoanException;

import java.math.BigDecimal;

public interface LoanEngine {
    BigDecimal calculateAmountAutoApproved(Customer customer, Account accountSeekingLoan) throws MavenBankLoanException;

    default void validateLoanRequest(Customer customer, Account accountSeekingLoan) throws MavenBankLoanException {
        if (customer == null) {
            throw new MavenBankLoanException ( "No Customer Provided" );
        }
//        LocalDateTime loanDate = LocalDateTime.now ();
//        LocalDateTime customerRelationshipStartDate = accountSeekingLoan.getStartDate ();
//        long period = ChronoUnit.MONTHS.between  (customerRelationshipStartDate.toLocalDate (  ),loanDate.toLocalDate ());
//        if(period < 0){
//            throw new MavenBankLoanException ("Illegal argument");
//        }
        validateLoanRequest ( accountSeekingLoan );
    }
    default void validateLoanRequest(Account accountSeekingLoan) throws MavenBankLoanException {
        if (accountSeekingLoan == null) {
            throw new MavenBankLoanException ( "Account is required" );
        }
        if (accountSeekingLoan.getAccountLoanRequest () == null) {
            throw new MavenBankLoanException ( "no loan Request provided For Processing" );
        }

    }

    default BigDecimal getTotalCustomerBalance(Customer customer){
        BigDecimal totalCustomerBalance = BigDecimal.ZERO;
        if (customer.getAccounts ().size () > BigDecimal.ONE.intValue ())
            for (Account customerAccount : customer.getAccounts ()){
                totalCustomerBalance =  totalCustomerBalance.add ( customerAccount.getBalance () );
            }
        return totalCustomerBalance;
    }
}
