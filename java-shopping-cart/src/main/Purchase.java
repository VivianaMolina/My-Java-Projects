package main;

public class Purchase implements Comparable<Purchase> {
    private double value;
    private String description;

    public Purchase(double value, String description) {
        this.value = value;
        this.description = description;
    }

    public double getvalue() {
        return value;
    }

    public String getdescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Item: value=" + value + 
               ", description='" + description;
    }  

    // compareTo in order to sort the items by value.
    @Override
    public int compareTo(Purchase otherItem) {
        return Double.valueOf(this.value).compareTo(Double.valueOf(otherItem.getvalue()));
    }
}



