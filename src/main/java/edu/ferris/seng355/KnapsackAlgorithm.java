package edu.ferris.seng355;

import java.util.List;

public interface KnapsackAlgorithm {
     Knapsack collect(List<Item> availableItems, double maxWeight);
}
