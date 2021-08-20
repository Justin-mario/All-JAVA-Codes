package com.maven.bank.engines;

import com.maven.bank.entities.Account;
import com.maven.bank.entities.Customer;
import com.maven.bank.exceptions.MavenBankLoanException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


public class LoanEngineByRelationshipLength implements LoanEngine{
    @Override
    public BigDecimal calculateAmountAutoApproved(Customer customer, Account accountSeekingLoan) throws MavenBankLoanException {
        validateLoanRequest ( customer, accountSeekingLoan );
        LocalDateTime customerRelationshipStartDate = accountSeekingLoan.getStartDate ();
        LocalDateTime loanDate = LocalDateTime.now ();
        long period = ChronoUnit.MONTHS.between  (customerRelationshipStartDate.toLocalDate (  ),loanDate.toLocalDate ());



        BigDecimal totalBalancePercentage;
        BigDecimal totalCustomerBalance = BigDecimal.ZERO;
        if (customer.getAccounts ().size () > BigDecimal.ONE.intValue ())
        for (Account customerAccount : customer.getAccounts ()){
            totalCustomerBalance =  totalCustomerBalance.add ( customerAccount.getBalance () );
        }
        BigDecimal loanAmountApprovedAutomatically ;

        System.out.println ( period );
        switch ((int) period) {
            case 0:
            case 1:
            case 2:
                throw new MavenBankLoanException ( "Sorry, You Have few Months More To Qualify" );
            case 3:
            case 4:
            case 5:
                totalBalancePercentage = BigDecimal.valueOf ( 0.02 );
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                totalBalancePercentage = BigDecimal.valueOf ( 0.04 );
                break;
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                totalBalancePercentage = BigDecimal.valueOf ( 0.06 );
                break;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                totalBalancePercentage = BigDecimal.valueOf ( 0.08 );
                break;
            default:
                if (period > 0)
                totalBalancePercentage = BigDecimal.valueOf ( 0.10 );
                else
                    throw new MavenBankLoanException ("Month cannot be negative");

        }
        loanAmountApprovedAutomatically = totalCustomerBalance.multiply ( totalBalancePercentage );







        return loanAmountApprovedAutomatically;
    }
}
