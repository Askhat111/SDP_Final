package observer;

import model.MenuItem;
import java.util.*;

public class Order {
    private List<OrderObserver> observers = new ArrayList<>();
    private List<MenuItem> items = new ArrayList<>();
    private String orderId;
    private OrderStatus status;

    public Order() {
        this.orderId = "ORD-" + System.currentTimeMillis();
        this.status = OrderStatus.NEW;
    }

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void setStatus(OrderStatus newStatus) {
        this.status = newStatus;
        for (OrderObserver observer : observers) {
            observer.update(this);
        }
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public String getOrderId() { return orderId; }
    public OrderStatus getStatus() { return status; }
    public List<MenuItem> getItems() { return items; }
}