package strategy;

public class HappyHourStrategy implements PricingStrategy {
    public double calculatePrice(double basePrice) {
        return basePrice * 0.8;
    }
}