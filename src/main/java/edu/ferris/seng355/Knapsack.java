package edu.ferris.seng355;

import java.util.ArrayList;
import java.util.List;

public class Knapsack{

    private double maxWeight;
    private List<Item> items;

    Knapsack(double maxWeight) {
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
