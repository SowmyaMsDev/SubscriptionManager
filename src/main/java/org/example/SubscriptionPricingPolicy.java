package org.example;

public interface SubscriptionPricingPolicy {

    public int getPrice(MonthlySubscription.PriceLevel level);
}
