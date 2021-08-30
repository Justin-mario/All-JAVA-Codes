package com.CHAPTER_EIGHT.date;

import java.util.Arrays;

public class Date {
    private final String[] MONTHS = {
            "January", "February", "March", "April",
            "May", "June", "July", "August",
            "September", "October", "November",
            "December"};
    private final int[] DAYS_IN_MONTHS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31,30, 31};

    private int month;
    private int day;
    private int year;
    private int daysInAYear;

    public Date(int month, int day, int year){
        if (month < 1 || month > 12){
            throw new IllegalArgumentException ("Month is out of range");
        }
        if (day < 1 || day > 31) {

            throw new IllegalArgumentException ("day out of range");
        }
        this.month = month;
        this.day = day;
        this.year = year;
        daysInAYear = calculateDaysInAYear ( month,day );

    }
    public Date(String month, int day, int year){
        this.day = day;
        this.year = year;

        int result = getMonthIndex ( month );
        if (result < 0 ){
            throw  new IllegalArgumentException ("Month is not valid");
        }
        this.month = result;
        this.daysInAYear = calculateDaysInAYear ( this.month, this.day );

    }


    public Date(int day, int year) {
        this.year = year;
        if (day <= 31 && day > 0){
            this.day = day;
            this.month = 1;
        }
        else
        calculateMonthAndDay ( day);
        this.calculateDaysInAYear ( this.month, this.day );
    }

    public int getMonthIndex(String month){
        for (int i = 0; i < MONTHS.length; i++ ){
            if (month.equals (MONTHS[i])){
                return i + 1;
            }
        }
    return  -1;
    }

    public void  calculateMonthAndDay(int daysInYear){
        for (int i = 0; i < DAYS_IN_MONTHS.length; i++){
            daysInYear -= DAYS_IN_MONTHS[i];

            if (daysInYear <= 31 && daysInYear > 0){
                setDay(daysInYear);
                setMonth ( i + 2 );
            }
        }
    }

    private void setDay(int day) {
        this.day = day;
    }

    public int getDay(){
        return day;
    }

    public int getMonth(){
        return month;
    }
    public void setMonth(int month){
        this.month = month;
    }

    public int getYear(){
        return year;
    }

    public int calculateDaysInAYear(int month, int day){
        int sum = day;
        for (int i = 0; i < month - 1; i++){
            sum += DAYS_IN_MONTHS[i];
        }
        return -1;
    }

    @Override
    public String toString() {
        return String.format ( "02%d/%02d/%d%n%s %02d, %d%n%03d,%d ", month, day, year, this.MONTHS[month-1], day, daysInAYear ,year );
    }
}
