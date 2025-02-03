package edu.ferris.seng355.knapsack;

import edu.ferris.seng355.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Knapsack{

    private double maxWeight;
    private List<Item> items;

    public Knapsack(double maxWeight) {
        this.maxWeight = maxWeight;
        items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public double getMaxWeight() {
        return maxWeight;
    }
}
