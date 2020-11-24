package main.java.com.benjaminsimon.monopoly_helper;

import java.util.HashSet;

public class Player implements IMonetaryEntity {

    private BankAccount bankAccount = null;
    private String name = null;
    private String displayColor = null;
    private HashSet<Property> properties = new HashSet<Property>();

    public Player(String nameIn, String displayColorIn) {
        this.name = nameIn;
        this.displayColor = displayColorIn;
    }

    @Override
    public boolean pay(double amount) {
        return this.bankAccount.subtractAmount(amount);
    }

    @Override
    public boolean receive(double amount) {
        return this.bankAccount.addAmount(amount);
    }

    public double getAmmount() {
        return this.getBankAccount().getAmount();
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayColor() {
        return displayColor;
    }

    public void setDisplayColor(String displayColor) {
        this.displayColor = displayColor;
    }

    public HashSet<Property> getProperties() {
        return properties;
    }

    public void setProperties(HashSet<Property> properties) {
        this.properties = properties;
    }
}
