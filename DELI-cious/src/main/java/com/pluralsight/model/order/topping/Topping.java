package com.pluralsight.model.order.topping;

import com.pluralsight.model.order.Priceable;

public abstract class Topping implements Priceable {
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

    @Override
    public abstract  String displayDetails();
}
