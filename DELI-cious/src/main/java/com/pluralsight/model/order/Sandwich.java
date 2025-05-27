package com.pluralsight.model.order;

import com.pluralsight.interfaceModel.Displayable;
import com.pluralsight.model.order.drink.Topping;
import com.pluralsight.model.order.drink.topping.Cheese;
import com.pluralsight.model.order.drink.topping.Meat;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements Displayable {
//    display receipt width
    private static final int RECEIPT_WIDTH = 40;
    // Helper method to center text for the display
    private String centerText(String text) {
        if (text == null) text = "";
        if (text.length() >= RECEIPT_WIDTH) {
            return text; // If text is too long, don't center
        }
        int padding = (RECEIPT_WIDTH - text.length()) / 2;
        return " ".repeat(padding) + text + " ".repeat(RECEIPT_WIDTH - text.length() - padding);
    }

    // Helper method for a separator line
    private String createSeparator() {
        return "-".repeat(RECEIPT_WIDTH);
    }

    public enum sandwichSize {
//        defining enums for sandwichSize
        SIZE_4_INCHES(4, 5.50),
        SIZE_8_INCHES(8, 7.00),
        SIZE_12_INCHES(12, 8.50);

        private int size = 0;
        private double basePrice = 0.0;

        sandwichSize(int size, double basePrice) {
            this.size = size;
            this.basePrice = basePrice;
        }
        public double getBasePrice(){return basePrice;}
        public int getSize() {
            return size;
        }
//        Logic if customer selects Premium for breadSize
        public double getMeatPrice(){
            if (this == SIZE_4_INCHES){
                return 1.00;
            }
            if (this == SIZE_8_INCHES){
                return 2.00;
            }
            if (this == SIZE_12_INCHES){
                return 3.00;
            }
            return 0.0;
        }
        public double getExtraMeat(){
            if (this == SIZE_4_INCHES){
                return 0.50;
            }
            if (this == SIZE_8_INCHES){
                return 1.00;
            }
            if (this == SIZE_12_INCHES){
                return 1.50;
            }
            return 0.0;
        }
        public double getCheesePrice(){
            if (this == SIZE_4_INCHES){
                return 0.75;
            }
            if (this == SIZE_8_INCHES){
                return 1.50;
            }
            if (this == SIZE_12_INCHES){
                return 2.25;
            }
            return 0.0;
        }
        public double getExtraCheese(){
            if (this == SIZE_4_INCHES){
                return 0.30;
            }
            if (this == SIZE_8_INCHES){
                return 0.60;
            }
            if (this == SIZE_12_INCHES){
                return 0.90;
            }
            return  0.0;
        }
    }
//    Define enum for breadType
    public enum BreadType{
        WHITE, WHEAT, RYE, WRAP;
    }

    private final sandwichSize size;
    private final BreadType bread;
    private boolean isToasted = false;
    private List<Topping> toppingList;


//Constructor for sandwich class
    public Sandwich(sandwichSize size, BreadType bread, boolean isToasted) {
        this.size = size;
        this.bread = bread;
        this.isToasted = isToasted;
        this.toppingList = new ArrayList<>();
    }

    public BreadType getBread() {
        return bread;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void addTopping(Topping topping){
//        Logic to add topping
        this.addTopping(topping);
    }
    public List<Topping> getToppings(){
//        return toppingList
//        defensive copying
        return new ArrayList<>(toppingList);
    }

    @Override
    public String displayDetails() {
        StringBuilder details = new StringBuilder();

        // --- Sandwich Header ---
        details.append(centerText("--- SANDWICH ---")).append("\n");
        details.append(createSeparator()).append("\n");
        details.append(centerText(String.format("%d\" %s Bread", size.getSize(), bread))).append("\n");
        details.append(centerText(String.format("Toasted: %b", isToasted))).append("\n");
        details.append(createSeparator()).append("\n");

        // --- Base Price ---
        details.append(String.format("%-25s%14.2f\n", "Base Price (Bread):", size.getBasePrice()));

        // --- Toppings ---
        if (!toppingList.isEmpty()) {
            details.append(centerText("--- TOPPINGS ---")).append("\n");
            for (Topping topping : toppingList) {
                // Each topping's displayDetails should be a single line for this to format well
                // We'll format it as "Item Name       $Price"
                String toppingLine = topping.displayDetails(); // Assuming t.displayDetails() returns "Name - $X.XX"
                // Extract name and price if needed for specific formatting, or just use it as is
                details.append(String.format("  %-30s\n", toppingLine)); // Indent and left-align topping details
            }
            details.append(createSeparator()).append("\n");
        } else {
            details.append(centerText("No Toppings Added")).append("\n");
            details.append(createSeparator()).append("\n");
        }

        // --- Total Sandwich Price ---
        details.append(String.format("%-25s%14.2f\n", "Sandwich Total:", getPrice()));
        details.append(createSeparator()).append("\n");

        return details.toString();
    }

    @Override
    public double getPrice() {
        double calculatedPrice = size.getBasePrice();
        int meatCount = 0;
        int cheeseCount = 0;
        for (Topping topping : toppingList){
            if (topping instanceof Meat){
                meatCount++;
                if (meatCount == 1){
                    calculatedPrice += size.getMeatPrice();
                } else {
                    calculatedPrice += size.getExtraMeat();
                }
            } else if (topping instanceof Cheese) {
                cheeseCount ++;
                if (cheeseCount == 1){
                    calculatedPrice += size.getCheesePrice();
                }else {
                    calculatedPrice += size.getExtraCheese();
                }
            }else {
//                if non of them i an instance
                calculatedPrice += topping.getPrice();
            }
        }
        return calculatedPrice;
    }
}
