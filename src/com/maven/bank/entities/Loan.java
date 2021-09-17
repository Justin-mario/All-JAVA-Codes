package com.maven.bank.entities;

import enums.LoanStatus;
import enums.LoanType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Loan {
    private BigDecimal loanAmount;
    private LocalDateTime applyDate;
    private int tenor;
    private double interestRate;
    private LoanType typeOfLoan;
    private LoanStatus status;
}
