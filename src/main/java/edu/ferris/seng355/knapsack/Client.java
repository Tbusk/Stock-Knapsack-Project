package edu.ferris.seng355.knapsack;

import edu.ferris.seng355.items.Stock;

import java.util.List;

public class Client extends Knapsack{

    private final double budget;

    public Client(double budget) {
        super(budget);

        this.budget = budget;
    }

    public List<Stock> getStocks() {
        return this.getItems().stream()
                .map(stock -> (Stock) stock)
                .toList();
    }

    public void addStock(Stock stock) {
        getStocks().add(stock);
    }

    public double getBudget() {
        return budget;
    }
}
