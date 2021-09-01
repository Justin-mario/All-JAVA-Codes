package com.PhoneBook;

import com.PhoneBook.exception.PhonebookException;

public class PhoneBookUser {
    private String name;
    private String number;
    private String email;
    private PhoneBook phoneBook;

    public PhoneBookUser(PhoneBook phoneBook, String user){
        this.phoneBook = phoneBook;
        name = user;

    }

    public void saveNumber(String name, String number, String email) {
        this.name = name;
        this.number = number;
        this.email = email;
        phoneBook.saveNumber ( name,number,email );


    }

    public String getNumber() throws PhonebookException {
        return phoneBook.getNumber ( "Ben" );
    }
}
