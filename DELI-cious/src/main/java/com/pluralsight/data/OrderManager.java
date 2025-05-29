package com.pluralsight.data;

import com.pluralsight.model.Transaction;
import com.pluralsight.model.order.*;
import com.pluralsight.model.order.topping.Cheese;
import com.pluralsight.model.order.topping.Meat;
import com.pluralsight.model.order.topping.RegularTopping;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderManager {
//    Write and read in to the file or database
    private static Scanner scanner = new Scanner(System.in);
    private static Order currentOrder = new Order();
//    constants that should be included in the Sandwich
    private static  String[] BREADTYPE = {"WHITE", "WHEAT", "RYE", "WRAP"};
    private static String[] MEAT_OPTION = {"Steak", "Ham", "Salami", "Roasted Beef", "Chicken", "Bacon"};
    private static String[] CHEESE_OPTION = {"American", "Provolone", "Cheddar", "Swiss", "Lays Classic", "Mozzarella"};
    private static String[]  REGULAR_TOPPING = {"Lettuce", "Peppers", "Onion", "Tomatoes", "Jalapenos", "Cucumbers", "Pickles", "Guacamole", "Mushrooms"};
    private static String[] SAUCES_OPTION = {"Mayo", "Mustard", "Ketchup", "Ranch", "Thousand Islands", "Vinaigrette"};
    private static String[] CHIPS_OPTIONS = {"Salt & Vinegar", "Barbecue", "Sour Cream & Onion", "Cheddar Jalapeño", "Classic Sea Salt"};
    private static String[] DRINK_OPTION = {"Coca-Cola", "Pepsi", "Sprite", "Orange Juice", "Water", "Apple Juice", "Lemonade", "Ice Tea"};

    public static  void display(String message){
        System.out.println(message);
    }

    public static  void addCustomer(){
        display("Please enter Customer name");
        String name = scanner.nextLine();
        Customer customer = new Customer(name);
        currentOrder.addCustomer(customer);
    }
    public static void addSandwich(){
        display("\n ----- Make your Sandwich-------");
//        initializing Sandwich
        Sandwich sandwich = new Sandwich(selectedSandwichSize(), selectedBreadTpe(), selectedToastedBread());

//        get meat topping
        addMeatTopping(sandwich);
//        get cheese topping
        addCheeseTopping(sandwich);
//        add Regular topping
        addRegularTopping(sandwich);
//        add sauce
        addSauce(sandwich);
//        adding Sandwich to order
        currentOrder.addSandwich(sandwich);
}
    private static Sandwich.SandwichSize selectedSandwichSize(){
        boolean result = true;
        int choice;
        while (result) {
            display("Selected Sandwich Size: ");
            display("1) - 4 Inches");
            display("2) - 8 Inches");
            display("3) - 12 Inches");
            display("0) - Skip");
            display("Enter Command: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                return Sandwich.SandwichSize.SIZE_4_INCHES;
            } else if (choice == 2) {
                return Sandwich.SandwichSize.SIZE_8_INCHES;
            } else if (choice == 3) {
                return Sandwich.SandwichSize.SIZE_12_INCHES;
            } else if (choice == 0) {
                return null;
            } else {
                display("Invalid Choice");
            }
        }
        return null;
    }
    private static Sandwich.BreadType selectedBreadTpe(){
        int choice;
        while (true){
            display("Select Bread Type: ");
            for (int i = 0; i < BREADTYPE.length; i++) {
                display( (i + 1) + ") " + BREADTYPE[i]);
            }
            display("0) - Skip");
            display("Enter Command: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice > 0 && choice <= BREADTYPE.length){
                return Sandwich.BreadType.valueOf(BREADTYPE[choice - 1]);
            } else if (choice == 0) {
                return null;
            }else {
                display("Invalid Choice");
            }
        }
    }
    private static boolean selectedToastedBread(){
        String toastedChoice;
        while (true){
            display("Do you want your bread toasted?");
            display("Enter Y(yes) or N(no)");
                toastedChoice = scanner.nextLine().trim().toLowerCase();
                if (toastedChoice.equalsIgnoreCase("yes") ||toastedChoice.equalsIgnoreCase("y")){
                    return true;
                }else if (toastedChoice.equalsIgnoreCase("no") || toastedChoice.equalsIgnoreCase("n")){
                    return false;
                }else {
                    display("Invalid response, Please enter either (Yes or No)");
                }
        }
    }
    private static void addMeatTopping(Sandwich sandwich){
        int meatTopping;
        while(true){
            display("Added some meat bro: ");
            for (int i = 0; i < MEAT_OPTION.length; i++) {
                display( (i + 1) + ") " + MEAT_OPTION[i]);
            }
            display("0) - Done ");
            display("Enter Command: ");

            try {
                meatTopping = scanner.nextInt();
                scanner.nextLine();

                if (meatTopping > 0 && meatTopping <= MEAT_OPTION.length) {
                    Meat meat = getMeat(sandwich, meatTopping);
                    sandwich.addTopping(meat);
                    display("Meat Added!!");
                } else if (meatTopping == 0) {
                    break;
                }else {
                    display("Invalid Input");
                }
            } catch (InputMismatchException e) {
                display("Invalid input");
                scanner.nextLine();
            }
        }
    }
//Extracted Method
    private static Meat getMeat(Sandwich sandwich, int meatTopping) {
        String meatName = MEAT_OPTION[meatTopping - 1];
        double meatPrice;
        boolean isExtra;

        int currentMeatCount = sandwich.getMeatCount();

        if (currentMeatCount == 0) {
            meatPrice = sandwich.getSize().getMeatPrice();
            isExtra = false;
        } else {
            meatPrice = sandwich.getSize().getExtraMeat();
            isExtra = true;
        }
        Meat meat = new Meat(meatName, meatPrice, isExtra);
        return meat;
    }

    private static void addCheeseTopping(Sandwich sandwich){
        int cheeseTopping;
        while (true){
            display("Add some cheese bro:  ");
            for (int i = 0; i < CHEESE_OPTION.length; i++) {
                display((i + 1) + ")" + CHEESE_OPTION[i]);
            }
            display("0) - Done");

            try {
                cheeseTopping = scanner.nextInt();
                scanner.nextLine();

                if (cheeseTopping > 0 && cheeseTopping <= CHEESE_OPTION.length) {
                    Cheese cheese = getCheese(sandwich, cheeseTopping);
                    sandwich.addTopping(cheese);
                    display("Cheese Added!");
                } else if (cheeseTopping == 0) {
                    break;
                }
            }catch (InputMismatchException e) {
                display("Invalid Input");
                scanner.nextLine();
            }
        }
    }
//Extracted Method
    private static Cheese getCheese(Sandwich sandwich, int cheeseTopping) {
        String cheeseName = CHEESE_OPTION[cheeseTopping - 1];
        double cheesePrice;
        boolean isExtra;

        int currentCheesePrice = sandwich.getCheeseCount();
        if (currentCheesePrice == 0) {
            cheesePrice = sandwich.getSize().getCheesePrice();
            isExtra = false;
        } else {
            cheesePrice = sandwich.getSize().getExtraCheese();
            isExtra = true;
        }
        Cheese cheese = new Cheese(cheeseName, cheesePrice, isExtra);
        return cheese;
    }

    private static void addRegularTopping(Sandwich sandwich) {
        int regularTopping;
        while (true){
            display(" Add Other Regular's for free");
                for (int i = 0; i < REGULAR_TOPPING.length; i++) {
                    display((1 + i) + ")" + REGULAR_TOPPING[i]);
                }
            display("0) - Done");
            display("Enter Command: ");
            try {
                regularTopping = scanner.nextInt();
                scanner.nextLine();
                if (regularTopping > 0 && regularTopping <= REGULAR_TOPPING.length) {
                    String regularName = REGULAR_TOPPING[regularTopping - 1];
                    RegularTopping regular = new RegularTopping(regularName, 0.0);
                    sandwich.addTopping(regular);
                    display("Regular Topping Added!");
                } else if (regularTopping == 0) {
                   break;
                }
            } catch (InputMismatchException e) {
                display("Invalid Input");
                scanner.nextLine();
            }
    }
    }
    private static void addSauce(Sandwich sandwich){
        int sauceTopping;
        while (true){
            display("Add Some Sauce: ");
            for (int i = 0; i < SAUCES_OPTION.length; i++) {
                 display((i + 1) + ")" + SAUCES_OPTION[i]);
            }
            display("0) - Done");
            display("Enter Command: ");

            try {
                sauceTopping = scanner.nextInt();
                scanner.nextLine();

                if (sauceTopping > 0 && sauceTopping <= SAUCES_OPTION.length){
                    String sauceName = SAUCES_OPTION[sauceTopping - 1];
                    Sauce sauce = new Sauce(sauceName, 0.0);
                    sandwich.addTopping(sauce);
                    display("Sauce Added!");
                } else if (sauceTopping == 0) {
                    break;
                }

            }catch (InputMismatchException e){
                display("Invalid Input");
                scanner.nextLine();
            }
        }
    }

    public static void addDrink(){
        display("--- Add Drink ----");
        int choice;
        Drink.DrinkSize selectedDrink = selectDrinkSize();
        if (selectedDrink == null){
            return;
        }
        while(true){
            display("Select your drink: ");
            for (int i = 0; i < DRINK_OPTION.length; i++) {
                display((1 + i) + ")" + DRINK_OPTION[i]);
            }
            display("0) - Done");
            display("Enter Command: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine();

                if (choice > 0 && choice <= DRINK_OPTION.length){
                    String drinkName = DRINK_OPTION[choice - 1];
                    Drink drink = new Drink(drinkName, selectedDrink);
                    display("Drink Added");
                    currentOrder.addDrink(drink);
                } else if (choice == 0) {
                    break;
                }
            }catch (InputMismatchException e){
                display("Invalid Input");
                scanner.nextLine();
            }
        }
    }
    private static Drink.DrinkSize selectDrinkSize(){
        int choice;
        while (true){
            display("Select Drink Size: ");
            display("1) - SMALL($2.00)");
            display("2) - MEDIUM($2.50)");
            display("3) - LARGE($3.00)");
            display("0) - Done");
            display("Enter Command: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 1){
                    return Drink.DrinkSize.SMALL;
                } else if (choice == 2) {
                    return Drink.DrinkSize.MEDIUM;
                } else if (choice == 3) {
                    return Drink.DrinkSize.LARGE;
                }else {
                    display("Invalid input");
                }

            }catch (InputMismatchException e){
                display("Invalid Input");
            }
        }
    }

    public static void addChips(){
        display("--- Add Chips ----");
        int choice;
        Chips.ChipsSize selectedChips = selectChipsSize();
        if (selectedChips == null){
            return;
        }
        while(true){
            display("Select your chips: ");
            for (int i = 0; i < CHIPS_OPTIONS.length; i++) {
                display((1 + i) + ")" + CHIPS_OPTIONS[i]);
            }
            display("0) - Done");
            display("Enter Command: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine();

                if (choice > 0 && choice <= CHIPS_OPTIONS.length){
                    String chipsName = CHIPS_OPTIONS[choice - 1];
                    Chips chips = new Chips(chipsName, selectedChips);
                    currentOrder.addChip(chips);
                    display("Chips Added");
                } else if (choice == 0) {
                    break;
                }
            }catch (InputMismatchException e){
                display("Invalid Input");
                scanner.nextLine();
            }
        }
    }
    private static Chips.ChipsSize selectChipsSize(){
        int choice;
        while (true){
            display("Select Chips Size: ");
            display("1) - SMALL($1.50)");
            display("2) - MEDIUM($1.50)");
            display("3) - LARGE($1.50)");
            display("0) - Done");
            display("Enter Command: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 1){
                    return Chips.ChipsSize.SMALL;
                } else if (choice == 2) {
                    return Chips.ChipsSize.MEDIUM;
                } else if (choice == 3) {
                    return Chips.ChipsSize.LARGE;
                }else {
                    display("Invalid input");
                }

            }catch (InputMismatchException e){
                display("Invalid Input");
            }
        }
    }

    public static void checkout(){
//        Save from the file manager
        if (currentOrder == null || currentOrder.getPrice() == 0.0){
            display("Sorry, no Item has been Added!!!");
            return;
        }
        display(currentOrder.displayDetails());
        display(String.format("Total: $%.2f", currentOrder.getPrice()));

        double customerTender;
        String paymentMethod;
        int choice;
        boolean response = true;
        while(response){
            display("1) - Confirm Order");
            display("2) - Cancel Order");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1){
                display("Enter Payment Method(CASH / CARD)");
                paymentMethod = scanner.nextLine().trim();
                if (paymentMethod.equalsIgnoreCase("Cash") || paymentMethod.equalsIgnoreCase("Card")){
                    display("Enter Amount: ");
                    try{
                        customerTender = scanner.nextInt();
                        scanner.nextLine();
                        if (customerTender < currentOrder.getPrice()){
                            display("Please, Amount entered is not correct, Enter Correct amount");
                            scanner.nextLine();
                        }else {
                            Transaction transaction = new Transaction(paymentMethod);
                            boolean checked = transaction.processPayment(currentOrder, customerTender);
                            if (checked){
                                display("------ Payment Successful!! --------");
                                display(currentOrder.displayDetails());
                                currentOrder.clearItems();
                                response = false;
//                                currentOrder = null;
                            }else{
                                display("------ Payment Failed!! -------");
                            }
                        }
                    }catch (InputMismatchException e){
                        display("Invalid Entry");
                    }
                }else {
                    display("Invalid Entry");
                }

            } else if (choice == 2) {
                if (currentOrder == null){
                    display("Sorry, no Item has been Added!!!");
                    return;
                }
                display("Are you sure you want to cancel order? (Y(yes)/N(no))");
                String orderResponse = scanner.nextLine();
                if (orderResponse.equalsIgnoreCase("y") || orderResponse.equalsIgnoreCase("yes")){
                    currentOrder.clearItems();
                    display("Order Cancelled");
                    response = false;
                }else {
                    response = true;
                }

            }
        }
    }
}
