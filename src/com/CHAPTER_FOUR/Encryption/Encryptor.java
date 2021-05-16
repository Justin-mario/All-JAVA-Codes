package com.CHAPTER_FOUR.Encryption;

public class Encryptor {
    static int digits;
    static int firstDigit;
    static int secondDigit;
    static int thirdDigit;
    static  int fourthDigit;
    public static int getUserInput(int userInput) {
        return userInput;
    }

    public static int getEncryptedDigits(int userInput) {
        userInput = 7842;
         firstDigit = ((userInput /1000) + 7)%10;
        userInput = userInput % 1000;
         secondDigit = ((userInput/100) + 7)%10;
        userInput = userInput % 100;
         thirdDigit = ((userInput/10) + 7)%10;
        userInput = userInput % 10;
        fourthDigit = (userInput + 7)%10;
         digits = (thirdDigit *1000) + (fourthDigit * 100) + (firstDigit * 10) + secondDigit;
        return digits;
    }

    public static int getDecryptedDigits(int digit) {
        int firstReversedDigit = (firstDigit - 7) * 10;
        int secondReversedDigit = secondDigit * 10 - 7;
        int thirdReversedDigit = thirdDigit * 10 - 7;
        int fourthReversedDigit = fourthDigit * 10 -7;
        //int decryptedDigits =
        return 0;
    }

    /*public static void main(String[] args) {
        digits = 1945;
        int firstDigit = (digits/1000);
        digits = digits % 1000;
        int secondDigit = digits/100;
        digits = digits % 100;
        int thirdDigit = digits /10;
        digits = digits % 10;
        int fourthDigit = digits;

        System.out.println (firstDigit + " " + secondDigit + " " + thirdDigit + " " + fourthDigit);
    }*/
}
