package com.CHAPTER_NINE.HOURLYEMPLOYEE;

import com.CHAPTER_NINE.employee.Employee;

public class HourlyEmployee extends Employee {
    private double hour;
    private double wage;
    private double expectedWorkHour = 40;
    private double overtime;

    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double hour, double wage) {
        super ( firstName, lastName, socialSecurityNumber );
        if (wage < 0.0){
            throw new IllegalArgumentException ("Wage Must Not Be Less Than Zero");
        }
        if (hour < 0.0 || hour > 168){
            throw new IllegalArgumentException ("Hour Must Be Between 0 And 168 Hours");
        }
        this.hour = hour;
        this.wage = wage;
    }

    public void setHour(double hour) {
        if (hour < 0.0 || hour > 168){
            throw new IllegalArgumentException ("Hour Must Be Between 0 And 168 Hours");
        }
        this.hour = hour;
    }

    public void setWage(double wage) {
        if (wage < 0.0){
            throw new IllegalArgumentException ("Wage Must Not Be Less Than Zero");
        }
        this.wage = wage;
    }

    public double getHour() {
        return hour;
    }

    public double getWage() {
        return wage;
    }

    public double earning(){
        if(hour > 40){
            overtime = hour - expectedWorkHour;
            double overtimePay = wage/2;
            double totalEarning = (expectedWorkHour * wage) + (overtimePay * overtime);
        return  totalEarning;}
        return wage * hour;
    }

    @Override
    public String toString() {
        return String.format ( "%s: %s %s%n%s: %s%n %s: %.2f%n %s: %.2f%n %s: %.2f", "Commission Employee", getFirstName (), getLastName (),
                "Social Security Number", getSocialSecurityNumber (), "Hours Worked", hour, "Wage Per Hour", wage, "Earning", earning ());
    }
}
