package com.pluralsight.userinterface;

import com.pluralsight.model.order.Sandwich;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class UserInterfaceTest {
     @Test
    @DisplayName("Test base price for sandwich size")
     public void testGetBasePrice(){
         assertEquals(5.50, Sandwich.SandwichSize.SIZE_4_INCHES.getBasePrice(), 0.001, "4-inch base price should be 5.50");
         assertEquals(7.00, Sandwich.SandwichSize.SIZE_8_INCHES.getBasePrice(), 0.001, "8-inch base price should be 7.00");
         assertEquals(5.50, Sandwich.SandwichSize.SIZE_12_INCHES.getBasePrice(), 0.001, "12-inch base price should be 8.50");
     }

    @Test
    @DisplayName("Test extra meat price")
    public void testGetExtraMeatPrice(){
        assertEquals(1.00, Sandwich.SandwichSize.SIZE_4_INCHES.getExtraMeat(), 0.001, "4-inch meat price should be 1.00");
        assertEquals(2.00, Sandwich.SandwichSize.SIZE_8_INCHES.getExtraMeat(), 0.001, "8-inch meat price should be 2.00");
        assertEquals(3.00, Sandwich.SandwichSize.SIZE_12_INCHES.getExtraMeat(), 0.001, "12-inch meat price should be 3.00");
    }
    @Test
    @DisplayName("Test extra cheese price")
    public void testGetExtraCheesePrice(){
        assertEquals(0.50, Sandwich.SandwichSize.SIZE_4_INCHES.getExtraMeat(), 0.001, "4-inch cheese price should be 0.50");
        assertEquals(1.00, Sandwich.SandwichSize.SIZE_8_INCHES.getExtraMeat(), 0.001, "8-inch cheese price should be 1.00");
        assertEquals(1.50, Sandwich.SandwichSize.SIZE_12_INCHES.getExtraMeat(), 0.001, "12-inch cheese price should be 1.50");
    }


}