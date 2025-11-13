package observer;

public class CustomerApp implements OrderObserver {
    private String name;

    public CustomerApp(String name) {
        this.name = name;
    }

    public void update(Order order) {
        System.out.println("Customer " + name + ": Your order is " + order.getStatus());
    }
}