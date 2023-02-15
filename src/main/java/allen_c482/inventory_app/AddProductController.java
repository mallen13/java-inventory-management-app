package allen_c482.inventory_app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AddProductController {

    @FXML
    private Button addPartBtn;

    @FXML
    private TableView<?> associatedPartsTable;

    @FXML
    private Button cancelSaveProductBtn;

    @FXML
    private TableColumn<?, ?> partID;

    @FXML
    private TableColumn<?, ?> partID1;

    @FXML
    private TableColumn<?, ?> partInventoryLevel;

    @FXML
    private TableColumn<?, ?> partInventoryLevel1;

    @FXML
    private TableColumn<?, ?> partName;

    @FXML
    private TableColumn<?, ?> partName1;

    @FXML
    private TableColumn<?, ?> partPrice;

    @FXML
    private TableColumn<?, ?> partPrice1;

    @FXML
    private TextField partSearch;

    @FXML
    private TableView<?> partsTable;

    @FXML
    private TextField productIDInput;

    @FXML
    private TextField productInvInput;

    @FXML
    private TextField productMaxInput;

    @FXML
    private TextField productMinInput;

    @FXML
    private TextField productNameInput;

    @FXML
    private TextField productPriceInput;

    @FXML
    private Button removePartBtn;

    @FXML
    private Button saveProductBtn;

    @FXML
    void addAssociatedPart(ActionEvent event) {

    }

    @FXML
    void addProduct(ActionEvent event) {

    }

    @FXML
    void cancelAddProduct(ActionEvent event) {

    }

    @FXML
    void removePart(ActionEvent event) {

    }

}
