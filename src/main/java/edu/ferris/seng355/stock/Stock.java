package edu.ferris.seng355.stock;

public record Stock(
        String name,
        double price,
        double priceIncreaseProbability,
        double possibleNewPrice
) {
}
