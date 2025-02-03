package edu.ferris.seng355.algorithms;

import edu.ferris.seng355.items.Item;
import edu.ferris.seng355.knapsack.Knapsack;

import java.util.List;

public interface KnapsackAlgorithm {
     Knapsack collect(List<Item> availableItems, double maxWeight);
}
