/**
 * @author Matt Allen. Student Number: 010945885
 */

package allen_c482.inventory_app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


/**
 * Main Class to run the app
 * @author Matt Allen, C482
 * FUTURE ENHANCEMENT It would be great to a login option to protect the data and also download
 * the data as a CSV file. Persisting data through a database could be helpful.
 * RUNTIME ERROR: When first running the add new part form, I did not have error handling for
 * empty inputs, this resulted in a runtime error. I had to add a try/catch block to resolve.
 */
public class Main extends Application {

    /**
     * Start method
     */
    @Override public void start(Stage stage) throws IOException {

        //Default Parts
        Part tires = new InHouse(1, "Bike Tires", 30.00, 10, 5, 30, 1);
        Part frames = new InHouse(2, "Bike Frames", 90.00, 4, 2, 40, 2);
        Part seats = new Outsourced(3, "Bike Seats", 30.00, 10, 2, 30, "CompanyA");
        Part handles = new InHouse(4, "Bike Handles", 70.00, 11, 10, 80, 67);
        Inventory.addPart(tires);
        Inventory.addPart(frames);
        Inventory.addPart(seats);
        Inventory.addPart(handles);

        //Default Products
        Product bike = new Product(1, "Bike", 30.00, 14, 5, 30);
        Product wagon = new Product(2, "Wagon", 90.00, 5, 5, 40);
        Product scooter = new Product(3, "Scooter", 30.00, 19, 10, 20);
        bike.addAssociatedPart(tires);
        bike.addAssociatedPart(frames);
        bike.addAssociatedPart(seats);
        bike.addAssociatedPart(handles);
        Inventory.addProduct(bike);
        Inventory.addProduct(wagon);
        Inventory.addProduct(scooter);

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("mainForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1021, 386);
        stage.setTitle("Main Management App");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Main Function to launch the app
     */
    public static void main(String[] args) {
        launch();
    }
}