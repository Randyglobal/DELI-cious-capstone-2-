package com.pluralsight.model.order;

public class Drink implements Priceable {

    public enum DrinkSize{
        SMALL(2.00),
        MEDIUM(2.50),
        LARGE(3.00);
        private double price = 0;

        DrinkSize(double price){
            this.price = price;
        }
        public  double getPrice(){
            return  price;
        }
    }
    private String name;
    private DrinkSize size;

    public Drink(String name, DrinkSize size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }
    public DrinkSize getSize(){
        return size;
    }


    @Override
    public double getPrice() {
        return size.getPrice();
    }

    @Override
    public String displayDetails() {

        return String.format("%s (%s) - $%.2f", name, size.name(), getPrice());
    }
}
