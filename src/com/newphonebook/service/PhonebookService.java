package com.newphonebook.service;

import com.PhoneBook.exception.PhonebookException;

public interface PhonebookService {
    void addContact(String name, String mobileNumber, String emailAddress, String address)throws PhonebookException;
    String getContact(String name)throws PhonebookException;
    Integer getPhonebookSize();
    void deleteAContact(String name) throws PhonebookException;
    void deleteAllContact()throws PhonebookException;
}
