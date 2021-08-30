package com.CHAPTER_SIX.ParkingCharges;

public class ParkingCharges {
    static double charges = 2.0;

    public static String displayOptionMenu(){
        String prompt = """
                PARKING HOURS WITH CHARGES
                
                1 --> 3 Hours Or Less ----------------------  $2.00
                2 --> For Extra Hour Above 3 Hours ---------- $0.50
                3 --> 24 hours ------------------------------ $10.00
                4 --> Get Yesterday Charges And Exit
                
                NO SERVICES ABOVE 24 HOUrs.""";
        return prompt;
    }

    public static double getChargesFor3HoursAndLess(int hoursParked) {
        if (hoursParked > 0 && hoursParked <= 3) {
                double chargesFor3Hours = charges;
            System.out.println ("Charges is " + chargesFor3Hours);
                return chargesFor3Hours;
            }
        else{
            System.out.println ("Choose Appropriate Option");
            return 0.0;}
    }
    public static double getChargesForAbove3Hours(int hoursParked) {
        if(hoursParked > 3 && hoursParked < 24){
            int extraHours = hoursParked - 3;
            double chargesForAbove3Hours = (extraHours * 0.5) + charges;
            System.out.println ("Charges is " + chargesForAbove3Hours);
            return chargesForAbove3Hours;}
        else
            System.out.println ("Choose Appropriate Option");
            return 0.0;
    }

    public static int getChargesFor24Hours(int hoursParked) {
        if (hoursParked == 24){
            int chargesFor24Hours = 10;
            System.out.println ("Charges is " + chargesFor24Hours);
            return chargesFor24Hours;
        }
        else
            System.out.println ("Choose Appropriate Option");
        return 0;
    }
}
