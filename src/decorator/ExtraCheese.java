package decorator;

import model.MenuItem;
import visitor.Visitor;

public class ExtraCheese extends MenuItemDecorator {
    public ExtraCheese(MenuItem item) {
        super(item);
    }

    public String getDescription() {
        return item.getDescription() + " with extra cheese";
    }

    public double getBasePrice() {
        return item.getBasePrice() + 1.5;
    }

    public void accept(Visitor visitor) {
        super.accept(visitor);
        visitor.visit(this);
    }
}