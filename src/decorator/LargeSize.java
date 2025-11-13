package decorator;

import model.MenuItem;
import visitor.Visitor;

public class LargeSize extends MenuItemDecorator {
    public LargeSize(MenuItem item) {
        super(item);
    }

    public String getDescription() {
        return "Large " + item.getDescription();
    }

    public double getBasePrice() {
        return item.getBasePrice() + 2.0;
    }

    public void accept(Visitor visitor) {
        super.accept(visitor);
        visitor.visit(this);
    }
}