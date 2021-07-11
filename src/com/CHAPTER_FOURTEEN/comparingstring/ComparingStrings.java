package com.CHAPTER_FOURTEEN.comparingstring;

public class ComparingStrings {
    private String firstInput;
    private String secondInput;
    private int result;
    public void compareTwoString(String firstInput, String secondInput) {
        this.firstInput = firstInput;
        this.secondInput = secondInput;
        result = firstInput.compareTo ( secondInput );
    }

    public int getResult() {
        if (result == 0){
            System.out.println (firstInput + " is equal to " + secondInput);
        }
        else if (result < 0){
            System.out.println (firstInput + " is less than " + secondInput);
        }
        else
            System.out.println (firstInput + " is greater than " + secondInput);
        return result;
    }
}
