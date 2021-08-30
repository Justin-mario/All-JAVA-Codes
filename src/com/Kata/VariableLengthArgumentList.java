package com.Kata;

public class VariableLengthArgumentList {

    public static void total(double num, int...number){
        int total = 0;
        for (int numbers: number) {
            total += numbers;
        }
        System.out.println (total + num);
    }

    public static void main(String[] args) {
        int x1 = 1;
        int x2 =2;
        int x3 =3;
        int x4 =4;
        int x5 =5;
        double x6 =6.1;
        total (x6, x1, x2, x3, x4, x5 );
    }

}
