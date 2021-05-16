package com.CHAPTER_FOUR.Encryption;

import java.util.Scanner;

public class EncryptorApp {
    public static void main(String[] args) {
        Scanner input = new Scanner ( System.in );

        System.out.println ("Enter Four digit pin");
        int digits = input.nextInt ();
        int encryptedCode = Encryptor.getEncryptedDigits ( digits );
        System.out.println (encryptedCode);
    }
}
