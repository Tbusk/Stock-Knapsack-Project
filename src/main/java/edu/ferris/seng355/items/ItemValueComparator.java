package edu.ferris.seng355.items;

import java.util.Comparator;

public class ItemValueComparator implements Comparator<Item> {
    @Override
    public int compare(Item itemOne, Item itemTwo) {
        return Double.compare(itemOne.getValue(), itemTwo.getValue());
    }
}
