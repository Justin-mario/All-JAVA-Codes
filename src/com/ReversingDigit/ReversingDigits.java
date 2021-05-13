package com.ReversingDigit;

public class ReversingDigits {
    static int temporaryVariable;
    static int remainder;
    static int reversal;

    public static int getReversedDigits(int userInput) {
        temporaryVariable = userInput;

        while (temporaryVariable > 0) {
            remainder = temporaryVariable % 10;
            temporaryVariable /= 10;
            reversal = reversal * 10 + remainder;

        }
        System.out.println (userInput + "\twhen reversed is\t" + reversal);
        return reversal;
    }
}
