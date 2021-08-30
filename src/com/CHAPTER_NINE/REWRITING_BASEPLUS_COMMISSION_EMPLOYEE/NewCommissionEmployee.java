package com.CHAPTER_NINE.REWRITING_BASEPLUS_COMMISSION_EMPLOYEE;

import com.CHAPTER_NINE.employee.Employee;

public class NewCommissionEmployee {
    private double grossSales;
    private double commissionRate;

    Employee employee = new Employee ( "John", "Dew", "222-22-22222" );

    public NewCommissionEmployee(String firstName, String lastName, String socialSecurityNumber,
                                 double grossSales, double commissionRate) {

        if (grossSales < 0.0){
            throw new IllegalArgumentException ("Gross Sales must not be less than Zero");
        }
        if (commissionRate <= 0.0 || commissionRate >= 1.0){
            throw new IllegalArgumentException ("Commission Rate Must Be Between above Zero And Less Than One");}
       firstName = employee.getFirstName ();
        lastName = employee.getLastName ();
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }

    public void setGrossSales(double grossSales) {
        if (grossSales < 0.0){
            throw new IllegalArgumentException ("Gross Sales must not be less than Zero");}
        else{
            this.grossSales = grossSales;}
    }

    public void setCommissionRate(double commissionRate) {
        if (commissionRate <= 0.0 || commissionRate >= 1.0)
            throw new IllegalArgumentException ("Commission Rate Must Be Between above Zero And Less Than One");
        this.commissionRate = commissionRate;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public double earning(){
        return grossSales * commissionRate;
    }

    public double getCommissionRate() {
        return commissionRate;
    }
    public String getFirstName(){
       return employee.getFirstName ();
    }

    public String getLastName(){
        return employee.getLastName ();
    }

    public String getSocialSecurityNumber(){
        return getSocialSecurityNumber ();
    }

    @Override
    public String toString() {
        return String.format (  "%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f%n%s: %.2f " , "Commission Employee", getFirstName (), getLastName (),
                "Social Security Number", getSocialSecurityNumber (), "Gross Sale", grossSales, "Commission Rate",
                commissionRate, "Earning", earning () );
    }
}
