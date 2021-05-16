package com.CHAPTER_FIVE.Facebook;

public class FacebookUserGrowthCalculator {
        static double currentNumberOfFacebookUser = 1_000_000_000;
        static double userBase = 1_000_000_000.0;
        static double growthRate = 0.04;
       static double targetUserBase;
       static int newUserBase;
        static int month = 1;
        static int firstMonth = 0;
        static int secondMonth = 0;
        static boolean isFirstTarget = false;

    public static double getCurrentUser() {
        return currentNumberOfFacebookUser;
    }

    public static double getMonthsItTookToGrowToTargetNumber() {
        while(true){
            targetUserBase = userBase * Math.pow ( 1.0 + growthRate, month );
            boolean isTrue = targetUserBase >= 1_500_000_000.0;
            newUserBase = (int) targetUserBase;

            if (isTrue && isFirstTarget == false){
                firstMonth = month;
                isFirstTarget = true;
                return month;
            }
            month++;
        }
    }

    public static double getMonthsItTookToGrowTo2Billion() {
        while(true){
                targetUserBase = userBase * Math.pow ( 1.0 + growthRate, month );
                boolean isTrue = targetUserBase >= 1_500_000_000.0;
                newUserBase = (int) targetUserBase;

                if(targetUserBase >= 2_000_000_000){
                    secondMonth = month;
                    return month;
                }
                month++;

            }
    }
}
