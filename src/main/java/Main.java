import bank.BankAccount;

public class Main {
    public static void main(String[] args) {


        BankAccount bankAccount = new BankAccount("Mr. Bryan Walton", 11.99);
        bankAccount.credit(5.77);
        bankAccount.debit(11.22);

        System.out.println("Current balance is " + bankAccount.getBalance());


        BankAccount bankAccountNegativeBalance = new BankAccount("Mr. Negative", -961);
        // Exception: negative balance
    }
}