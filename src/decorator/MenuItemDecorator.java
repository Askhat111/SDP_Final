package decorator;

import model.MenuItem;
import visitor.Visitor;

public abstract class MenuItemDecorator implements MenuItem {
    protected MenuItem item;

    public MenuItemDecorator(MenuItem item) {
        this.item = item;
    }

    public String getName() { return item.getName(); }
    public double getBasePrice() { return item.getBasePrice(); }
    public String getDescription() { return item.getDescription(); }
    public void accept(Visitor visitor) { item.accept(visitor); }
}