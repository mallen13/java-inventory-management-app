package allen_c482.inventory_app;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import java.io.IOException;

public class AddPartController {
    //Variables
    Helpers myHelpers = new Helpers();

    private int id;

    //JavaFX Declarations
    @FXML
    private TextField addPartSource;

    @FXML
    private TextField addPartInv;

    @FXML
    private TextField addPartMax;

    @FXML
    private TextField addPartMin;

    @FXML
    private TextField addPartName;

    @FXML
    private RadioButton addPartOption1;

    @FXML
    private RadioButton addPartOption2;

    @FXML
    private TextField addPartPrice;

    @FXML
    private TextField addPartID;

    @FXML
    private Label addPartSourceLabel;

    @FXML
    private Button cancelAddPart;

    @FXML
    private Button addPart;

    @FXML
    private ToggleGroup togglePartSource;

    //Controller Functions
    @FXML void cancelAddPart(ActionEvent event) throws IOException {
        myHelpers.changeScene(
                "mainForm.fxml",
                1021,
                386,
                "Main Management App",
                event
        );
    }

    @FXML void addPart(ActionEvent event) throws IOException {
        String name = addPartName.getText();
        String invInput = addPartInv.getText();
        String priceInput = addPartPrice.getText();
        String maxInput =addPartMax.getText();
        String minInput =addPartMin.getText();
        String sourceInput = addPartSource.getText();
        Part newPart;

        //validate values

        //convert;
        double price = Double.parseDouble(priceInput);
        int inv = Integer.parseInt(invInput);
        int min = Integer.parseInt(minInput);
        int max = Integer.parseInt(maxInput);

        //if in-house is toggled
        if (addPartOption1.isSelected()) {
            int source = Integer.parseInt(sourceInput);
            newPart = new InHouse(id, name, price, inv, min, max, source);
            //if outsourced is toggled
        } else {
            newPart = new Outsourced(id, name, price, inv, min, max, sourceInput);
        }

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

    //change label on toggle
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

