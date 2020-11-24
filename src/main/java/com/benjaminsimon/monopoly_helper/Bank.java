package main.java.com.benjaminsimon.monopoly_helper;

public class Bank {

    private String name = null;
    private final Bank instance = new Bank("Bank");

    private Bank(String nameIn) {
        this.name = nameIn;
    }

    private void runTransaction(Player sender, Player recipient, String description, double amount) {
        final Transaction transaction = new Transaction(sender, recipient, description, amount);
        transaction.run();
        sender.getBankAccount().addTransaction(transaction);
        recipient.getBankAccount().addTransaction(transaction);
    }

    public String getName() {
        return name;
    }

    public Bank getInstance() {
        return instance;
    }
}
