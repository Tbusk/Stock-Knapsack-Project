package edu.ferris.seng355.algorithms;

import edu.ferris.seng355.items.Item;
import edu.ferris.seng355.knapsack.Knapsack;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class OptimalKnapsackAlgorithm implements KnapsackAlgorithm {

    @Override
    public Knapsack collect(List<? extends Item> availableItems, double maxWeight) {
        int[] weights = availableItems.stream().mapToInt(item -> (int) (item.getWeight() * 100)).toArray();
        int[] values = availableItems.stream().mapToInt(item -> (int) (item.getValue() * 100)).toArray();

        int maximumWeight = (int) (maxWeight * 100);

        if(maximumWeight <= 0 || weights.length == 0 || values.length == 0 ||  weights.length != values.length) {
            return null;
        }

        List<Item> itemsInSolution = new ArrayList<>();
        AtomicInteger totalItems = new AtomicInteger();

        int maxProfit = knapsackRecursive(values, weights, maximumWeight, 0, availableItems, totalItems, itemsInSolution);

        Knapsack knapsack = new Knapsack(maxWeight);
        knapsack.getItems().addAll(itemsInSolution);

        System.out.printf("# of Solutions: %,d\n, Max Value: $%,.2f", totalItems.longValue(), ((double) maxProfit / 100.0));

        return new Knapsack(maxWeight);

    }

    private int knapsackRecursive(int[] values, int[] weights, int maxValue, int currentIndex, List<? extends Item> allItems, AtomicInteger totalItems, List<Item> currentItems) {
        if(maxValue <= 0 || currentIndex >= values.length) {
            // Accumulator - will get total number of solutions. If you want to store all solutions, you'd replace totalItems type with List<List<? extends Item>>.
            totalItems.addAndGet(1);
            return 0;
        }

        int firstValue = 0;
        List<Item> includedItemsWithCurrent = new ArrayList<>(currentItems);
        if( weights[currentIndex] <= maxValue) {
            includedItemsWithCurrent.add(allItems.get(currentIndex));
            firstValue = values[currentIndex] + knapsackRecursive(values, weights, maxValue - weights[currentIndex], currentIndex + 1, allItems, totalItems, includedItemsWithCurrent);
        }

        List<Item> includedItemsWithoutCurrent = new ArrayList<>(currentItems);
        int secondValue = knapsackRecursive(values, weights, maxValue, currentIndex + 1, allItems, totalItems, includedItemsWithoutCurrent);

        if (firstValue > secondValue) {
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
