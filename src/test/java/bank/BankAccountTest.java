package bank;

import exception.AmountOutOfRangeException;
import exception.NegativeBalanceException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class BankAccountTest {

    @Test
    public void balance_whenBalanceInitializationIsLessThanZero_shouldThrowNegativeBalance() {
        double negativeBalance = -999;

        Assertions.assertThrows(NegativeBalanceException.class,
                () -> new BankAccount("Mr. Bryan Walton", negativeBalance));
    }

    @Test
    public void balance_whenBalanceInitializationIsValid_shouldSetBalance() {
        double validBalance = 999;      // or double zeroBalance = 0
        BankAccount bankAccount = new BankAccount("Mr. Bryan Walton", validBalance);

        Assertions.assertEquals(validBalance, bankAccount.getBalance());
    }

    @Test
    public void debit_withValidAmount_shouldUpdateBalance() {

        double beginBalance = 11.99;
        double debitAmount = 11.99;
        double expectedBalance = beginBalance - debitAmount;
        BankAccount bankAccount = new BankAccount("Mr. Bryan Walton", beginBalance);

        bankAccount.debit(debitAmount);

        double actualBalance = bankAccount.getBalance();
        Assertions.assertEquals(expectedBalance, actualBalance);
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
    public void debit_whenAmountIsLessThanZero_shouldThrowAmountOutOfRange() {
        double beginBalance = 11.99;
        double debitAmount = -100;
        BankAccount bankAccount = new BankAccount("Mr. Bryan Walton", beginBalance);

        Assertions.assertThrows(AmountOutOfRangeException.class,
                () -> bankAccount.debit(debitAmount));
    }

    @Test
    public void debit_whenAmountIsEqualToZero_shouldThrowAmountOutOfRange() {
        double beginBalance = 11.99;
        double debitAmount = 0;
        BankAccount bankAccount = new BankAccount("Mr. Bryan Walton", beginBalance);

        Assertions.assertThrows(AmountOutOfRangeException.class,
                () -> bankAccount.debit(debitAmount));
    }

    @Test
    public void credit_whenAmountIsMoreThanZero_shouldUpdateBalance() {
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
    public void credit_whenAmountIsEqualToZero_shouldThrowAmountOutOfRange() {
        double beginBalance = 11.99;
        double creditAmount = 0;
        BankAccount bankAccount = new BankAccount("Mr. Bryan Walton", beginBalance);

        Assertions.assertThrows(AmountOutOfRangeException.class,
                () -> bankAccount.credit(creditAmount));
    }

    @Test
    public void credit_whenAmountIsLessThanZero_shouldThrowAmountOutOfRange() {
        double beginBalance = 11.99;
        double creditAmount = -34.54;
        BankAccount bankAccount = new BankAccount("Mr. Bryan Walton", beginBalance);

        Assertions.assertThrows(AmountOutOfRangeException.class,
                () -> bankAccount.credit(creditAmount));
    }
}