package com.CHAPTER_NINE.employee;

public class BaseCommissionEmployee extends CommissionEmployee {
    private double baseSalary;

    public BaseCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
                                  double commissionRate,double baseSalary) {
        super ( firstName, lastName, socialSecurityNumber, grossSales, commissionRate );
        this.baseSalary = baseSalary;
    }


    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 0.0){
            throw new IllegalArgumentException ("Salary must be above Zero");}
        else{
        this.baseSalary = baseSalary;}
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    @Override
    public double earning(){
        return super.earning () + baseSalary;
    }

    @Override
    public String toString() {
        return String.format (  "%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f%n%s: %.2f%n%s: %.2f " , "Commission Employee", getFirstName (),
                getLastName (), "Social Security Number", getSocialSecurityNumber (), "Gross Sale", getGrossSales (),
                "Commission Rate", getCommissionRate (), "Base Salary", baseSalary, "Earning", earning ());
    }
}
