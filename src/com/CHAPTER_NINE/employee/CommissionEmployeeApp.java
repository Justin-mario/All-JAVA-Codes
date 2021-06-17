package com.CHAPTER_NINE.employee;

public class CommissionEmployeeApp {
    public static void main(String[] args) {
        CommissionEmployee commissionEmployee = new CommissionEmployee ("Sue","Jones" ,"222-222-222", 0.04, 2000 );

        commissionEmployee.setCommissionRate ( 0.06 );
        commissionEmployee.setGrossSales ( 1000 );
        System.out.println (commissionEmployee);
    }
}
