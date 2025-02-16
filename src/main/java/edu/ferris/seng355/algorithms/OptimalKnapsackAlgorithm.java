package edu.ferris.seng355.algorithms;

import edu.ferris.seng355.items.Item;
import edu.ferris.seng355.knapsack.Knapsack;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class OptimalKnapsackAlgorithm implements KnapsackAlgorithm {

    @Override
    public Knapsack collect(List<? extends Item> availableItems, double maxWeight) {
        List<Double> values = getValuesFrom(availableItems);
        List<Double> weights = getWeightsFrom(availableItems);
        List<Item> itemsForKnapsack = new ArrayList<>();
        AtomicInteger totalSolutions = new AtomicInteger();

        knapsackRecursive(values, weights, maxWeight, 0, availableItems, totalSolutions, itemsForKnapsack);

        Knapsack knapsack = new Knapsack(maxWeight);
        knapsack.addAllItems(itemsForKnapsack);

        printNumberOfSolutions(totalSolutions);

        return knapsack;

    }

    private void knapsackRecursive(List<Double> values, List<Double> weights, double maxWeight, int currentIndex, List<? extends Item> availableItems, AtomicInteger totalSolutions, List<Item> currentItems) {
        if(maxWeight <= 0 || currentIndex >= values.size()) {
            totalSolutions.addAndGet(1);
            return;
        }

        List<Item> includedItemsWithCurrent = new ArrayList<>(currentItems);
        double currentWeight = weights.get(currentIndex);

        if(currentWeight <= maxWeight) {

            Item currentItem = availableItems.get(currentIndex);
            includedItemsWithCurrent.add(currentItem);

            knapsackRecursive(values, weights, maxWeight - weights.get(currentIndex), currentIndex + 1, availableItems, totalSolutions, includedItemsWithCurrent);
        }

        List<Item> includedItemsWithoutCurrent = new ArrayList<>(currentItems);
        knapsackRecursive(values, weights, maxWeight, currentIndex + 1, availableItems, totalSolutions, includedItemsWithoutCurrent);

        double firstValue = getItemsTotal(includedItemsWithCurrent);
        double secondValue = getItemsTotal(includedItemsWithoutCurrent);

        if(firstValue > secondValue) {
            resetAndAddCurrentItems(currentItems, includedItemsWithCurrent);
        } else {
            resetAndAddCurrentItems(currentItems, includedItemsWithoutCurrent);
        }
    }

    private List<Double> getValuesFrom(List<? extends Item> availableItems) {
        return availableItems.stream().map(Item::getValue).toList();
    }

    private List<Double> getWeightsFrom(List<? extends Item> availableItems) {
        return availableItems.stream()
                .map(Item::getWeight)
                .toList();
    }

    private void printNumberOfSolutions(AtomicInteger totalSolutions) {
        System.out.printf("# of Solutions: %,d\n", totalSolutions.longValue());
    }

    private double getItemsTotal(List<Item> includedItemsWithCurrent) {
        return includedItemsWithCurrent.stream()
                .mapToDouble(Item::getValue)
                .sum();
    }

    private void resetAndAddCurrentItems(List<Item> currentItems, List<Item> itemsToAdd) {
        currentItems.clear();
        currentItems.addAll(itemsToAdd);
    }
}
