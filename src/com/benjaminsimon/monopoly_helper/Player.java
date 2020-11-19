package com.benjaminsimon.monopoly_helper;

import java.awt.*;
import java.util.HashSet;

public class Player implements IMonetaryEntity {

    private BankAccount bankAccount = null;
    private String name = null;
    private Color displayColor = null;
    private HashSet<Property> properties = new HashSet<Property>();

    public Player(String nameIn, Color displayColorIn) {
        this.name = nameIn;
        this.displayColor = displayColorIn;
    }

    @Override
    public double pay(IMonetaryEntity recipient, double amount) {
        return 0;
    }

    @Override
    public double receive(IMonetaryEntity sender, double amount) {
        return 0;
    }
}
