package adapter;

public class PaymentAdapter implements PaymentProcessor {
    private ExternalPaymentAPI api;

    public PaymentAdapter(ExternalPaymentAPI api) {
        this.api = api;
    }

    public boolean processPayment(double dollars, String orderId) {
        int cents = (int)(dollars * 100);
        api.makePayment(cents, "RESTAURANT_" + orderId);
        return api.isSuccessful();
    }
}