package com.PhoneBook;

import com.PhoneBook.exception.PhonebookException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {
    PhoneBook phoneBook;
    @BeforeEach
        void setUp(){
        phoneBook = new PhoneBook ();
    }
    @Test
        void checkPhoneBookCanSaveNumber(){
        assertNotNull ( phoneBook );
        assertEquals ( 0, phoneBook.getSize () );
        phoneBook.saveNumber("John", "080378499", "john@yahoomail.com");
        phoneBook.saveNumber("Ben", "08137849909", "ben@yahoomail.com");
        assertEquals ( 2, phoneBook.getSize () );
        try {
            assertEquals ("08137849909", phoneBook.getNumber("Ben") );
        } catch (PhonebookException e) {
            e.printStackTrace ();
        }
    }

    @Test
        void checkPhoneCanDeleteNumber(){
        phoneBook.saveNumber("John", "080378499", "john@yahoomail.com");
        phoneBook.saveNumber("Ben", "08137849909", "ben@yahoomail.com");
        phoneBook.deleteNumber("Ben");
        assertEquals ( 1,phoneBook.getSize() );
        assertThrows ( PhonebookException.class, ()->phoneBook.getNumber ( "Ben" )  );

    }

    @Test
    void checkNumberOfEntryCanBeObtained(){
        phoneBook.saveNumber("John", "08037849999", "john@yahoomail.com");
        phoneBook.saveNumber("Ben", "08137849909", "ben@yahoomail.com");
        phoneBook.saveNumber("makana", "05078384990", "maka@yahoomail.com");
        phoneBook.saveNumber("Amaka", "0906754321", "amaka4love@yahoomail.com");
        phoneBook.saveNumber("Isaac", "08067849911", "isaac@yahoomail.com");
        phoneBook.saveNumber("Chris", "08137899909", "ben@yahoomail.com");
      assertEquals (6, phoneBook.getSize ());
    }

    @Test
        void checkAllEntryCanBeDeleted(){
        phoneBook.saveNumber("John", "08037849999", "john@yahoomail.com");
        phoneBook.saveNumber("Ben", "08137849909", "ben@yahoomail.com");
        phoneBook.saveNumber("makana", "05078384990", "maka@yahoomail.com");
        phoneBook.saveNumber("Amaka", "0906754321", "amaka4love@yahoomail.com");
        phoneBook.saveNumber("Isaac", "08067849911", "isaac@yahoomail.com");
        phoneBook.saveNumber("Chris", "08137899909", "ben@yahoomail.com");
        phoneBook.deleteAllNumber();
        assertEquals ( 0,phoneBook.getSize () );
    }

}