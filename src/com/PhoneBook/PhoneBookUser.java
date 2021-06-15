package com.PhoneBook;

public class PhoneBookUser {
    private String name;
    private String number;
    private String email;
    private PhoneBook phoneBook;

    public PhoneBookUser(PhoneBook phoneBook, String user){
        this.phoneBook = phoneBook;

    }

    public void saveNumber(String name, String number, String email) {
        this.name = name;
        this.number = number;
        this.email = email;


    }

    public String getNumber() {
        return phoneBook.getNumber ( "Ben" );
    }
}
