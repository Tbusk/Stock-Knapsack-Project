package edu.ferris.seng355;

public record Stock(
        double price,
        double priceIncreaseProbability,
        double possibleNewPrice
) {
}
