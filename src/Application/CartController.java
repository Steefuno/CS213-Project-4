package Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.application.Application;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class CartController {

    @FXML
    private ListView<String> cartOrderView;

    @FXML
    private TextField orderTotalCart;

    private Order currentOrder;
    private OrderLine currentOrderLine;
    private OrderController OrderController;
    private Stage secondStage;

    void setup(){
        currentOrder = new Order();
    }
    public void setOrderController(OrderController orderController) {
        try {
            FXMLLoader cartSceneFXML = new FXMLLoader(getClass().getResource("Cart.fxml"));
            secondStage = new Stage();
            Scene cartScene = (Scene) cartSceneFXML.load();

            secondStage.setScene(cartScene);
            secondStage.setTitle("Cart");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    void add(Sandwich sandwich){
        this.currentOrderLine = new OrderLine(sandwich,sandwich.price());
        this.currentOrder.add(currentOrderLine);
        cartOrderView.getItems().add(this.currentOrder.toString());
        this.orderTotalCart.setText(String.valueOf(currentOrder.totalPrice()));
    }


    public void show(){//TODO setup interaction
        //secondStage.show();
        //firstStage.show();
    }

    @FXML
    void addOrderLine(ActionEvent event) {
        int index;
        MultipleSelectionModel<String> selectionModel = cartOrderView.getSelectionModel();
        if(selectionModel.isEmpty()){
            return;
        }
        ObservableList<String> selectedItems = selectionModel.getSelectedItems();

        if(selectedItems.get(0).substring(1,2).contains(" ")) {
            index = Integer.parseInt(selectedItems.get(0).substring(0,1));
        }
        else{
            index = Integer.parseInt(selectedItems.get(0).substring(0,2));
        }

        //found order line with same serial and put in current order
        OrderLine lineOrder = this.currentOrder.find(index);
        //found order line and add identical sandwich to list using add method
        this.add(lineOrder.getSandwich());
    }

    @FXML
    void backToOrder(ActionEvent event) {//TODO setup interaction
        //OrderController.show()
        //firstStage.show();
        //secondStage.close();
        return;

    }

    @FXML
    void clearOrder(ActionEvent event) {
        currentOrder.removeAll();
        cartOrderView.getItems().clear();
        this.currentOrderLine.reset();
        this.orderTotalCart.setText(String.valueOf(currentOrder.totalPrice()));
    }

    @FXML
    void removeOrderLine(ActionEvent event) {
        MultipleSelectionModel<String> selectionModel = cartOrderView.getSelectionModel();
        if(selectionModel.isEmpty()){
            return;
        }
        ObservableList<String> selectedItems = selectionModel.getSelectedItems();
        int index;
        //check for single or double digit serial number
        if(selectedItems.get(0).substring(1,2).contains(" ")){
            index = Integer.parseInt(selectedItems.get(0).substring(0,1));
        }
        else{
            index = Integer.parseInt(selectedItems.get(0).substring(0,2));
        }

        OrderLine lineOrder = this.currentOrder.find(index);
        cartOrderView.getItems().remove(index + " " + lineOrder.toString());
        this.currentOrder.remove(lineOrder);


        this.orderTotalCart.setText(String.valueOf(currentOrder.totalPrice()));
    }

    @FXML
    void saveOrderToFile(ActionEvent event) {
        //MultipleSelectionModel<String> selectionModel = cartOrderView.getSelectionModel();
        if(cartOrderView.getItems().isEmpty()){
            return;
        }

        FileChooser fileChooser = new FileChooser();
        Stage primaryStage = new Stage();

        fileChooser.setTitle("Save File");
        //adds .txt extension to all text files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        File orderLine = fileChooser.showSaveDialog(primaryStage);

        if(orderLine == null){
            return;
        }
        //put in right format
        String result = "";
        String cartString = cartOrderView.getItems().toString().substring(1,cartOrderView.getItems().toString().length()-1);
        String [] arrayX = cartString.split(", ",-2);
        for(int i = 0; i < arrayX.length; i++){
            result += arrayX[i] + "\n";
        }

        saveTextToFile(result,orderLine);

    }
    /**
     * Saves the text from the line order to a file
     * @param content,file Takes the strings in the database and file location
     */
    private void saveTextToFile(String content, File file){
        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(content);
            writer.close();
        } catch (IOException ex) {
        }
    }
}
