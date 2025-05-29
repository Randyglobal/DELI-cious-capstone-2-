package com.pluralsight.model;

import com.pluralsight.model.order.Order;
import com.pluralsight.model.order.Priceable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaction implements Priceable {
    //    Receipt Display starts
    private static final int RECEIPT_WIDTH = 40; // Use same width as Order/Sandwich

    private String centerText(String text) {
        if (text == null) text = "";
        if (text.length() >= RECEIPT_WIDTH) {
            return text;
        }
        int padding = (RECEIPT_WIDTH - text.length()) / 2;
        return " ".repeat(padding) + text + " ".repeat(RECEIPT_WIDTH - text.length() - padding);
    }
    //    Receipt display ends
    private static int nextId = 1;
    private static int transactionId;
    private double paidAmount = 0.0;
    private String paymentMethod = "";
    private double cashback = 0.0;
    private LocalDate transactionTime;
    private String status = "";

    public Transaction (String paymentMethod) {
        this.transactionId = nextId++;
        this.paymentMethod = paymentMethod;
        this.transactionTime = LocalDate.now();
        this.status = "NOT PAID";
        this.paidAmount = 0.0;
        this.cashback = 0.0;
    }

    public static int getTransactionId() {
        return transactionId;
    }

    public static int getNextId() {
        return nextId;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public double getCashback() {
        return cashback;
    }

    public LocalDate getTransactionTime() {
        return transactionTime;
    }

    public String getStatus() {
        return status;
    }

    public boolean processPayment(Order order, double customerTender){
        // Logic to process payment and update transaction status, paidAmount, cashback
        // This is where the calculation for cashback and setting status would happen.
        double orderTotal = order.getPrice();
        if (customerTender >= orderTotal){
            this.paidAmount = customerTender;
            this.cashback = customerTender - orderTotal;
            this.status = "PAID";
            order.setTransaction(this);
            return true;
        }else{
            this.paidAmount = customerTender;
            this.cashback = 0.0;
            this.status = "FAILED";
            return false;
        }
    }
    public double calculateCashback(double totalCost, double tenderAmount){
        // Logic to calculate the actual cashback/change
        return tenderAmount - totalCost;
    }

    @Override
    public String displayDetails() {
//        structure results layout
        StringBuilder details = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Time only for payment detail

        details.append(String.format("  %-25s%14.2f\n", "Amount Tendered:", paidAmount));
        details.append(String.format("  %-25s%14.2f\n", "Cashback:", cashback));
        details.append(String.format("  %-25s%14s\n", "Payment Method:", paymentMethod));
        details.append(String.format("  %-25s%14s\n", "Status:", status));
        details.append(String.format("  %-25s%14s\n", "Time:", transactionTime.format(formatter)));
        return details.toString();
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
