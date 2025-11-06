public class Main {
    public static void main(String[] args) {
        Order order = new Order();
        order.subscribe(new Customer());
        order.subscribe(new Kitchen());
        order.updateStatus("Ordered");

        NewPayment payment = new SystemAdapter(new OldSystem());
        payment.pay(10000);
        order.updateStatus("Ready");
    }
}
