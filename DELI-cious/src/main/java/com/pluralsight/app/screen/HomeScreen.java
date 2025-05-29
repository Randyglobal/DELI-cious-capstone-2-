package com.pluralsight.app.screen;

import java.util.Scanner;

public class HomeScreen {
    static Scanner scanner = new Scanner(System.in);
    public void display(String message){
        System.out.println(message);
    }
    public void displayHomeScreen(){
        int choice;
        boolean response = true;
        while (response){
            display("\n ------Welcome to DELI-cious Sandwich------");
            display("1) New Order");
            display("2) Exit");
            display("Enter Command:");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    OrderScreen.displayOrderScreen();
                    break;
                case 2:
                    display("Exiting app...........");
                    response = false;
            }
        }
    }
}
