package org.example;

public class Pricing2024 implements SubscriptionPricingPolicy {
    @Override
    public int getPrice(MonthlySubscription.PriceLevel level) {
        switch (level) {
            case Basic:
                return 10;
            case Standard:
                return 20;
            case Exclusive:
                return 30;
        }
        throw new IllegalArgumentException("Unsupported price level");
    }
}
