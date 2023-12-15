package org.example;

import java.util.Date;

/**
 * A simple customer how can only subscribe to services
 */
public class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    /**
     * Customer subscribes to a new service on a monthly basis
     *
     * @param name       Service name
     * @param startDate  Start date of the subscription
     * @param priceLevel Subscription price level
     * @return
     */
    public boolean subscribe(String name, Date startDate, MonthlySubscription.PriceLevel priceLevel) {
        return true;
    }

    /**
     * Compute the total price of all customer's subscriptions
     *
     * @param policy Pricing policy
     * @return the total price the customer should pay each month
     */
    public int getSubcriptionsTotalPrice(SubscriptionPricingPolicy policy) {
        return 0;
    }

    /**
     * Compute the total price of all customer's subscriptions starting before a given date
     *
     * @param policy Pricing policy
     * @param before Subscription should start before this date
     * @return the total price the customer pays each month for the subscription starting before the given date
     */
    public int getSubcriptionsTotalPriceBeforeDate(SubscriptionPricingPolicy policy, Date before) {
        return 0;
    }

    public String getName() {
        return name;
    }
}
