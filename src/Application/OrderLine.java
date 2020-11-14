package Application;

import java.util.Iterator;

public class OrderLine {
    private int lineNumber;
    private Sandwich sandwich;
    private double price;

    static final int line_number = 0;

    public OrderLine(Sandwich sandwich, double price) {
        this.lineNumber += line_number;
        this.sandwich = sandwich;
        this.price = price;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public Sandwich getSandwich() {
        return sandwich;
    }

    public double getPrice() {
        return price;
    }

    // Returns the string form
    @Override
    public String toString() {
        String result = this.lineNumber + ", ";
        result += this.sandwich.toString();
        result += ", Price $" + this.price;
        return result;
    }
}
