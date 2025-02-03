package edu.ferris.seng355.algorithms;

import edu.ferris.seng355.items.Item;
import edu.ferris.seng355.knapsack.Knapsack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


// Algorithm Source: https://medium.com/@fabianterh/how-to-solve-the-knapsack-problem-with-dynamic-programming-eb88c706d3cf
public class OptimalKnapsackAlgorithm implements KnapsackAlgorithm {

    @Override
    public Knapsack collect(List<Item> availableItems, double maxWeight) {
        int numberOfItems = availableItems.size();

        int[] weights = availableItems.stream().mapToInt(item -> (int) (item.getWeight() * 100)).toArray();
        int[] values = availableItems.stream().mapToInt(item -> (int) (item.getValue() * 100)).toArray();

        int maximumWeight = (int) (maxWeight * 100);

        HashMap<Integer, List<Item>> potentialKnapsacks = new HashMap<>();

        int[][] table = new int[numberOfItems + 1][numberOfItems + 1];

        for (int item = 1; item <= numberOfItems; item++){
            List<Item> knapsack = new ArrayList<>();
            for (int capacity = 1; capacity < maximumWeight;) {
                int maxValueWithoutItem = table[item - 1][capacity];
                int maxValueWithItem = 0;
                int currentItemWeight = weights[item - 1];

                if(maximumWeight > currentItemWeight + capacity) {
                    maxValueWithItem = values[item - 1];

                    int remainingCapacity = capacity - currentItemWeight;
                    maxValueWithItem += table[item - 1][remainingCapacity];


                    if(maxValueWithItem > maxValueWithoutItem) {
                        capacity += currentItemWeight;
                        knapsack.add(availableItems.get(item - 1));
                    }
                }

                table[item][capacity] = Math.max(maxValueWithoutItem, maxValueWithItem);
            }
            potentialKnapsacks.put(item - 1, knapsack);
        }

        return getHighestEarningStock(potentialKnapsacks, maxWeight);

    }

    public Knapsack getHighestEarningStock(HashMap<Integer, List<Item>> potentialOptions, double maxWeight) {
        Knapsack knapsack = new Knapsack(maxWeight);
        int numberOfOptions = potentialOptions.size();
        int keyOfMax = -1;
        double maxTotal = -1;

        for(int index = 0; index < numberOfOptions; index++) {
            double currentTotal = getTotalItemValue(potentialOptions.get(index));

            if(maxTotal < currentTotal) {
                keyOfMax = index;
                maxTotal = currentTotal;
            }
        }

        knapsack.getItems().addAll(potentialOptions.get(keyOfMax));

        return knapsack;
    }

    public double getTotalItemValue(List<Item> items) {
        return items.stream().mapToDouble(Item::getValue).sum();
    }
}
