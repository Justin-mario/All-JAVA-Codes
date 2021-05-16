package com.CHAPTER_FOUR;

import com.CHAPTER_FOUR.Encryption.Encryptor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EncryptorTest {
    @Test
    @DisplayName ( "Check User Can Input four integer" )
        void checkUserCanInputFourIntegerValue(){
        assertEquals (7842, Encryptor.getUserInput(7842));
    }

    @Test
    @DisplayName ( "Check Four digit has been encrypted" )
        void checkFourDigitHasBeenEncrypted(){
        assertEquals ( 1945,Encryptor.getEncryptedDigits(7842) );
    }
    @Test
    @DisplayName ( "Check encrypted digits has been decrypted" )
        void checkEncryptedDigitsCanBeDecrypted(){
       // assertEquals ( 7842, Encryptor.getDecryptedDigits(1945) );


    }
}