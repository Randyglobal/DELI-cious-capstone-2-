package com.pluralsight.model.order.drink.topping;

import com.pluralsight.model.order.drink.Topping;

public class PremiumTopping extends Topping {
    private boolean isExtra;

    public PremiumTopping(String name, double basePrice, boolean isExtra) {
        super(name, basePrice);
        this.isExtra = isExtra;
    }

    public boolean isExtra() {
        return isExtra;
    }

    @Override
    public String displayDetails() {
        return "";
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
