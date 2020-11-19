package com.benjaminsimon.monopoly_helper;

public interface IMonetaryEntity {

    double pay(IMonetaryEntity recipient, double amount);
    double receive(IMonetaryEntity sender, double amount);
}
