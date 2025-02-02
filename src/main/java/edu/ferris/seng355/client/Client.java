package edu.ferris.seng355.client;

import edu.ferris.seng355.stock.Stock;

import java.util.List;

public class Client {

    private final List<Stock> stocks;
    private final double budget;

    public Client(List<Stock> stocks, double budget) {
        this.stocks = stocks;
        this.budget = budget;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public double getBudget() {
        return budget;
    }
}
