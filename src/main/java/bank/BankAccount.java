package bank;

import exception.AmountOutOfRangeException;
import exception.NegativeBalanceException;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
public class BankAccount {
    private String userName;
    private double balance;

    public BankAccount(String userName, double balance) {
        this.userName = userName;
        this.balance = balance;

        checkNegativeBalance();
        successfulAccountCreation();
    }

    public void debit(double amount) {
        if (amount > balance) throw new AmountOutOfRangeException("amount > balance");
        if (amount < 0) throw new AmountOutOfRangeException("amount < 0");
        balance -= amount;
    }
    public void credit(double amount) {
        if (amount < 0) throw new AmountOutOfRangeException("amount < 0");
        balance += amount;
    }

    private void checkNegativeBalance() {
        if (balance < 0) throw new NegativeBalanceException("negative balance");
    }

    private void successfulAccountCreation() {
        System.out.print("successful account creation\n");
    }
}