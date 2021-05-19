package com.CHAPTER_SEVEN;

public class SalesCommission {
     public static int[] commission = new int[9];
    public static int getArrayLength() {
        return commission.length;
    }

    public static int getEarningRange(int weeklySales) {
       double weeklySalary = 200 + (0.09 * weeklySales);
        int range = (int)weeklySalary/100;
        if (range > 10){
            range = 10;
        }
        switch (range) {
            case 2 -> {
                ++commission[0];
                return commission[0];
            }
            case 3 -> {
                ++commission[1];
                return commission[1];
            }
            case 4 -> {
                ++commission[2];
                return commission[2];
            }
            case 5 -> {
                ++commission[3];
                return commission[3]; }
            case 6 -> {
                ++commission[4];
                return commission[4]; }
            case 7 -> {
                ++commission[5];
                return commission[5]; }
            case 8 -> {
                ++commission[6];
                return commission[6]; }
            case 9 -> {
                ++commission[7];
                return commission[7]; }
            case 10 -> {
                ++commission[8];
                return commission[8]; }
        }

        return 0;
    }

}
