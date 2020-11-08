package Application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.collections.ObservableList;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class handles the order scene
 * @author Steven Nguyen, Julian Romero
 */
public class OrderController {
	
    @FXML
    private ComboBox<String> SandwichType;

    @FXML
    private TextArea IncludedIngredientsListView;

    @FXML
    private ImageView SandwichImageView;

    @FXML
    private ListView<?> AvailableExtrasListView;

    @FXML
    private ListView<?> ExtrasListView;

    @FXML
    private TextField TotalPrice;
    
    private Scene CartScene;

    @FXML
    void OnAddExtra(ActionEvent event) {
    	
    }

    @FXML
    void OnAddToOrder(ActionEvent event) {
    	
    }

    @FXML
    void OnRemoveAllExtras(ActionEvent event) {
    	
    }

    @FXML
    void OnRemoveExtra(ActionEvent event) {
    	
    }

    @FXML
    void OnSandwichTypeSelected(ActionEvent event) {
    	
    }

    @FXML
    void OnShowOrder(ActionEvent event) {
    	
    }

    @FXML
    void initialize() {
        assert SandwichType != null : "fx:id=\"SandwichType\" was not injected: check your FXML file 'Order.fxml'.";
        assert IncludedIngredientsListView != null : "fx:id=\"IncludedIngredientsListView\" was not injected: check your FXML file 'Order.fxml'.";
        assert SandwichImageView != null : "fx:id=\"SandwichImageView\" was not injected: check your FXML file 'Order.fxml'.";
        assert AvailableExtrasListView != null : "fx:id=\"AvailableExtrasListView\" was not injected: check your FXML file 'Order.fxml'.";
        assert ExtrasListView != null : "fx:id=\"ExtrasListView\" was not injected: check your FXML file 'Order.fxml'.";
        assert TotalPrice != null : "fx:id=\"TotalPrice\" was not injected: check your FXML file 'Order.fxml'.";

        setupSandwichTypes();
    }

    // Passes the cart scene from the main class to the order controller
	public void addCartScene(Scene cartScene) {
		CartScene = cartScene;
		return;
	}
	
	// Sets up the options for the SandwichType ComboBox
	private void setupSandwichTypes() {
		ObservableList<String> items = SandwichType.getItems();
		ArrayList<String> options = new ArrayList<String>(Arrays.asList(Sandwich.getSandwichTypeOptions()));
		
		items.setAll(options);
		return;
	}
}
