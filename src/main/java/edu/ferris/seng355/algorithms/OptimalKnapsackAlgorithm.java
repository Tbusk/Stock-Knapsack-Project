package edu.ferris.seng355.algorithms;

import edu.ferris.seng355.items.Item;
import edu.ferris.seng355.knapsack.Knapsack;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class OptimalKnapsackAlgorithm implements KnapsackAlgorithm {

    @Override
    public Knapsack collect(List<? extends Item> availableItems, double maxWeight) {
        List<Double> weights = availableItems.stream().map(Item::getWeight).toList();
        List<Double> values = availableItems.stream().map(Item::getValue).toList();

        List<Item> itemsInSolution = new ArrayList<>();
        AtomicInteger totalSolutions = new AtomicInteger();

        double maxProfit = knapsackRecursive(values, weights, maxWeight, 0, availableItems, totalSolutions, itemsInSolution);

        Knapsack knapsack = new Knapsack(maxWeight);
        knapsack.addAllItems(itemsInSolution);

        System.out.printf("# of Solutions: %,d\nMax Value: $%,.2f\n", totalSolutions.longValue(), maxProfit);

        return knapsack;

    }

    private double knapsackRecursive(List<Double> values, List<Double> weights, double maxValue, int currentIndex, List<? extends Item> allItems, AtomicInteger totalSolutions, List<Item> currentItems) {
        if(maxValue <= 0 || currentIndex >= values.size()) {
            // Accumulator - will get total number of solutions. If you want to store all solutions, you'd replace totalSolutions type with List<List<? extends Item>>.
            totalSolutions.addAndGet(1);
            return 0;
        }

        double firstValue = 0;
        List<Item> includedItemsWithCurrent = new ArrayList<>(currentItems);
        if( weights.get(currentIndex) <= maxValue) {
            includedItemsWithCurrent.add(allItems.get(currentIndex));
            firstValue = values.get(currentIndex) + knapsackRecursive(values, weights, maxValue - weights.get(currentIndex), currentIndex + 1, allItems, totalSolutions, includedItemsWithCurrent);
        }

        List<Item> includedItemsWithoutCurrent = new ArrayList<>(currentItems);
        double secondValue = knapsackRecursive(values, weights, maxValue, currentIndex + 1, allItems, totalSolutions, includedItemsWithoutCurrent);

        if(firstValue > secondValue) {
            currentItems.clear();
            currentItems.addAll(includedItemsWithCurrent);
            return firstValue;
        } else {
            currentItems.clear();
            currentItems.addAll(includedItemsWithoutCurrent);
            return secondValue;
        }

    }
}
