package Application;

import Application.OrderController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			// Load the order scene
			FXMLLoader orderSceneFXML = new FXMLLoader(getClass().getResource("Order.fxml"));
			Scene orderScene = (Scene)orderSceneFXML.load();
			orderScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(orderScene);
			primaryStage.setTitle("Order");
			
			// Load the shopping cart scene
			FXMLLoader cartSceneFXML = new FXMLLoader(getClass().getResource("Cart.fxml"));
			Scene cartScene = (Scene)cartSceneFXML.load();
			cartScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			// Setup the order scene and pass over the cart scene
			OrderController orderController = orderSceneFXML.<OrderController>getController();
			orderController.setup(cartScene);
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
