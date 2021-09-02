package com.newphonebooktest;

import com.PhoneBook.exception.PhonebookException;
import com.newphonebook.model.PhonebookEntry;
import com.newphonebook.service.PhonebookServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhonebookServiceImplTest {
    PhonebookServiceImpl phonebookServiceImpl;
    @BeforeEach
    void setUp() {
        phonebookServiceImpl = new PhonebookServiceImpl ();
    }

    @AfterEach
    void tearDown() {
        phonebookServiceImpl = null;
        PhonebookEntry.tearDown ();
    }

    @Test
    void saveContact(){
        String contact = """
                name: Ken
                mobileNumber: 0813567892
                emailAddress: ken@gmail.com
                address: 128 Adeshola
                entryId: 1""";
        try {
            assertEquals ( 0, phonebookServiceImpl.getPhonebookSize () );
            assertNotNull ( phonebookServiceImpl );
            phonebookServiceImpl.addContact ("Ken", "0813567892", "ken@gmail.com",
                    "128 Adeshola");
            System.out.println (phonebookServiceImpl.getContact("Ken"));
            assertEquals (contact, phonebookServiceImpl.getContact("Ken")  );
        } catch (PhonebookException e) {
            e.printStackTrace ();
        }

        assertEquals ( 1, phonebookServiceImpl.getPhonebookSize () );

    }
    @Test
    void noTwoContactCanHaveTheSameName(){
        try {
            phonebookServiceImpl.addContact ("Ken", "0813567892", "ken@gmail.com", "128 Adeshola");
            phonebookServiceImpl.addContact("Ken", "0813567892", "ken@gmail.com", "128 Adeshola");
            phonebookServiceImpl.addContact("Ken", "04555567892", "kenube@gmail.com", "1280 Adeshola");
        } catch (PhonebookException e) {
            e.printStackTrace ();
        }
        assertEquals ( 1, phonebookServiceImpl.getPhonebookSize () );

    }

    @Test
    void deleteAContact(){
        assertEquals ( 0, phonebookServiceImpl.getPhonebookSize () );
        try {
            phonebookServiceImpl.addContact("Ken", "0813567892", "ken@gmail.com",
                    "128 Adeshola");
            phonebookServiceImpl.addContact("Jane", "0906785633", "jabe@yahoomail.com",
                    "4 kessignton avenue");
            phonebookServiceImpl.addContact("Ade", "04555567892", "ade4love@gmail.com",
                    "1280 Gerard Street");
            assertEquals ( 3, phonebookServiceImpl.getPhonebookSize () );
            phonebookServiceImpl.deleteAContact("Jane");
            assertEquals ( 2, phonebookServiceImpl.getPhonebookSize () );
            assertNull ( phonebookServiceImpl.getContact ( "Jane" ) );

        } catch (PhonebookException e) {
            e.printStackTrace ();
        }



    }

    @Test
    void deleteAllContact(){
        assertEquals ( 0, phonebookServiceImpl.getPhonebookSize () );
        try {
            phonebookServiceImpl.addContact("Ken", "0813567892", "ken@gmail.com",
                    "128 Adeshola");
            phonebookServiceImpl.addContact("Jane", "0906785633", "jabe@yahoomail.com",
                    "4 kessignton avenue");
            phonebookServiceImpl.addContact("Ade", "04555567892", "ade4love@gmail.com",
                    "1280 Gerard Street");
            assertEquals ( 3, phonebookServiceImpl.getPhonebookSize () );
            phonebookServiceImpl.deleteAllContact ();
            assertEquals ( 0, phonebookServiceImpl.getPhonebookSize () );
            assertNull ( phonebookServiceImpl.getContact ( "Ken" ) );

        } catch (PhonebookException e) {
            e.printStackTrace ();
        }


    }

    @Test
    void cannotDeleteAContactThatDoesNotExist(){
        assertEquals ( 0, phonebookServiceImpl.getPhonebookSize () );
        try {
            phonebookServiceImpl.addContact("Ken", "0813567892", "ken@gmail.com",
                    "128 Adeshola");
            phonebookServiceImpl.addContact("Jane", "0906785633", "jabe@yahoomail.com",
                    "4 kessignton avenue");
            phonebookServiceImpl.addContact("Ade", "04555567892", "ade4love@gmail.com",
                    "1280 Gerard Street");
            assertEquals ( 3, phonebookServiceImpl.getPhonebookSize () );


        } catch (PhonebookException e) {
            e.printStackTrace ();
        }
        assertThrows ( PhonebookException.class, ()->  phonebookServiceImpl.deleteAContact("Esther"));
        assertEquals ( 3, phonebookServiceImpl.getPhonebookSize () );
    }

    @Test
    void cannotDeleteAnEmptyContactList(){
        assertEquals ( 0, phonebookServiceImpl.getPhonebookSize () );
        assertThrows ( PhonebookException.class, () ->   phonebookServiceImpl.deleteAllContact());
        assertEquals ( 0, phonebookServiceImpl.getPhonebookSize () );
    }

    @Test
    void displayAllContact(){
        assertEquals ( 0, phonebookServiceImpl.getPhonebookSize () );
        try {
            phonebookServiceImpl.addContact("Ken", "0813567892", "ken@gmail.com",
                    "128 Adeshola");
            phonebookServiceImpl.addContact("Jane", "0906785633", "jabe@yahoomail.com",
                    "4 kessignton avenue");
            phonebookServiceImpl.addContact("Ade", "04555567892", "ade4love@gmail.com",
                    "1280 Gerard Street");
            assertEquals ( 3, phonebookServiceImpl.getPhonebookSize () );
            String contact = """
                name: Ken
                mobileNumber: 0813567892
                emailAddress: ken@gmail.com
                address: 128 Adeshola
                entryId: 1""";


        } catch (PhonebookException e) {
            e.printStackTrace ();
        }
    }
}