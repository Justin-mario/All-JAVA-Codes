package com.maven.bank.engines;

import com.maven.bank.datastore.LoanRequestStatus;
import com.maven.bank.entities.Account;
import com.maven.bank.entities.Customer;
import com.maven.bank.exceptions.MavenBankLoanException;

import java.math.BigDecimal;

public class LoanEngineByBalance implements LoanEngine{
    @Override
    public BigDecimal calculateAmountAutoApproved(Customer customer, Account accountSeekingLoan) throws MavenBankLoanException {
        validateLoanRequest ( customer, accountSeekingLoan );

        BigDecimal totalBalancePercentage = BigDecimal.valueOf ( 0.2 );
        BigDecimal totalCustomerBalance = BigDecimal.ZERO;
        if (customer.getAccounts ().size () > BigDecimal.ONE.intValue ())
            for (Account customerAccount : customer.getAccounts ()){
                totalCustomerBalance =  totalCustomerBalance.add ( customerAccount.getBalance () );
            }
        BigDecimal loanAmountApprovedAutomatically = BigDecimal.ZERO;
            if (totalCustomerBalance.intValue () > BigDecimal.ZERO.intValue ())
                 loanAmountApprovedAutomatically = totalCustomerBalance.multiply ( totalBalancePercentage );

        return loanAmountApprovedAutomatically;
    }

    @Override
    public BigDecimal calculateLoanPercentage(long determinant) {
        return BigDecimal.ZERO;
    }

}
