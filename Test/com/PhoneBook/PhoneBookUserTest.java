package com.PhoneBook;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookUserTest {
    @Test
    void userCanSaveNumber(){
        PhoneBook contactSaver = new PhoneBook ();
        PhoneBookUser user = new PhoneBookUser (contactSaver, "ben");
        user.saveNumber("John", "08037849999", "john@yahoomail.com");
        user.saveNumber("Ben", "08137849909", "ben@yahoomail.com");
        user.saveNumber("makana", "05078384990", "maka@yahoomail.com");
       // assertEquals ( "08137849909", user.getNumber("Ben") );
    }

}