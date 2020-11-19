package com.benjaminsimon.monopoly_helper;

import java.util.HashSet;
import java.util.UUID;

public class BankAccount {

    private final UUID id = UUID.randomUUID();

    private double amount = 0d;
    private HashSet<Transaction> transactions = new HashSet<>();

    public BankAccount(double amountIn) {
        this.amount = amountIn;
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
