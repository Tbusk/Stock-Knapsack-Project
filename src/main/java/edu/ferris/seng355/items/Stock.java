package edu.ferris.seng355.items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {
        "weight",
        "value"
})
public class Stock extends Item {

    private double price;
    private double priceIncreaseProbability;
    private double possibleNewPrice;

    public Stock(){}

    public Stock(double price, double priceIncreaseProbability, double possibleNewPrice) {
        super(price, (possibleNewPrice - price) * priceIncreaseProbability);
        this.price = price;
        this.possibleNewPrice = possibleNewPrice;
        this.priceIncreaseProbability = priceIncreaseProbability;
    }

     public double getPrice() {
         return price;
     }

     public void setPrice(double price) {
         this.price = price;
     }

     public double getPriceIncreaseProbability() {
         return priceIncreaseProbability;
     }

     public void setPriceIncreaseProbability(double priceIncreaseProbability) {
         this.priceIncreaseProbability = priceIncreaseProbability;
     }

     public double getPossibleNewPrice() {
         return possibleNewPrice;
     }

     public void setPossibleNewPrice(double possibleNewPrice) {
         this.possibleNewPrice = possibleNewPrice;
     }

     @Override
    public String toString() {
        return String.format("Price: %f, Potential New Price: %f, Likelihood of Price Increase: %f, Value: %f", price, possibleNewPrice, priceIncreaseProbability, getValue());
     }
 }
