package com.CHAPTER_EIGHT.Account;

import java.math.BigDecimal;
import java.util.Scanner;

public class AccountDeposit {
    public static void main(String[] args) {
        Scanner input = new Scanner ( System.in );
        AccountWithBigDecimal account = new AccountWithBigDecimal ( "Gabriel", BigDecimal.valueOf ( 0.0 ) );

        System.out.print ("Enter Name Of Account Holder\t");
        String accountName = input.nextLine ();
        account.setAccountName ( accountName );
        String name = account.getAccountName ();
        System.out.print ("Enter Amount To Deposit\t");
        BigDecimal depositAmount = input.nextBigDecimal ();
        account.deposit ( depositAmount );
        BigDecimal balance = account.getBalance ();

        System.out.println ( name + "\tDeposited\t" + depositAmount + "\tAccount Balance\t" + balance);
    }
}
