package com.pluralsight.model.order;

import com.pluralsight.interfaceModel.Displayable;
import com.pluralsight.model.Order;

import java.time.LocalDateTime;

public class Drink implements Displayable {
    private String name;
    private double price;

    public Drink(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String displayDetails() {
        return "";
    }

    @Override
    public double getPrice() {
        return price;
    }
}
