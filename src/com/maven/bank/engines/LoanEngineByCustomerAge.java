package com.maven.bank.engines;

import com.maven.bank.entities.Account;
import com.maven.bank.entities.Customer;
import com.maven.bank.exceptions.MavenBankLoanException;

import java.math.BigDecimal;

public class LoanEngineByCustomerAge implements LoanEngine{
    @Override
    public BigDecimal calculateAmountAutoApproved(Customer customer, Account accountSeekingLoan) throws MavenBankLoanException {
        BigDecimal loanAmountAutomaticallyApproved = BigDecimal.ZERO;
        validateLoanRequest (customer ,accountSeekingLoan );
        return loanAmountAutomaticallyApproved;
    }

    private BigDecimal getLoanAmount(int customerAge) throws MavenBankLoanException {
        BigDecimal totalBalancePercentage = BigDecimal.ZERO;
        if (customerAge > 0 || customerAge <18)
            totalBalancePercentage = BigDecimal.ZERO;
        else if(customerAge < 25 || customerAge > 17 )
            totalBalancePercentage = BigDecimal.valueOf ( 0.02 );
//        switch (customerAge) {
//            case 0: case 1: case 2:
//                return BigDecimal.ZERO;
//            case 3: case 4: case 5:
//
//                break;
//            case 6: case 7: case 8: case 9: case 10: case 11:
//                totalBalancePercentage = BigDecimal.valueOf ( 0.04 );
//                break;
//            case 12: case 13: case 14: case 15: case 16: case 17:
//                totalBalancePercentage = BigDecimal.valueOf ( 0.06 );
//                break;
//            case 18: case 19: case 20: case 21: case 22: case 23:
//                totalBalancePercentage = BigDecimal.valueOf ( 0.08 );
//                break;
//            default:
//                if (customerAge > 0)
//                    totalBalancePercentage = BigDecimal.valueOf ( 0.10 );
//                else
//                    throw new MavenBankLoanException ( "Month cannot be negative" );
//        }
        return totalBalancePercentage;
    }

}
