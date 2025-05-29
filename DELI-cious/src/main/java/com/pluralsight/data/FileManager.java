package com.pluralsight.data;

import com.pluralsight.model.order.Order;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileManager {
//    Write and read in to the file or database
    private static DateTimeFormatter FILE_NAME = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
    public static  void display(String message){
        System.out.println(message);
    }
    public static void writeToFile(Order order){
        if (order == null || order.getOrderDate() == null){
            display("Server Error");
            return;
        }
        LocalDateTime orderDateTime = order.getOrderDate();
        String filename = "receipts" + File.separator + orderDateTime.format(FILE_NAME) + ".txt";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write(order.displayDetails());
            display("Receipt Saved!!");
            writer.close();
        }catch (IOException e){
            display("Invalid entry");
        }
    }
}
