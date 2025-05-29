package com.pluralsight.model.order;

public class Customer implements Priceable{

    //    Receipt Display starts
    private static final int RECEIPT_WIDTH = 40;

    private String centerText(String text) {
        if (text == null) text = "";
        if (text.length() >= RECEIPT_WIDTH) {
            return text;
        }
        int padding = (RECEIPT_WIDTH - text.length()) / 2;
        return " ".repeat(padding) + text + " ".repeat(RECEIPT_WIDTH - text.length() - padding);
    }

    private String createSeparator() {
        return "-".repeat(RECEIPT_WIDTH);
    }
    //    Receipt display ends
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return centerText("Customer Name: " + name);
    }

    @Override
    public String displayDetails() {
        return String.format("%s", getName());
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
