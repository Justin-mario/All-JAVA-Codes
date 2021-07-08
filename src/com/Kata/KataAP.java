package com.Kata;

public class KataAP {

    private int fourthNumberOfGP;
    private int fourthNumberOfAP;


    public void setFirstThreeNumbersOfArithmeticProgression(int firstNumber, int secondNumber, int thirdNumber ) {
          int firstDifference = secondNumber - firstNumber;
          int secondDifference = thirdNumber - secondNumber;
          if (firstDifference == secondDifference){
              fourthNumberOfAP = thirdNumber + secondDifference;
          }
          else
              throw new ArithmeticException ("Not an Arithmetic Progression");
          }

    public int getFourthElement() {
        return fourthNumberOfAP;
    }

    public void setFirstThreeNumbersOfGeometricProgression(int firstNumber, int secondNumber, int thirdNumber) {
        int firstDifference = thirdNumber / secondNumber;
        int secondDifference = secondNumber / firstNumber;
        System.out.println (firstDifference + " " +secondDifference);
        if( firstDifference == secondDifference){
            int ratio = firstDifference ;
            fourthNumberOfGP = (int) (firstNumber * Math.pow ( ratio,3 ));
        }
    }

    public int getFourthElementOfGeometricProgression() {
        return fourthNumberOfGP;
    }
    //        fourthNumber = (int) (firstNumber * Math.pow ( difference, 3 ));
}
