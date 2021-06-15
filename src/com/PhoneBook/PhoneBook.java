package com.PhoneBook;

import java.util.ArrayList;

public class PhoneBook {
    ArrayList<PhoneBookEntry> phonebook = new ArrayList<> ();


    public void saveNumber(String name, String mobile, String email) {
        phonebook.add ( new PhoneBookEntry ( name,mobile,email ) );
    }


    public String getNumber(String name){
        for (int i = 0; i < phonebook.size (); i++) {
            if(phonebook.get ( i ).getName ().equals ( name ))
                return phonebook.get ( i ).getMobile ();
        }
        return null;
    }

    public void deleteNumber(String name) {
        for (int i = 0; i < phonebook.size (); i++) {
            if(phonebook.get ( i ).getName ().equals ( name ))
                phonebook.remove ( i );
        }

    }

    public int getSize() {
        return phonebook.size ();
    }

    public void deleteAllNumber() {
        phonebook.clear ();
    }
}
