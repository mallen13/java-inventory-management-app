/**
 * The AddPartController class is the controller for the add part screen in the inventory management application.
 * It is responsible for handling user input, validating input, and creating new Part objects.
 *
 * @author Matt Allen. Student Number: 010945885
 */

package allen_c482.inventory_app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import java.io.IOException;

/**
 * Controller class for the add part screen.
 */
public class AddPartController {
    //Variables
    Helpers myHelpers = new Helpers();
    private int id;

    //JavaFX Declarations
    @FXML private TextField addPartSource;
    @FXML private TextField addPartInv;
    @FXML private TextField addPartMax;
    @FXML private TextField addPartMin;
    @FXML private TextField addPartName;
    @FXML private RadioButton addPartOption1;
    @FXML private RadioButton addPartOption2;
    @FXML private TextField addPartPrice;
    @FXML private TextField addPartID;
    @FXML private Label addPartSourceLabel;
    @FXML private Button cancelAddPart;
    @FXML private Button addPart;
    @FXML private ToggleGroup togglePartSource;

    /**
     * Event handler for the "Cancel" button.
     * @param  event
     */
    @FXML void cancelAddPart(ActionEvent event) throws IOException {
        myHelpers.changeScene(
                "mainForm.fxml",
                1021,
                386,
                "Main Management App",
                event
        );
    }

    /**
     * Event handler for the "Add" button.
     * @param event
     */
    @FXML void addPart(ActionEvent event) throws IOException {
        //Variables
        Part newPart;
        String name = addPartName.getText();
        String invInput = addPartInv.getText();
        String priceInput = addPartPrice.getText();
        String maxInput = addPartMax.getText();
        String minInput = addPartMin.getText();
        String sourceInput = addPartSource.getText();

        //validate for empty inputs, alert if so
        if (myHelpers.isAnyEmpty(name,invInput,priceInput,maxInput,minInput,sourceInput)) {
            myHelpers.showAlert("Invalid Inputs", "No Empty Inputs");
            return;
        };

        //convert/ validate types;
        double price = 0;
        int inv = 0;
        int min = 0;
        int max = 0;

        try {
            price = Double.parseDouble(priceInput);
            inv = Integer.parseInt(invInput);
            min = Integer.parseInt(minInput);
            max = Integer.parseInt(maxInput);

        } catch (NumberFormatException e) {
            myHelpers.showAlert("Invalid Inputs", "Type Error. Must be: Price(Double), Inv(Int), Min(Int), Max(Int)");
            return;
        }

        //ensure Max > min
        if (max <= min) {
            myHelpers.showAlert("Invalid Inputs", "Max must be greater than Min");
            return;
        }

        //ensure Max > min
        if (inv < min || inv > max) {
            myHelpers.showAlert("Invalid Inputs", "Inventory must be between min and max");
            return;
        }

        //if in-house is toggled
        if (addPartOption1.isSelected()) {
            //try/catch for int
            int source = 0;
            try {
                source = Integer.parseInt(sourceInput);
            } catch (Exception e) {
                myHelpers.showAlert("Invalid Input", "Type Error. Machine ID must be an Integer");
                return;
            };
            newPart = new InHouse(id, name, price, inv, min, max, source);
            //if outsourced is toggled
        } else {
            newPart = new Outsourced(id, name, price, inv, min, max, sourceInput);
        }

        //add item
        Inventory.addPart(newPart);

        //load main
        myHelpers.changeScene(
                "mainForm.fxml",
                1021,
                386,
                "Inventory Management App",
                event
        );
    }

    /**
     * Initializes the controller class and change label on toggle.
     */
    @FXML
    void initialize() {
        //set radio button toggle
        togglePartSource.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == addPartOption1) {
                //toggle option 1
                addPartSourceLabel.setText("Machine ID");
            } else if (newValue == addPartOption2) {
                //toggle option 2
                addPartSourceLabel.setText("Company Name");
            }
        });

        //get inputs on load
        id = Inventory.getAllParts().size() + 1;
        addPartID.setText(String.valueOf(id));
    }
}

