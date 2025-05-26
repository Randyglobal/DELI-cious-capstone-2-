package com.pluralsight.model.order.drink.topping;

import com.pluralsight.model.order.drink.Topping;

public class PremiumTopping extends Topping {
    private boolean isExtra = true;

    public PremiumTopping(String name, double basePrice, boolean isExtra) {
        super(name, basePrice);
        this.isExtra = isExtra;
    }

    public boolean isExtra() {
        return isExtra;
    }

    @Override
    public String displayDetails() {
        return String.format("%s (Premium%s) - $%.2f", getName(), isExtra ? "Extra" : "", getPrice());
    }

    @Override
    public double getPrice() {
        double price = getBasePrice();
        if (isExtra){
            price += 1.00; //this is an example
        }
        return price;
    }
}
