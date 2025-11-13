package model;

import visitor.Visitor;

public class FoodItem implements MenuItem {
    private String id;
    private String name;
    private String category;
    private double price;
    private String description;
    private int prepTime;

    public FoodItem(String id, String name, String category, double price, String description, int prepTime) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
        this.prepTime = prepTime;
    }

    public String getName() { return name; }
    public double getBasePrice() { return price; }
    public String getDescription() { return description; }
    public int getPreparationTime() { return prepTime; }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}