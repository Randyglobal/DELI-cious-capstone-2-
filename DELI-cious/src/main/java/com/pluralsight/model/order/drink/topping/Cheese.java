package com.pluralsight.model.order.drink.topping;

import com.pluralsight.model.order.drink.Topping;

public class Cheese extends PremiumTopping {

    public Cheese(String name, double basePrice, boolean isExtra) {
        super(name, basePrice, isExtra);
    }
}
