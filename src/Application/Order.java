package Application;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class represents an order
 * @author Steven Nguyen, Julian Romero
 */
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
    private void decrementSerial(int lineNumber){
        for(int i = lineNumber; i < orderLines.size();i++){
            orderLines.get(i).setLineNumber(orderLines.get(i).getLineNumber()-1);
        }
    }

    public ArrayList<OrderLine> getOrderLines() {
        return orderLines;
    }

    // Removes an orderLine from order
    @Override
    public boolean remove(Object obj) {
        OrderLine orderLine = (OrderLine) obj;
        decrementSerial(orderLine.getLineNumber());
        lineNumber--;
        return this.orderLines.remove(orderLine);
    }

    // Removes all orderLines from order
    public void removeAll() {
        lineNumber = 0;
        this.orderLines.clear();

    }
    public double totalPrice(){
        double total = 0;
        for(int i = 0; i < orderLines.size();i++){
            total += orderLines.get(i).getPrice();
        }
        total = Double.parseDouble(String.format("%.2f",total));
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

    // Returns the string form
    @Override
    public String toString() {
        String result =  "";
        Iterator<OrderLine> i = this.orderLines.iterator();

        while (i.hasNext())
            result += i.next().toString() + " | " + "\n";

        return result;
    }
}
