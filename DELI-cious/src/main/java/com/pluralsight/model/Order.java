package com.pluralsight.model;

import com.pluralsight.interfaceModel.Displayable;
import com.pluralsight.model.order.Chip;
import com.pluralsight.model.order.Drink;
import com.pluralsight.model.order.Sandwich;

import java.time.LocalDateTime;

public class Order implements Displayable {
    private int orderId;
    private LocalDateTime orderDate;
    private double totalCost = 0.0;


    public Order(int orderId, LocalDateTime orderDate, double totalCost) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.totalCost = totalCost;
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

    }
    public void addDrinks(Drink drinks) {

    }
    public void addChips(Chip chip) {

    }
    public double calculateTotalCost(){
        return 0.0;
    }
    public void displayOrderDetails(){

    }
    public void processTransaction(double customerTender, String paymentMethod){

    }

    @Override
    public String displayDetails() {
        return "";
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
