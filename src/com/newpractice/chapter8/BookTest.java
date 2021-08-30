package com.newpractice.chapter8;

import java.util.EnumSet;

public class BookTest {
    public static void main(String[] args) {

        for(Book book : Book.values ()){
            System.out.printf ( "%-10s %-45s%n ",
            book.getTitle (), book.getCopyRightYear ());
        }
        System.out.printf ( "%n%n" );
        for(Book book: EnumSet.range ( Book.IW3HTP,Book.VBHTP )){
            System.out.printf ( "%-10s %-45s%n", book.getTitle (), book.getCopyRightYear () );
        }
    }
}
