package edu.ferris.seng355;

public class Stock extends Item
 {

    double price;
    double priceIncreaseProbability;
    double possibleNewPrice;

    public Stock(double price, double priceIncreaseProbability, double possibleNewPrice) {
        this.price = price;
        this.possibleNewPrice = possibleNewPrice;
        this.priceIncreaseProbability = priceIncreaseProbability;
        setWeight(price);
        setValue(calculateStockValue());
    }

    private double calculateStockValue() {
        return (price - possibleNewPrice) * priceIncreaseProbability;
    }


}
