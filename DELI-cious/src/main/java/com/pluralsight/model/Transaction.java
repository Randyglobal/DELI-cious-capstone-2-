package com.pluralsight.model;

import com.pluralsight.interfaceModel.Displayable;

import java.time.LocalDateTime;

public class Transaction implements Displayable {
    private static int nextId = 1;
    private int transactionId = 0;
    private double paidAmount = 0.0;
    private String paymentMethod = "";
    private double cashback = 0.0;
    private LocalDateTime transactionTime;
    private String status = "";

    public Transaction (int transactionId, double paidAmount, String paymentMethod, double cashback, LocalDateTime transactionTime, String status) {
        this.transactionId = nextId++;
        this.paidAmount = paidAmount;
        this.paymentMethod = paymentMethod;
        this.cashback = cashback;
        this.transactionTime = transactionTime;
        this.status = status;
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

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public String getStatus() {
        return status;
    }

    public boolean processPayment(Order order, double customerTender, String method){
        // Logic to process payment and update transaction status, paidAmount, cashback
        // This is where the calculation for cashback and setting status would happen.
        return false;
    }
    public double calculateCashback(double totalCost, double tenderAmount){
        // Logic to calculate the actual cashback/change
        return 0.0;
    }

    @Override
    public String displayDetails() {
//        structure results layout
        return "";
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
