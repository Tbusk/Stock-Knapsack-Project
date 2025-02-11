package edu.ferris.seng355.algorithms;

import edu.ferris.seng355.items.Item;
import edu.ferris.seng355.knapsack.Knapsack;

import java.util.*;

public class DPKnapsackAlgorithm implements KnapsackAlgorithm{
    @Override
    public Knapsack collect(List<? extends Item> availableItems, double maxWeight) {
        double[]  values = getValuesFrom(availableItems);
        double[] weights = getWeightsFrom(availableItems);
        List<Item> itemsForKnapsack = new ArrayList<>();
        HashMap<String, Double> memoization = new HashMap<>();

        knapsackRecursive(values, weights, maxWeight, 0, availableItems, itemsForKnapsack, memoization);

        Knapsack knapsack = new Knapsack(maxWeight);
        knapsack.addAllItems(itemsForKnapsack);

        return knapsack;

    }

    private void knapsackRecursive(double[]  values, double[]  weights, double maxWeight, int currentIndex, List<? extends Item> availableItems, List<Item> currentItems, HashMap<String, Double> memoization) {
        if(maxWeight <= 0 || currentIndex >= values.length) {
            return;
        }

        String key = String.format("%d-%f", currentIndex, maxWeight);

        if(memoization.containsKey(key)) {
            return;
        }

        List<Item> includedItemsWithCurrent = new ArrayList<>(currentItems);

        if(weights[currentIndex] <= maxWeight && values[currentIndex] >= 0) {

            includedItemsWithCurrent.add(availableItems.get(currentIndex));

            knapsackRecursive(values, weights, maxWeight - weights[currentIndex], currentIndex + 1, availableItems, includedItemsWithCurrent, memoization);
        }

        List<Item> includedItemsWithoutCurrent = new ArrayList<>(currentItems);
        knapsackRecursive(values, weights, maxWeight, currentIndex + 1, availableItems, includedItemsWithoutCurrent, memoization);

        double firstValue = getItemsTotal(includedItemsWithCurrent);
        double secondValue = getItemsTotal(includedItemsWithoutCurrent);
        memoization.put(key, Math.max(firstValue, secondValue));

        resetAndAddCurrentItems(currentItems, firstValue > secondValue ? includedItemsWithCurrent : includedItemsWithoutCurrent);
    }

    private double[] getValuesFrom(List<? extends Item> availableItems) {
        return availableItems.stream()
                .mapToDouble(Item::getValue)
                .toArray();
    }

    private double[] getWeightsFrom(List<? extends Item> availableItems) {
        return availableItems.stream()
                .mapToDouble(Item::getWeight)
                .toArray();
    }

    private double getItemsTotal(List<Item> items) {
        double total = 0D;

        for(Item item : items) {
            total += item.getValue();
        }

        return total;
    }

    private void resetAndAddCurrentItems(List<Item> currentItems, List<Item> itemsToAdd) {
        currentItems.clear();
        currentItems.addAll(itemsToAdd);
    }
}
