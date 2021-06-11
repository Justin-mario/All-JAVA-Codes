package com.CHAPTER_SEVEN.Fibonacci;

import java.util.Arrays;

public class FibonacciSequence {

    public static int fibonacciWithIntValue(int n){
        int[] fibonacciSeries = new int[n];
        if (n >2){
        fibonacciSeries[1] = 1;
        for (int i = 2; i < n; i++){
            fibonacciSeries[i ] = fibonacciSeries[i -1] + fibonacciSeries[i -2];
            System.out.println ( Arrays.toString (fibonacciSeries));
        }
        }
        else
            System.out.println ("invalid value");
        return fibonacciSeries[n-1];
    }


    public static double fibonacciWithIntDouble(double n) {
        double[] fibonacciSeries = new double[(int) n];
        if (n >2){
            fibonacciSeries[1] = 1;
            for (int i = 2; i < n; i++){
                fibonacciSeries[i ] = fibonacciSeries[i -1] + fibonacciSeries[i -2];
                System.out.println ( Arrays.toString (fibonacciSeries));
            }
        }
        else
            System.out.println ("invalid value");

        return fibonacciSeries[(int) (n-1)];
    }

    }

