package com.newpractice.chapter8;

public enum Book {
    JHTP("Java How To Program", "2015"),
    CHTP("How To Program", "2013"),
    IW3HTP("Internet & World Wide Web How to Program", "2012"),
    CPPHTP("C++ How to Program", "2014"),
    VBHTP("Visual Basic How to Program", "2014"),
    CSHARPHTP("Visual C# How to Program", "2014");

    private final String title;
    private final String copyRightYear;

    Book(String title, String copyRightYear) {
        this.title = title;
        this.copyRightYear = copyRightYear;
    }

    public String getTitle() {
        return title;
    }

    public String getCopyRightYear() {
        return copyRightYear;
    }


}
