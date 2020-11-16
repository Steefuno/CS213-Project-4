package Application;

import java.util.StringTokenizer;

/**
 * This class represents an order line
 * @author Steven Nguyen, Julian Romero
 */
public class OrderLine {
    private int lineNumber;
    private Sandwich sandwich;
    private double price;

    private static int line_number = 1;

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public OrderLine(Sandwich sandwich, double price) {
        this.lineNumber = line_number;
        line_number++;
        this.sandwich = sandwich;
        this.price = price;
    }
    public void decrementSerial(){
        line_number--;
    }
    public void reset(){
        line_number = 1;
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
        String result = this.lineNumber + " ";
        result += this.sandwich.toString();
        result += " Price $" + this.price;
        return result;
    }
}
