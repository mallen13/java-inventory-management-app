/**
 * The modifyPartController class is the controller for the add part screen in the inventory management application.
 * It is responsible for handling user input, validating input, and creating new Part objects.
 *
 * @author Matt Allen. Student Number: 010945885
 */

package allen_c482.inventory_app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

/**
 * Controller class for the add part screen.
 */
public class ModifyPartController {
    //Variables
    Helpers myHelpers = new Helpers();
    private int id;

    //JavaFX Declarations
    @FXML private TextField modifyPartSource;
    @FXML private TextField modifyPartInv;
    @FXML private TextField modifyPartMax;
    @FXML private TextField modifyPartMin;
    @FXML private TextField modifyPartName;
    @FXML private RadioButton modifyPartOption1;
    @FXML private RadioButton modifyPartOption2;
    @FXML private TextField modifyPartPrice;
    @FXML private TextField modifyPartID;
    @FXML private Label modifyPartSourceLabel;
    @FXML private Button cancelModifyPart;
    @FXML private Button modifyPart;
    @FXML private ToggleGroup togglePartSource;
    @FXML private TableView<Part> partsTable;

    /**
     * Event handler for the "Cancel" button.
     * FUTURE ENHANCEMENT: would like the additional stage to be
     * centered on the computer when changing
     * RUNTIME ERROR: was missing @FXML and had to add
     * @param  event
     */
    @FXML void cancelModifyPart(ActionEvent event) throws IOException {
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
     * RUNTIME ERRORS: Runtime errors here when any input was empty.
     * Had to add thorough validation to fix.
     * FUTURE ENHANCEMENT: would like to find way to make this method smaller
     * @param event
     */
    @FXML void modifyPart(ActionEvent event) throws IOException {
        //Variables
        Part newPart;
        String name = modifyPartName.getText();
        String invInput = modifyPartInv.getText();
        String priceInput = modifyPartPrice.getText();
        String maxInput = modifyPartMax.getText();
        String minInput = modifyPartMin.getText();
        String sourceInput = modifyPartSource.getText();

        //validate for empty inputs, alert if so
        if (myHelpers.isAnyEmpty(name,invInput,priceInput,maxInput,minInput,sourceInput)) {
            System.err.println("Empty Inputs");
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
        if  (modifyPartOption1.isSelected()) {
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
            if (newValue == modifyPartOption1) {
                //toggle option 1
                modifyPartSourceLabel.setText("Machine ID");
            } else if (newValue == modifyPartOption2) {
                //toggle option 2
                modifyPartSourceLabel.setText("Company Name");
            }
        });

        // get selected part from table
        System.out.println(id);

        //get product from id
//        Part part = Inventory.lookupPart(id);
//        System.out.println(part.getName());

        //set radio button
        //get values

        //get inputs on load
        modifyPartID.setText(String.valueOf(id));
        modifyPartName.setText("Part Name");
        modifyPartInv.setText("3");
        modifyPartPrice.setText("44.99");
        modifyPartMax.setText("4");
        modifyPartMin.setText("1");
        modifyPartSource.setText("3");

        //modifyPartSourceLabel.setText(partLabel);
    }
}

