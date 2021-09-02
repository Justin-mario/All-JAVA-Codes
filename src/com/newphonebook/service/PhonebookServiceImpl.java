package com.newphonebook.service;

import com.PhoneBook.exception.PhonebookException;
import com.newphonebook.datastore.PhonebookRepo;

public class PhonebookServiceImpl implements PhonebookService{
    PhonebookRepo phonebookRepo = new PhonebookRepo();
    @Override
    public void addContact(String name, String mobileNumber, String emailAddress, String address) throws PhonebookException {
        phonebookRepo.save ( name, mobileNumber, emailAddress, address );
    }

    @Override
    public String getContact(String name) throws PhonebookException {
        return phonebookRepo.getContact ( name );
    }

    @Override
    public Integer getPhonebookSize() {
       return phonebookRepo.getSize ();

    }

    @Override
    public void deleteAContact(String name) throws PhonebookException {
        phonebookRepo.deleteAContact ( name );

    }

    @Override
    public void deleteAllContact() throws PhonebookException {
        phonebookRepo.deleteALLContact ();
    }
}
