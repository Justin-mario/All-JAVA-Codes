package com.CHAPTER_EIGHT.Account;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AccountWithBigDecimalTest {
    @Test
        void checkAccountCanReceiveDeposit(){
        AccountWithBigDecimal account = new AccountWithBigDecimal ( "Michael", BigDecimal.valueOf ( 0.00 ));
        account.deposit( BigDecimal.valueOf ( 3000.00 ) );
        assertEquals (BigDecimal.valueOf (3000.0  ) ,account.getBalance());
    }

    @Test
        void checkAccountNameCanBeSet(){
        AccountWithBigDecimal account = new AccountWithBigDecimal ( "Michael", BigDecimal.valueOf ( 0.00 ));
        account.setAccountName("Michael");
        assertEquals ("Michael",account.getAccountName());
    }

    @Test
    void checkAccountCannotReceiveNegativeValueAsDeposit(){
        AccountWithBigDecimal account = new AccountWithBigDecimal ( "Michael", BigDecimal.valueOf ( 0.00 ));
        account.deposit( BigDecimal.valueOf ( -3000.00 ) );
        assertEquals (BigDecimal.valueOf (0.0  ) ,account.getBalance());
    }

}