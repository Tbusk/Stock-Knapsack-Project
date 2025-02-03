package edu.ferris.seng355.algorithms;

import edu.ferris.seng355.items.Item;
import edu.ferris.seng355.knapsack.Knapsack;

import java.util.List;


// Algorithm Source: https://medium.com/@fabianterh/how-to-solve-the-knapsack-problem-with-dynamic-programming-eb88c706d3cf
public class OptimalKnapsackAlgorithm implements KnapsackAlgorithm {

    @Override
    public Knapsack collect(List<Item> availableItems, double maxWeight) {
        int numberOfItems = availableItems.size();

        int[] weights = availableItems.stream().mapToInt(item -> (int) (item.getWeight() * 100)).toArray();
        int[] values = availableItems.stream().mapToInt(item -> (int) (item.getValue() * 100)).toArray();

        int maximumWeight = (int) (maxWeight * 100);

        Knapsack knapsack = new Knapsack(maxWeight);

        int[][] table = new int[numberOfItems + 1][numberOfItems + 1];

        for (int item = 1; item <= numberOfItems; item++){
            for (int capacity = 1; capacity < maximumWeight; capacity++) {
                int maxValueWithoutItem = table[item - 1][capacity];
                int maxValueWithItem = 0;
                int currentItemWeight = weights[item - 1];

                if(capacity >= currentItemWeight) {
                    maxValueWithItem = values[item - 1];

                    int remainingCapacity = capacity - currentItemWeight;
                    maxValueWithItem += table[item - 1][remainingCapacity];
                }

                if(maxValueWithItem > maxValueWithoutItem) {
                    knapsack.getItems().add(availableItems.get(item - 1));
                }
                table[item][capacity] = Math.max(maxValueWithoutItem, maxValueWithItem);
            }
        }

        return knapsack;

    }
}
