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

        knapsackRecursive(values, weights, maxWeight, 0, availableItems, totalSolutions, itemsInSolution);

        Knapsack knapsack = new Knapsack(maxWeight);
        knapsack.addAllItems(itemsInSolution);

        printNumberOfSolutions(totalSolutions);

        return knapsack;

    }

    private static void printNumberOfSolutions(AtomicInteger totalSolutions) {
        System.out.printf("# of Solutions: %,d\n", totalSolutions.longValue());
    }

    private void knapsackRecursive(List<Double> values, List<Double> weights, double maxValue, int currentIndex, List<? extends Item> allItems, AtomicInteger totalSolutions, List<Item> currentItems) {
        if(maxValue <= 0 || currentIndex >= values.size()) {
            // Accumulator - will get total number of solutions. If you want to store all solutions, you'd replace totalSolutions type with List<List<? extends Item>>.
            totalSolutions.addAndGet(1);
            return;
        }

        List<Item> includedItemsWithCurrent = new ArrayList<>(currentItems);
        if( weights.get(currentIndex) <= maxValue) {
            includedItemsWithCurrent.add(allItems.get(currentIndex));
            knapsackRecursive(values, weights, maxValue - weights.get(currentIndex), currentIndex + 1, allItems, totalSolutions, includedItemsWithCurrent);
        }

        List<Item> includedItemsWithoutCurrent = new ArrayList<>(currentItems);
        knapsackRecursive(values, weights, maxValue, currentIndex + 1, allItems, totalSolutions, includedItemsWithoutCurrent);

        double firstValue = getItemsTotal(includedItemsWithCurrent);
        double secondValue = getItemsTotal(includedItemsWithoutCurrent);

        if(firstValue > secondValue) {
            resetAndAddCurrentItems(currentItems, includedItemsWithCurrent);
        } else {
            resetAndAddCurrentItems(currentItems, includedItemsWithoutCurrent);
        }

    }

    private static double getItemsTotal(List<Item> includedItemsWithCurrent) {
        return includedItemsWithCurrent.stream()
                .mapToDouble(Item::getValue)
                .sum();
    }

    private static void resetAndAddCurrentItems(List<Item> currentItems, List<Item> includedItemsWithCurrent) {
        currentItems.clear();
        currentItems.addAll(includedItemsWithCurrent);
    }
}
