package model;

import visitor.Visitor;

public class DrinkItem implements MenuItem {
    private String id;
    private String name;
    private String category;
    private double price;
    private String description;
    private boolean alcoholic;
    private int size;

    public DrinkItem(String id, String name, String category, double price, String description, boolean alcoholic, int size) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
        this.alcoholic = alcoholic;
        this.size = size;
    }

    public String getName() { return name; }
    public double getBasePrice() { return price; }
    public String getDescription() { return description; }
    public boolean isAlcoholic() { return alcoholic; }
    public int getSizeInMl() { return size; }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}