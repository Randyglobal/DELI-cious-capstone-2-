package com.pluralsight.model.order;

import com.pluralsight.interfaceModel.Displayable;
import com.pluralsight.model.Order;
import com.pluralsight.model.order.drink.Topping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Sandwich implements Displayable {


    public enum sandwichSize {
        SIZE_4_INCHES(4),
        SIZE_8_INCHES(8),
        SIZE_12_INCHES(12);

        sandwichSize(int size) {
        }
    }
    public enum BreadType{
        WHITE, WHEAT, RYE, WRAP;
    }

    private final Sandwich size;
    private final BreadType bread;
    private boolean isToasted = false;
    private List<Topping> toppingList;

    public Sandwich(Sandwich size, BreadType bread, boolean isToasted) {
        this.size = size;
        this.bread = bread;
        this.isToasted = isToasted;
        this.toppingList = new ArrayList<>();
    }

    public Sandwich getSize() {
        return size;
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
    @Override
    public String displayDetails() {
        return "";
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
