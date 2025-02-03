package edu.ferris.seng355.items;

public class Item {

    private double weight;
    private double value;

    public Item(double weight, double value) {
        this.weight = weight;
        this.value = value;
    }

    public Item() {

    }

    public double getWeight() {
        return weight;
    }

    public double getValue() {
        return value;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
