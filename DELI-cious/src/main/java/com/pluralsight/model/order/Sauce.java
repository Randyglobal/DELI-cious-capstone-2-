package com.pluralsight.model.order;

import com.pluralsight.model.order.topping.Topping;

public class Sauce extends Topping {

    public Sauce(String name, double basePrice) {
        super(name, basePrice);
    }

    @Override
    public String displayDetails() {
        return String.format("%s - $%.2f", getName(), getPrice());
    }

    @Override
    public double getPrice() {
        return getBasePrice();
    }
}
