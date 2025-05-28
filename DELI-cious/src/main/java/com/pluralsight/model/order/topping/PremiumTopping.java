package com.pluralsight.model.order.topping;

public class PremiumTopping extends Topping {
    private boolean isExtra;

    public PremiumTopping(String name, double Price, boolean isExtra) {
        super(name, Price);
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
        return super.getBasePrice();
    }
}
