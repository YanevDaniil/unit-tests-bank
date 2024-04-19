package bank;

import exception.AmountOutOfRangeException;
import exception.NegativeBalanceException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BankAccountTest {

    @Test
    public void debit_withValidAmount_updatesBalance() {

        // Arrange
        double beginBalance = 11.99;
        double debitAmount = 4.55;
        double expectedBalance = beginBalance - debitAmount;
        BankAccount bankAccount = new BankAccount("Mr. Bryan Walton", beginBalance);

        // Act
        bankAccount.debit(debitAmount);

        // Assertion
        double actualBalance = bankAccount.getBalance();
        Assertions.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void debit_whenAmountIsLessThanZero_shouldThrowAmountOutOfRange() {
        double beginBalance = 11.99;
        double debitAmount = -100;
        BankAccount bankAccount = new BankAccount("Mr. Bryan Walton", beginBalance);

        Assertions.assertThrows(AmountOutOfRangeException.class,
                () -> bankAccount.debit(debitAmount));
    }

    @Test
    public void debit_whenAmountIsMoreThanBalance_shouldThrowAmountOutOfRange() {
        double beginBalance = 11.99;
        double debitAmount = 12;
        BankAccount bankAccount = new BankAccount("Mr. Bryan Walton", beginBalance);

        Assertions.assertThrows(AmountOutOfRangeException.class,
                () -> bankAccount.debit(debitAmount));
    }

    @Test
    public void credit_withValidAmount_updatesBalance() {
        // Arrange
        double beginBalance = 11.99;
        double creditAmount = 22.56;
        double expectedBalance = beginBalance + creditAmount;
        BankAccount bankAccount = new BankAccount("Mr. Bryan Walton", beginBalance);

        // Act
        bankAccount.credit(creditAmount);

        // Assertion
        double actualBalance = bankAccount.getBalance();
        Assertions.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void credit_whenAmountIsLessThanZero_shouldThrowAmountOutOfRange() {
        double beginBalance = 11.99;
        double creditAmount = -34.54;
        BankAccount bankAccount = new BankAccount("Mr. Bryan Walton", beginBalance);

        Assertions.assertThrows(AmountOutOfRangeException.class,
                () -> bankAccount.credit(creditAmount));
    }

    /*
        @Test
        public void bankAccount_whenBalanceIsStringWithValueNull_shouldThrowNumberFormatException() {
            Assertions.assertThrows(NumberFormatException.class,
                    () -> new BankAccount("Mr. Bryan Walton", Double.parseDouble("null")));
        }
     */

    @Test
    public void balance_whenBalanceInitializationIsLessThanZero_shouldThrowNegativeBalance() {
        double negativeBalance = -999;

        Assertions.assertThrows(NegativeBalanceException.class,
                () -> new BankAccount("Mr. Bryan Walton", negativeBalance));
    }



    private final static PrintStream standardOut = System.out;
    private final static ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    @BeforeAll
    public static void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void balance_whenBalanceInitializationIsValid_shouldPrintSuccessful() {
        double validBalance = +200_437.48;

        new BankAccount("Mr. Bryan Walton", validBalance);

        Assertions.assertEquals("successful account creation\n", outputStreamCaptor.toString());
    }
}