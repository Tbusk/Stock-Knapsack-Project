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

        double totalWeight = 0;

        for (Item item: availableItems) {

            double totalWeightWithItem = totalWeight + item.getWeight();

            if(Double.compare(maxWeight, totalWeightWithItem) >= 0) {
                knapsack.getItems().add(item);
                totalWeight += item.getWeight();
            }
        }

        return knapsack;
    }
}
