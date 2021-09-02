package com.newphonebook.datastore;

import com.PhoneBook.exception.PhonebookException;
import com.newphonebook.model.PhonebookEntry;

import java.util.HashMap;
import java.util.Map;

public class PhonebookRepo {
    private String name;
    Map<String, PhonebookEntry> phonebook = new HashMap<> ();

    public void save(String name, String mobileNumber, String emailAddress, String address) throws PhonebookException {
        this.name = name;
        phonebook.put ( name, new PhonebookEntry (name , mobileNumber, emailAddress, address ) );
    }

    public String getContact(String name) {
        if(phonebook.containsKey ( name ))
       return String.valueOf ( phonebook.get ( name ) );
        return null;
    }

    public int getSize() {
        return phonebook.size ();
    }

    public void deleteAContact(String name) throws PhonebookException {
        if(phonebook.containsKey ( name )){
            phonebook.remove ( name );
        }
        else
            throw new PhonebookException ("Name Does not exist");
    }

    public void deleteALLContact() throws PhonebookException {
        if(phonebook.size () != 0)
        phonebook.clear ();
        else
            throw new PhonebookException ("Phonebook is Empty!");
    }

    public void tearDown(){
        phonebook = null;

    }

    public void updateAContact(String name, PhonebookEntry mobileNumber) {
        if(phonebook.containsKey ( name )){
            phonebook.replace ( name, mobileNumber);
        }
    }

    public PhonebookEntry getAllContact() {
        if (phonebook.size () != 0){
            for(int i = 0; i < phonebook.size (); i++){
                return    phonebook.get ( name );
            }

        }
        return null;
    }
}
