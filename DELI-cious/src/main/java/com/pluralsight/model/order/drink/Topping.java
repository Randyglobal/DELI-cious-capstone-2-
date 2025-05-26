package com.pluralsight.model.order.drink;

import com.pluralsight.interfaceModel.Displayable;

public abstract class Topping implements Displayable {
    private String name = "";
    private double basePrice = 0.0;

    public Topping(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }
}
