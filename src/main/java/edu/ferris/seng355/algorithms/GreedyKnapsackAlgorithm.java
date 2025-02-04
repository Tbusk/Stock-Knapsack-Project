package edu.ferris.seng355.algorithms;

import edu.ferris.seng355.items.Item;
import edu.ferris.seng355.items.ItemValueComparator;
import edu.ferris.seng355.knapsack.Knapsack;


import java.util.List;

public class GreedyKnapsackAlgorithm implements KnapsackAlgorithm {

    @Override
    public Knapsack collect(List<? extends Item> availableItems, double maxWeight) {
        availableItems.sort(new ItemValueComparator().reversed());

        Knapsack knapsack = new Knapsack(maxWeight);

        addItemsToKnapsack(availableItems, maxWeight, knapsack);

        return knapsack;
    }

    private void addItemsToKnapsack(List<? extends Item> availableItems, double maxWeight, Knapsack knapsack) {
        double totalWeight = 0;

        for (Item item: availableItems) {

            double weightWithItem = getWeightWithItem(item.getWeight(), totalWeight);

            if(Double.compare(maxWeight, weightWithItem) >= 0) {
                knapsack.addItem(item);
                totalWeight += item.getWeight();
            }
        }
    }

    private double getWeightWithItem(double itemWeight, double totalWeight) {
        return itemWeight + totalWeight;
    }
}
