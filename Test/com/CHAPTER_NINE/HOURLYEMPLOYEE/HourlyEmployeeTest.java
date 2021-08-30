package com.CHAPTER_NINE.HOURLYEMPLOYEE;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HourlyEmployeeTest {
    @Test
        void getEmployeeFirstName(){
        HourlyEmployee hourlyEmployee = new HourlyEmployee ( "John", "Dew", "111-11-11111",
                0.0, 0.0);
        assertEquals ( "John", hourlyEmployee.getFirstName () );
    }

    @Test
    void getEmployeeNameLast(){
        HourlyEmployee hourlyEmployee = new HourlyEmployee ( "John", "Dew", "111-11-11111",
                0.0, 0.0);
        assertEquals ( "Dew", hourlyEmployee.getLastName ());
    }

    @Test
    void getEmployeeSocialSecurityNumber(){
        HourlyEmployee hourlyEmployee = new HourlyEmployee ( "John", "Dew", "111-11-11111",
                0.0, 0.0);
        assertEquals ( "111-11-11111", hourlyEmployee.getSocialSecurityNumber () );
    }

    @Test
    void getEmployeeWeeklyEarning(){
        HourlyEmployee hourlyEmployee = new HourlyEmployee ( "John", "Dew", "111-11-11111",
                0.0, 0.0);
        hourlyEmployee.setHour ( 40 );
        hourlyEmployee.setWage ( 17.5 );
        assertEquals (700, hourlyEmployee.earning ()  );
    }

    @Test
    void getEmployeeWeeklyEarningWithOverTimePay(){
        HourlyEmployee hourlyEmployee = new HourlyEmployee ( "John", "Dew", "111-11-11111",
                0.0, 0.0);
        hourlyEmployee.setHour ( 160 );
        hourlyEmployee.setWage ( 17.5 );
        assertEquals (1750, hourlyEmployee.earning ()  );
        System.out.println (hourlyEmployee);
    }

}