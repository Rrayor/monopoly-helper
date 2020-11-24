package main.java.com.benjaminsimon.monopoly_helper;

import java.util.HashSet;
import java.util.UUID;

public class BankAccount {

    private final UUID id = UUID.randomUUID();

    private double amount = 0d;
    private final HashSet<Transaction> transactions = new HashSet<>();

    public BankAccount(double amountIn) {
        this.amount = amountIn;
    }

    public boolean subtractAmount(double amount) {
        if(this.amount - amount < 0)
            return false;

        this.amount -= amount;
        return true;
    }

    public boolean addAmount(double amount) {
        this.amount += amount;
        return true;
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public UUID getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public HashSet<Transaction> getTransactions() {
        return transactions;
    }
}
