package com.pluralsight.model.order;

import com.pluralsight.interfaceModel.Displayable;
import com.pluralsight.model.Order;

import java.time.LocalDateTime;

public class Chip implements Displayable {

    public enum ChipsSize{
        SMALL(1.50),
        MEDIUM(1.50),
        LARGE(1.50);
        private double price = 0.0;
        ChipsSize(double price){
            this.price = price;
        }
        public double getPrice(){
            return price;
        }
    }
    private String name;
    private ChipsSize size;

    public Chip(String name, ChipsSize size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public ChipsSize getSize(){
        return size;
    }

    @Override
    public String displayDetails() {
        return String.format("%s (%s) - $%.2f", name, size.name(), getPrice());
    }

    @Override
    public double getPrice() {
        return size.getPrice();
    }
}
