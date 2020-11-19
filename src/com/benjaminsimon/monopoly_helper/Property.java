package com.benjaminsimon.monopoly_helper;

public class Property {

    private final String name;
    private final double price;
    private final short fieldNumber;

    public Property(String nameIn, double priceIn, short fieldNumberIn){
        this.name = nameIn;
        this.price = priceIn;
        this.fieldNumber = fieldNumberIn;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public short getFieldNumber() {
        return fieldNumber;
    }

    @Override
    public int hashCode() {
        return this.fieldNumber + 13;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if(obj == null || !(obj instanceof Property))
            return false;

        return this.fieldNumber == ((Property) obj).getFieldNumber();
    }
}
