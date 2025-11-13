package visitor;

import model.FoodItem;
import model.DrinkItem;
import decorator.ExtraCheese;
import decorator.LargeSize;
import strategy.PricingStrategy;

public class PriceCalculatorVisitor implements Visitor {
    private double total = 0;
    private PricingStrategy strategy;

    public PriceCalculatorVisitor(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    public void visit(FoodItem food) {
        total += strategy.calculatePrice(food.getBasePrice());
    }

    public void visit(DrinkItem drink) {
        total += strategy.calculatePrice(drink.getBasePrice());
    }

    public void visit(ExtraCheese cheese) {
        total += strategy.calculatePrice(1.5);
    }

    public void visit(LargeSize large) {
        total += strategy.calculatePrice(2.0);
    }

    public double getTotal() {
        return total;
    }
}