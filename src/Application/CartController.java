package Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.util.Iterator;


public class CartController {

    @FXML
    private ListView<String> cartOrderView;

    @FXML
    private TextField orderTotalCart;

    private Order currentOrder;
    private OrderLine currentOrderLine;

    void setup(){
        currentOrder = new Order();
    }

    void add(Sandwich sandwich){
        this.currentOrderLine = new OrderLine(sandwich,sandwich.price());
        cartOrderView.getItems().add(this.currentOrderLine.toString());
        this.currentOrder.add(currentOrderLine);
    }


    public void show(){

    }

    @FXML
    void addOrderLine(ActionEvent event) {
        MultipleSelectionModel<String> selectionModel = cartOrderView.getSelectionModel();
        ObservableList<String> selectedItems = selectionModel.getSelectedItems();

        currentOrder.add(selectedItems);
        cartOrderView.getItems().add(this.currentOrderLine.toString());
        this.orderTotalCart.setText(String.valueOf(currentOrder.totalPrice()));
    }

    @FXML
    void backToOrder(ActionEvent event) {

    }

    @FXML
    void clearOrder(ActionEvent event) {
        currentOrder.removeAll();
        cartOrderView.getItems().clear();
        this.orderTotalCart.setText(String.valueOf(currentOrder.totalPrice()));
    }

    @FXML
    void removeOrderLine(ActionEvent event) {
        MultipleSelectionModel<String> selectionModel = cartOrderView.getSelectionModel();
        ObservableList<String> selectedItems = selectionModel.getSelectedItems();

        currentOrder.remove(selectedItems);
        cartOrderView.getItems().remove(selectedItems);
        this.orderTotalCart.setText(String.valueOf(currentOrder.totalPrice()));
    }

    @FXML
    void saveOrderToFile(ActionEvent event) {

    }
}
