package com.pluralsight.model.order.topping;

public class RegularTopping extends Topping {

    public RegularTopping(String name, double basePrice) {
        super(name, basePrice);
    }

    @Override
    public double getPrice() {
        return getBasePrice();
    }

    @Override
    public String displayDetails() {
        return String.format("%s $%.2f", getName(), getPrice());
    }
}
