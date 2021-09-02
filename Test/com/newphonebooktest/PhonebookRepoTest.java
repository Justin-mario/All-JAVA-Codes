package com.newphonebooktest;

import com.PhoneBook.exception.PhonebookException;
import com.newphonebook.datastore.PhonebookRepo;
import com.newphonebook.model.PhonebookEntry;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PhonebookRepoTest {
    PhonebookRepo phonebook;
    @BeforeEach
    void setUp(){
        phonebook = new PhonebookRepo();

    }

    @AfterEach
    void tearDown(){
        PhonebookEntry.tearDown ();
    }

    @Test
    void saveContact(){
        try {
            assertEquals ( 0, phonebook.getSize () );
            assertNotNull ( phonebook );
            phonebook.save("Ken", "0813567892", "ken@gmail.com", "128 Adeshola");
        } catch (PhonebookException e) {
            e.printStackTrace ();
        }
        String contact = """
                name: Ken
                mobileNumber: 0813567892
                emailAddress: ken@gmail.com
                address: 128 Adeshola
                entryId: 1""";
        assertEquals ( 1, phonebook.getSize () );
        assertEquals (contact, phonebook.getContact("Ken")  );
    }

    @Test
    void noTwoContactCanHaveTheSameName(){
        try {
            phonebook.save("Ken", "0813567892", "ken@gmail.com", "128 Adeshola");
            phonebook.save("Ken", "0813567892", "ken@gmail.com", "128 Adeshola");
            phonebook.save("Ken", "04555567892", "kenube@gmail.com", "1280 Adeshola");
        } catch (PhonebookException e) {
            e.printStackTrace ();
        }
        assertEquals ( 1, phonebook.getSize() );

    }

    @Test
    void deleteAContact(){
        assertEquals ( 0, phonebook.getSize () );
        try {
            phonebook.save("Ken", "0813567892", "ken@gmail.com",
                    "128 Adeshola");
            phonebook.save("Jane", "0906785633", "jabe@yahoomail.com",
                    "4 kessignton avenue");
            phonebook.save("Ade", "04555567892", "ade4love@gmail.com",
                    "1280 Gerard Street");
            assertEquals ( 3, phonebook.getSize () );
            phonebook.deleteAContact("Jane");
            assertEquals ( 2, phonebook.getSize () );

        } catch (PhonebookException e) {
            e.printStackTrace ();
        }

        assertNull ( phonebook.getContact ( "Jane" ) );

    }

    @Test
    void deleteAllContact(){
        assertEquals ( 0, phonebook.getSize () );
        try {
            phonebook.save("Ken", "0813567892", "ken@gmail.com",
                    "128 Adeshola");
            phonebook.save("Jane", "0906785633", "jabe@yahoomail.com",
                    "4 kessignton avenue");
            phonebook.save("Ade", "04555567892", "ade4love@gmail.com",
                    "1280 Gerard Street");
            assertEquals ( 3, phonebook.getSize () );
            phonebook.deleteALLContact();
            assertEquals ( 0, phonebook.getSize () );

        } catch (PhonebookException e) {
            e.printStackTrace ();
        }
        assertNull ( phonebook.getContact ( "Ken" ) );

    }

    @Test
    void cannotDeleteAContactThatDoesNotExist(){
        assertEquals ( 0, phonebook.getSize () );
        try {
            phonebook.save("Ken", "0813567892", "ken@gmail.com",
                    "128 Adeshola");
            phonebook.save("Jane", "0906785633", "jabe@yahoomail.com",
                    "4 kessignton avenue");
            phonebook.save("Ade", "04555567892", "ade4love@gmail.com",
                    "1280 Gerard Street");
            assertEquals ( 3, phonebook.getSize () );


        } catch (PhonebookException e) {
            e.printStackTrace ();
        }
        assertThrows ( PhonebookException.class, ()->  phonebook.deleteAContact("Esther"));
        assertEquals ( 3, phonebook.getSize () );
    }

    @Test
    void cannotDeleteAnEmptyContactList(){
        assertEquals ( 0, phonebook.getSize () );
            assertThrows ( PhonebookException.class, () ->   phonebook.deleteALLContact());
            assertEquals ( 0, phonebook.getSize () );
    }

    @Test
    void displayAllContact(){
        assertEquals ( 0, phonebook.getSize () );
        try {
            phonebook.save("Ken", "0813567892", "ken@gmail.com",
                    "128 Adeshola");
            phonebook.save("Jane", "0906785633", "jabe@yahoomail.com",
                    "4 kessignton avenue");
            phonebook.save("Ade", "04555567892", "ade4love@gmail.com",
                    "1280 Gerard Street");
            assertEquals ( 3, phonebook.getSize () );
            String contact = """
                name: Ken
                mobileNumber: 0813567892
                emailAddress: ken@gmail.com
                address: 128 Adeshola
                entryId: 3""";
            assertEquals ( contact, phonebook.getAllContact());

        } catch (PhonebookException e) {
            e.printStackTrace ();
        }
    }
}
