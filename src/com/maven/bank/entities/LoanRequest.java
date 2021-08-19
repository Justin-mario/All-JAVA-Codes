package com.maven.bank.entities;

import com.maven.bank.datastore.LoanRequestStatus;
import com.maven.bank.datastore.LoanType;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class LoanRequest {
    private BigDecimal loanAmount;
    private LocalDateTime applyDate;
    private LocalDateTime startDate;
    private int tenor;
    private double interestRate;
    private LoanType typeOfLoan;
    private LoanRequestStatus status;


    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public LoanRequestStatus getStatus() {
        return status;
    }

    public void setStatus(LoanRequestStatus status) {
        this.status = status;
    }

    public LocalDateTime getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(LocalDateTime applyDate) {
        this.applyDate = applyDate;
    }

    public int getTenor() {
        return tenor;
    }

    public void setTenor(int tenor) {
        this.tenor = tenor;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LoanType getTypeOfLoan() {
        return typeOfLoan;
    }

    public void setTypeOfLoan(LoanType typeOfLoan) {
        this.typeOfLoan = typeOfLoan;
    }
}
