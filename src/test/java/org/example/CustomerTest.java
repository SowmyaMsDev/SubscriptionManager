package org.example;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomerTest {

    /**
     * Pricing policy by these unit tests
     */
    private final SubscriptionPricingPolicy pricingPolicy = new Pricing2024();

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    /**
     * Convert a date string to a Date object
     *
     * @param dateString A date such as 20231225
     * @return the corresponding Date object
     */
    private Date toDate(String dateString) {
        try {
            return sdf.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Test
    void subscribeToNetflix() {
        final Customer sut = new Customer("JohnDoe");

        // When a customer subscribes to NetFlix basic plan
        assertTrue(sut.subscribe("netflix", toDate("20230501"), MonthlySubscription.PriceLevel.Basic));

        // Then the total price of the subscriptions of the customer should be the price of a basic plan
        assertEquals(pricingPolicy.getPrice(MonthlySubscription.PriceLevel.Basic), sut.getSubcriptionsTotalPrice(pricingPolicy));
    }

    @Test
    void subscribeToNetflixAndParamount() {
        final Customer sut = new Customer("JohnDoe");

        // When a customer subscribes to NetFlix basic plan starting in May and Paramount exclusive plan starting in September
        assertTrue(sut.subscribe("netflix", toDate("20230501"), MonthlySubscription.PriceLevel.Basic));
        assertTrue(sut.subscribe("paramount", toDate("20230905"), MonthlySubscription.PriceLevel.Exclusive));

        // Then the total price of the subscriptions of the customer should be the price of a basic plan + the price of a premium plan
        final int expectedTotalPrice = pricingPolicy.getPrice(MonthlySubscription.PriceLevel.Basic) + pricingPolicy.getPrice(MonthlySubscription.PriceLevel.Exclusive);
        assertEquals(expectedTotalPrice, sut.getSubcriptionsTotalPrice(pricingPolicy));


        // Then the total price of the subscriptions of the customer in July should be the price of a basic plan
        final Date beforeDate = toDate("20230701");
        final int expectedTotalPriceInJuly = pricingPolicy.getPrice(MonthlySubscription.PriceLevel.Basic);
        assertEquals(expectedTotalPriceInJuly, sut.getSubcriptionsTotalPriceBeforeDate(pricingPolicy, beforeDate));
    }

}