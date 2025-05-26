package com.pluralsight.model.order.drink.topping;

import com.pluralsight.model.order.drink.Topping;

public class RegularTopping extends Topping {
    private boolean isExtra = true;

    public RegularTopping(String name, double basePrice, boolean isExtra) {
        super(name, basePrice);
        this.isExtra = isExtra;
    }

    public boolean isExtra() {
        return isExtra;
    }

    @Override
    public String displayDetails() {
        return String.format("%s (Regular%s) - $$%.2f", getName(), isExtra? "Extra" : "", getPrice());
    }

    @Override
    public double getPrice() {
        return getBasePrice();
    }
}
