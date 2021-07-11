package com.CHAPTER_FOURTEEN.comparing_portions_of_string;

public class ComparingPortionsOfString {
    private String firstString;
    private String secondString;
    private boolean result;

    public void compareTwoString(String firstString, String secondString) {
        this.firstString = firstString;
        this.secondString = secondString;
        result = firstString.regionMatches ( true,0, secondString,0, 5);
    }

    public boolean getResult() {
        if (result){
            System.out.println ("Equal");
        }
        else
            System.out.println ("Not Equal");
        return result;
    }
}
