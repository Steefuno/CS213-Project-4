package Application;
import java.util.ArrayList;

public class Order implements Customizable {
    private static int lineNumber;
    private ArrayList<OrderLine> orderLines;
    static final int line_number = 0;

    public Order() {
        this.lineNumber += line_number;
        this.orderLines = new ArrayList<>();
    }

    // Adds an orderLine to order
    @Override
    public boolean add(Object obj) {
        OrderLine orderLine = (OrderLine) obj;
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
        return;
    }
    public double totalPrice(){
        double total = 0;
        for(int i = 0; i < orderLines.size();i++){
            total += orderLines.get(i).getPrice();
        }
        return total;
    }
}
