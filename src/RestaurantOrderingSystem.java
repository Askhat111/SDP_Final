import factory.MenuItemFactory;
import model.MenuItem;
import decorator.ExtraCheese;
import decorator.LargeSize;
import observer.Order;
import observer.OrderStatus;
import observer.KitchenDisplay;
import observer.CustomerApp;
import strategy.HappyHourStrategy;
import visitor.PriceCalculatorVisitor;
import adapter.PaymentAdapter;
import adapter.ExternalPaymentAPI;
import storage.JsonOrderStorage;

import java.util.Scanner;

public class RestaurantOrderingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuItemFactory factory = new MenuItemFactory();
        JsonOrderStorage storage = new JsonOrderStorage();

        System.out.println("=== Restaurant Ordering System ===");

        Order order = new Order();
        order.addObserver(new KitchenDisplay());
        order.addObserver(new CustomerApp("John"));

        showSimpleMenu();

        boolean adding = true;
        while (adding) {
            System.out.print("Enter item ID (or 'done' to finish): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("done")) {
                adding = false;
                continue;
            }

            try {
                MenuItem item = factory.createItem(input);

                System.out.print("Add extra cheese? (y/n): ");
                if (scanner.nextLine().equalsIgnoreCase("y")) {
                    item = new ExtraCheese(item);
                }

                System.out.print("Make it large? (y/n): ");
                if (scanner.nextLine().equalsIgnoreCase("y")) {
                    item = new LargeSize(item);
                }

                order.addItem(item);
                System.out.println("Added: " + item.getDescription());

            } catch (Exception e) {
                System.out.println("Invalid item ID. Try PZ001, BG001, DR001");
            }
        }

        if (order.getItems().isEmpty()) {
            System.out.println("No items in order. Goodbye!");
            return;
        }

        processOrder(order, storage);
        scanner.close();
    }

    private static void showSimpleMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("Pizzas:");
        System.out.println("  PZ001 - Margherita Pizza - $12.99");
        System.out.println("  PZ002 - Pepperoni Pizza - $14.99");

        System.out.println("Burgers:");
        System.out.println("  BG001 - Classic Burger - $9.99");
        System.out.println("  BG002 - Cheeseburger - $10.99");

        System.out.println("Drinks:");
        System.out.println("  DR001 - Coca-Cola - $2.49");
        System.out.println("  DR002 - Orange Juice - $3.49");

        System.out.println("Desserts:");
        System.out.println("  DS001 - Chocolate Cake - $5.99");
        System.out.println("  DS002 - Cheesecake - $6.49");
        System.out.println();
    }

    private static void processOrder(Order order, JsonOrderStorage storage) {

        order.setStatus(OrderStatus.CONFIRMED);
        order.setStatus(OrderStatus.PREPARING);

        HappyHourStrategy discount = new HappyHourStrategy();
        PriceCalculatorVisitor priceCalculator = new PriceCalculatorVisitor(discount);

        for (MenuItem item : order.getItems()) {
            item.accept(priceCalculator);
        }

        double total = priceCalculator.getTotal();
        System.out.printf("\nTotal with Happy Hour discount: $%.2f\n", total);

        PaymentAdapter payment = new PaymentAdapter(new ExternalPaymentAPI());
        boolean paid = payment.processPayment(total, order.getOrderId());

        if (paid) {
            order.setStatus(OrderStatus.READY);
            order.setStatus(OrderStatus.COMPLETED);
            storage.saveOrder(order);
            System.out.println("Order completed! Thank you!");
        } else {
            order.setStatus(OrderStatus.CANCELLED);
            System.out.println("Payment failed. Order cancelled.");
        }
    }
}