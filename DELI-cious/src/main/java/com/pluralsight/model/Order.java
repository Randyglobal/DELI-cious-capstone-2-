package com.pluralsight.model;

import com.pluralsight.interfaceModel.Displayable;
import com.pluralsight.model.order.Chip;
import com.pluralsight.model.order.Drink;
import com.pluralsight.model.order.Sandwich;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Order implements Displayable {
    private int orderId;
    private LocalDateTime orderDate;
    private double totalCost = 0.0;

    private List<Sandwich> sandwiches;
    private List<Chip> chips;
    private List<Drink> drinks;
    private Transaction transaction;
    public Order(int orderId, LocalDateTime orderDate, double totalCost) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.totalCost = totalCost;
        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
    }

    public int getOrderId() {
        return orderId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void addSandwich(Sandwich sandwich) {
       this.sandwiches.add(sandwich);
    }
    public void addDrinks(Drink drinks) {
       this.drinks.add(drinks);
    }
    public void addChips(Chip chip) {
       this.chips.add(chip);
    }
    public double calculateTotalCost(){
        double calculatedAmount = 0.0;
        return calculatedAmount;
    }
    public void displayOrderDetails(){
//        Loop through lists and print details of each item, then transaction details
    }
    public void processTransaction(double customerTender, String paymentMethod){
      this.transaction = new Transaction(Transaction.getNextId(), transaction.getPaidAmount(), paymentMethod, transaction.getCashback(), transaction.getTransactionTime(), transaction.getStatus());
      this.transaction.processPayment(this,customerTender, paymentMethod);
      this.totalCost = calculateTotalCost();
    }

    @Override
    public String displayDetails() {
        return "";
    }

    @Override
    public double getPrice() {
        return this.totalCost;
    }
}
