package factory;

import model.MenuItem;
import model.FoodItem;
import model.DrinkItem;

public class MenuItemFactory {
    public MenuItem createItem(String itemId) {
        switch (itemId.toUpperCase()) {
            case "PZ001": return new FoodItem("PZ001", "Margherita Pizza", "Pizza", 12.99, "Classic cheese pizza", 15);
            case "PZ002": return new FoodItem("PZ002", "Pepperoni Pizza", "Pizza", 14.99, "Pepperoni pizza", 18);
            case "BG001": return new FoodItem("BG001", "Classic Burger", "Burger", 9.99, "Beef burger", 12);
            case "BG002": return new FoodItem("BG002", "Cheeseburger", "Burger", 10.99, "Burger with cheese", 12);
            case "DR001": return new DrinkItem("DR001", "Coca-Cola", "Drink", 2.49, "Soft drink", false, 330);
            case "DR002": return new DrinkItem("DR002", "Orange Juice", "Juice", 3.49, "Fresh juice", false, 250);
            case "DS001": return new FoodItem("DS001", "Chocolate Cake", "Dessert", 5.99, "Chocolate cake", 5);
            case "DS002": return new FoodItem("DS002", "Cheesecake", "Dessert", 6.49, "New York cheesecake", 5);
            default: throw new IllegalArgumentException("Unknown item: " + itemId);
        }
    }
}