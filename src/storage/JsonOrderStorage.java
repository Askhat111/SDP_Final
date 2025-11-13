package storage;

import observer.Order;
import model.MenuItem;
import java.io.*;

public class JsonOrderStorage {
    public void saveOrder(Order order) {
        try {
            FileWriter writer = new FileWriter("order_" + order.getOrderId() + ".txt");
            writer.write("Order: " + order.getOrderId() + "\n");
            writer.write("Status: " + order.getStatus() + "\n");
            writer.write("Items:\n");

            for (MenuItem item : order.getItems()) {
                writer.write("  - " + item.getDescription() + " ($" + item.getBasePrice() + ")\n");
            }

            writer.close();
            System.out.println("Order saved to file");
        } catch (IOException e) {
            System.out.println("Error saving order: " + e.getMessage());
        }
    }
}