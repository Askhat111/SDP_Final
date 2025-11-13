package visitor;

import model.FoodItem;
import model.DrinkItem;
import decorator.ExtraCheese;
import decorator.LargeSize;

public interface Visitor {
    void visit(FoodItem food);
    void visit(DrinkItem drink);
    void visit(ExtraCheese cheese);
    void visit(LargeSize large);
}