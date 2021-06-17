package com.CHAPTER_NINE.employee;

public class BaseCommissionEmployeeApp {
    public static void main(String[] args) {

        BaseCommissionEmployee baseCommissionEmployee = new BaseCommissionEmployee ( "Bob", "Lewis",
                "333-33-33333", 5000.0, 0.04, 1000.0 );

        baseCommissionEmployee.setCommissionRate ( 0.04 );
        baseCommissionEmployee.setGrossSales ( 5000 );
        baseCommissionEmployee.setBaseSalary ( 1000 );

        System.out.println (baseCommissionEmployee);
    }
}
