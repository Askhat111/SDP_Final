package adapter;

public interface DeliveryService {
    boolean scheduleDelivery(String orderId, String address, String instructions);
    String getDeliveryEstimate();
    double getDeliveryFee();
}