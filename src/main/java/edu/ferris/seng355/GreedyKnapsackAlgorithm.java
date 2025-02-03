package edu.ferris.seng355;

import java.util.List;

public class GreedyKnapsackAlgorithm implements KnapsackAlgorithm{

    @Override
    public Knapsack collect(List<Item> availableItems, double maxWeight) {
        availableItems.sort(new ItemValueComparator().reversed());

        Knapsack knapsack = new Knapsack(maxWeight);

        double remaining = maxWeight;

        for (Item item: availableItems) {
            if(Double.compare(item.getWeight(), remaining) <= 0) {
                knapsack.getItems().add(item);
                remaining -= item.getWeight();
            }
        }

        return knapsack;
    }
}
