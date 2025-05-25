package com.pluralsight.model.order;

import com.pluralsight.model.Order;

import java.time.LocalDateTime;

public class Sandwich extends Order {
    public enum sandwichSize {
        SIZE_4_INCHES(4),
        SIZE_8_INCHES(8),
        SIZE_12_INCHES(12);
        private final int size;
        sandwichSize(int size) {
            this.size = size;
        }
    }
    public enum BreadType{
        WHITE, WHEAT, RYE, WRAP;
    }

    private final Sandwich size;
    private final BreadType bread;
    private boolean isToasted = false;

    public Sandwich(int orderId, LocalDateTime orderDate, double totalCost, Sandwich size, BreadType bread, boolean isToasted) {
        super(orderId, orderDate, totalCost);
        this.size = size;
        this.bread = bread;
        this.isToasted = isToasted;
    }

    public Sandwich getSize() {
        return size;
    }

    public BreadType getBread() {
        return bread;
    }

    public boolean isToasted() {
        return isToasted;
    }
}
