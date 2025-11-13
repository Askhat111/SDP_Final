package adapter;

public class DeliveryAdapter implements DeliveryService {
    private static final double BASE_DELIVERY_FEE = 3.99;
    private static final int ESTIMATED_MINUTES = 45;

    @Override
    public boolean scheduleDelivery(String orderId, String address, String instructions) {
        System.out.println("🚚 Delivery scheduled for order: " + orderId);
        System.out.println("   Address: " + address);
        if (instructions != null && !instructions.isEmpty()) {
            System.out.println("   Instructions: " + instructions);
        }
        System.out.println("   Estimated delivery time: " + ESTIMATED_MINUTES + " minutes");
        return true;
    }

    @Override
    public String getDeliveryEstimate() {
        return ESTIMATED_MINUTES + " minutes";
    }

    @Override
    public double getDeliveryFee() {
        return BASE_DELIVERY_FEE;
    }
}