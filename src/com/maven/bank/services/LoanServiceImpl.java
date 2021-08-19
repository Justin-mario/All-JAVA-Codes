package com.maven.bank.services;

import com.maven.bank.datastore.LoanRequestStatus;
import com.maven.bank.entities.Account;
import com.maven.bank.entities.Customer;
import com.maven.bank.entities.LoanRequest;
import com.maven.bank.exceptions.MavenBankLoanException;

import java.math.BigDecimal;

public class LoanServiceImpl implements LoanService{
    @Override
    public LoanRequest approveLoanRequest(Account accountSeekingLoan) throws MavenBankLoanException {
        if (accountSeekingLoan == null){
            throw  new MavenBankLoanException ("Account is required");
        }
        if (accountSeekingLoan.getAccountLoanRequest ()== null){
            throw  new MavenBankLoanException ("no loan Request provided For Processing");
        }
        LoanRequest theLoanRequest = accountSeekingLoan.getAccountLoanRequest ();
        theLoanRequest.setStatus ( decideOnLoanRequestWithAccountBalance ( accountSeekingLoan ) );


        return theLoanRequest;
    }

    @Override
    public LoanRequest approveLoanRequest(Customer customer, Account accountSeekingLoan) throws MavenBankLoanException {
        LoanRequestStatus decision = decideOnLoanRequestWithLengthOfRelationshipAndTransactionVolume ( customer,accountSeekingLoan );
        LoanRequest theLoanRequest = accountSeekingLoan.getAccountLoanRequest ();
        theLoanRequest.setStatus ( decision );

        if (decision != LoanRequestStatus.APPROVED){
            theLoanRequest = approveLoanRequest(accountSeekingLoan );
        }

        return theLoanRequest;
    }

    private LoanRequestStatus decideOnLoan(Account accountSeekingLoan)throws MavenBankLoanException{
      LoanRequestStatus decision = decideOnLoanRequestWithAccountBalance ( accountSeekingLoan );

        return decision;
    }

    private LoanRequestStatus decideOnLoanRequestWithAccountBalance(Account accountSeekingLoan)throws MavenBankLoanException{
        LoanRequestStatus decision = LoanRequestStatus.PENDING;
        LoanRequest theLoanRequest = accountSeekingLoan.getAccountLoanRequest ();
        BigDecimal accountBalancePercentage = BigDecimal.valueOf ( 0.2 );
        BigDecimal loanAmountApprovedAutomatically = accountSeekingLoan.getBalance ().multiply (accountBalancePercentage);
        if (theLoanRequest.getLoanAmount ().compareTo (loanAmountApprovedAutomatically) < BigDecimal.ZERO.intValue ()){
            decision = LoanRequestStatus.APPROVED;
        }

        return decision;
    }

    private LoanRequestStatus decideOnLoanRequestWithLengthOfRelationshipAndTransactionVolume(Customer customer, Account accountSeekingLoan) throws MavenBankLoanException{
        LoanRequestStatus decision = LoanRequestStatus.PENDING;
        BigDecimal relationshipVolume = BigDecimal.valueOf ( 0.2 );

        BigDecimal totalCustomerBalance = BigDecimal.ZERO;
        if (customer.getAccounts ().size () > BigDecimal.ONE.intValue ())
            for (Account customerAccount : customer.getAccounts ()){
                totalCustomerBalance =  totalCustomerBalance.add ( customerAccount.getBalance () );
            }
        BigDecimal loanAmountApprovedAutomatically = totalCustomerBalance.multiply ( relationshipVolume );
            if (accountSeekingLoan.getAccountLoanRequest ().getLoanAmount ().compareTo ( loanAmountApprovedAutomatically ) < BigDecimal.ZERO.intValue ()){
                decision = LoanRequestStatus.APPROVED;
            }


        return decision;
    }

}
