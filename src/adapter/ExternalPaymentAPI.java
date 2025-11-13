package adapter;

public class ExternalPaymentAPI {
    public void makePayment(int cents, String merchant) {
        System.out.println("Processing payment of " + cents + " cents for " + merchant);
    }

    public boolean isSuccessful() {
        return true;
    }
}