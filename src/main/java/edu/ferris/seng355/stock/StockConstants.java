package edu.ferris.seng355.stock;

import java.math.BigDecimal;

public final class StockConstants {

    // Stock Price
    public static final BigDecimal MINIMUM_STOCK_PRICE = BigDecimal.valueOf(1.00);
    public static final BigDecimal MAXIMUM_STOCK_PRICE = BigDecimal.valueOf(100.00D);

    // Stock Price Increase Probability
    public static final BigDecimal MINIMUM_STOCK_INCREASE_PROBABILITY = BigDecimal.valueOf(0.00D);
    public static final BigDecimal MAXIMUM_STOCK_INCREASE_PROBABILITY = BigDecimal.valueOf(1.00D);

    // Possible New Stock Price
    public static final BigDecimal MINIMUM_NEW_STOCK_PRICE = BigDecimal.valueOf(1.00);
    public static final BigDecimal MAXIMUM_NEW_STOCK_PRICE = BigDecimal.valueOf(200.00D);

    private StockConstants(){}
}
