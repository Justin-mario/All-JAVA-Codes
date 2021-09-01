package com.PhoneBook;
import com.PhoneBook.exception.PhonebookException;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    Map<String, PhoneBookEntry> phonebook = new HashMap<> ();

    public void saveNumber(String userName,String mobileNumber, String email) {
        phonebook.put ( userName, new PhoneBookEntry ( mobileNumber, email ) );

    }


    public String getNumber(String name) throws PhonebookException {
        for (int i = 0; i < phonebook.size (); i++) {
            if (!phonebook.containsKey (name) ){
                throw new PhonebookException ("Name does not exist");
            }
            else if (phonebook.containsKey (name))
                return String.valueOf ( phonebook.get ( name ) );


        }
        return null;
    }

    public void deleteNumber(String name) {
//        for (int i = 0; i < phonebook.size (); i++) {
            phonebook.remove ( name );
//        }

    }

    public int getSize() {
        return phonebook.size ();
    }

    public void deleteAllNumber() {
        phonebook.clear ();
    }
}
