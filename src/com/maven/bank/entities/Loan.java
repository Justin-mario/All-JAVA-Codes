package com.maven.bank.entities;

import com.maven.bank.datastore.LoanRequestStatus;
import com.maven.bank.datastore.LoanStatus;
import com.maven.bank.datastore.LoanType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Year;

public class Loan {
    private BigDecimal loanAmount;
    private LocalDateTime applyDate;
    private int tenor;
    private double interestRate;
    private LoanType typeOfLoan;
    private LoanStatus status;
}
