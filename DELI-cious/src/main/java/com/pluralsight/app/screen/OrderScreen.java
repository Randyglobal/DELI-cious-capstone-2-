package com.pluralsight.app.screen;

import com.pluralsight.data.OrderManager;
import com.pluralsight.model.order.Order;

import java.util.Scanner;

public class OrderScreen {
    private static Order currentOrder;
    static Scanner scanner = new Scanner(System.in);
    public static void display(String message){
        System.out.println(message);
    }
    public static void displayOrderScreen(){
        currentOrder = new Order();
        display("\n -----  Starting New Order  ------");
        OrderManager.addCustomer();
        int choice;
        while (true){
            display("== Order Menu ==");
            display("1) - Add Sandwich");
            display("2) - Add Drink");
            display("3) - Add Chips");
            display("4) - Checkout");
            display("0) - Cancel Order");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    OrderManager.addSandwich();
                    break;
                case 2:
                    OrderManager.addDrink();
                    break;
                case 3:
                    OrderManager.addChips();
                    break;
                case 4:
                    OrderManager.checkout();
                    choice = 0;
                    break;
                case 0:
                    display("Order Cancelled with ID: " + currentOrder.getOrderId());
                    currentOrder = null;
                    break;
                default:
                    display("Invalid Order");
            }
        }
    }
}
