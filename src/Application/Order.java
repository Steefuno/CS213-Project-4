package Application;
import java.util.ArrayList;
import java.util.Iterator;

public class Order implements Customizable {
    private static int lineNumber;
    private ArrayList<OrderLine> orderLines;


    public Order() {
        this.orderLines = new ArrayList<>();
    }

    // Adds an orderLine to order
    @Override
    public boolean add(Object obj) {
        OrderLine orderLine = (OrderLine) obj;
        lineNumber++;
        return this.orderLines.add(orderLine);

    }

    // Removes an orderLine from order
    @Override
    public boolean remove(Object obj) {
        OrderLine orderLine = (OrderLine) obj;
        return this.orderLines.remove(orderLine);
    }

    // Removes all orderLines from order
    public void removeAll() {
        this.orderLines.clear();
    }
    public double totalPrice(){
        double total = 0;
        for(int i = 0; i < orderLines.size();i++){
            total += orderLines.get(i).getPrice();
        }
        return total;
    }


    public OrderLine find(int lineNumber) {
        for(int i = 0; i < orderLines.size(); i++){
            if(orderLines.get(i).getLineNumber() == lineNumber){
                return orderLines.get(i);
            }
        }
        return null;
    }

    public void PrintList() {
        for(int i = 0; i < orderLines.size(); i++){
           System.out.println("Order lines with line #: " + lineNumber + " " + orderLines.get(i));
        }

    }
    // Returns the string form
    @Override
    public String toString() {

        String result = lineNumber + " ";
        result += this.orderLines.get(orderLines.size()-1).toString();
        return result;
    }
}
