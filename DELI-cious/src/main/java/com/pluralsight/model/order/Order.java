package com.pluralsight.model.order;

import com.pluralsight.model.Transaction;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order implements Priceable {
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

    private int orderId = 1;
//    private static int nextOrderId = 0;
    private final LocalDateTime orderDate;
    private  List<Priceable> items;
    private List<Customer> customer;
    private Transaction transaction;
    public Order() {
        this.orderId = orderId++;
        this.orderDate = LocalDateTime.now();
        this.items = new ArrayList<>();
        this.customer = new ArrayList<>();
    }

    public int getOrderId() {
        return orderId;
    }

    public LocalDateTime getOrderDate() {

        return orderDate;
    }

    public void addCustomer(Customer customer){
        if (customer != null){
            this.customer.add(customer);
        }
    }

    public void addSandwich(Sandwich sandwich) {
        if (sandwich != null){
            this.items.add(sandwich);
        }
    }
    public void addDrink(Drink drink) {
       if (drink != null){
           this.items.add(drink);
       }
    }
    public void addChip(Chips chips) {
       if (chips != null){
           this.items.add(chips);
       }
    }
    public boolean removeItem(Priceable item){
        return this.items.remove(item);
    }
    public void clearItems(){
        this.items.clear();
    }
    public Transaction getTransaction(){
        return transaction;
    }
    public void setTransaction(Transaction transaction){
        this.transaction = transaction;
    }

    @Override
    public double getPrice() {
        double totalCost = 0.0;
        for (Priceable item : items){
            totalCost += item.getPrice();
        }
        return totalCost;
    }

    @Override
    public String displayDetails() {
        StringBuilder details = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        details.append(centerText("--- DELI-cious ORDER ---")).append("\n");
        details.append(createSeparator()).append("\n");
//        details.append(centerText(String.format("Order ID: %d", getOrderId()))).append("\n");
        for (Customer customer: customer){
            details.append("  ").append(customer.displayDetails()).append("\n");
        }
        details.append(centerText(String.format("Date: %s", orderDate.format(formatter)))).append("\n");
        details.append(createSeparator()).append("\n");

        if (items.isEmpty()) {
            details.append(centerText("No Items in Order")).append("\n");
            details.append(createSeparator()).append("\n");
        } else {
            details.append(centerText("--- ITEMS ---")).append("\n");
            for (Priceable item : items) {
                details.append("  ").append(item.displayDetails()).append("\n");
            }
            details.append(createSeparator()).append("\n");
        }

        details.append(String.format("$%-25s%14.2f\n", "TOTAL:", getPrice()));
        details.append(createSeparator()).append("\n");

        // Display transaction details if a transaction exists
        if (transaction != null) {
            details.append(centerText("--- PAYMENT DETAILS ---")).append("\n");
            // Transaction also uses displayDetails()
            details.append(transaction.displayDetails()).append("\n");
            details.append(createSeparator()).append("\n");
        }


        details.append(centerText("THANK YOU FOR YOUR ORDER!")).append("\n");
        details.append(createSeparator()).append("\n");

        return details.toString();
    }
}
