package org.example;

import java.util.Date;

/**
 * A month based subscription
 */
public class MonthlySubscription {


    private final String name;
    private final Date startDate;
    private final PriceLevel priceLevel;

    public MonthlySubscription(String name, Date startDate, PriceLevel priceLevel) {
        this.name = name;
        this.startDate = startDate;
        this.priceLevel = priceLevel;
    }

    public String getName() {
        return name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public PriceLevel getPriceLevel() {
        return priceLevel;
    }
    /**
     * The price level of the month subscription
     */
    public enum PriceLevel {
        Basic,
        Standard,
        Exclusive
    }
}
