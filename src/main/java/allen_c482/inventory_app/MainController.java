package allen_c482.inventory_app;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Updates a product in the inventory.
 */
public class MainController implements Initializable {

    /**
     * Helper class instance variable
     */
    Helpers myHelpers = new Helpers();

    //State Variable for modify part to know what is selected
    private static int selectedPartId;
    private static int selectedProductId;

    /**
     * Filtered Part List
     */
    private FilteredList<Part> partsFilteredList = new FilteredList<>(Inventory.getAllParts(), p -> true);

    /**
     * Filtered Products List
     */
    private FilteredList<Product> productsFilteredList = new FilteredList<>(Inventory.getAllProducts(), p -> true);

    //Declare Components
    @FXML private Button addPart;
    @FXML private Button addProduct;
    @FXML private Button deletePart;
    @FXML private Button deleteProduct;
    @FXML private Button exit;
    @FXML private Button modifyPart;
    @FXML private Button modifyProduct;
    @FXML private TableColumn<Part, Integer> partID;
    @FXML private TableColumn<Part, Integer> partInventoryLevel;
    @FXML private TableColumn<Part, String> partName;
    @FXML private TableColumn<Part, Double> partPrice;
    @FXML private TextField partSearchInput;
    @FXML private TableView<Part> partsTable;
    @FXML private TableColumn<Product, Integer> productID;
    @FXML private TableColumn<Product, Integer> productInventoryLevel;
    @FXML private TableColumn<Product, String> productName;
    @FXML private TableColumn<Product, Double> productPrice;
    @FXML private TextField searchPart;
    @FXML private TextField searchProduct;
    @FXML private TableView<Product> productsTable;

    /**
     * Initial Method
     */
    public void initialize(URL location, ResourceBundle resources) {

        //fill parts table on initialize
        partsTable.setItems(partsFilteredList);
        partID.setCellValueFactory(new PropertyValueFactory<>("id"));
        partInventoryLevel.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partName.setCellValueFactory(new PropertyValueFactory<>("name"));
        partPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        //fill products table on initialize
        productsTable.setItems(productsFilteredList);
        productID.setCellValueFactory(new PropertyValueFactory<>("id"));
        productInventoryLevel.setCellValueFactory(new PropertyValueFactory<>("stock"));
        productName.setCellValueFactory(new PropertyValueFactory<>("name"));
        productPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    /**
     * Handles Adding parts to list
     */
    @FXML void addPartHandler(ActionEvent event) throws IOException {
        //change scene
        myHelpers.changeScene(
                "addPartForm.fxml",
                600,
                400,
                "Add Part",
                event
        );
    }

    /**
     * Handles adding parts to list
     */
    @FXML void addProductHandler(ActionEvent event) throws IOException {
        myHelpers.changeScene(
                "addProductForm.fxml",
                1000,
                600,
                "Add Part",
                event
        );
    }

    /**
     * Handles Deleting parts from list
     */
    @FXML void deletePartHandler() {
        //get part
        Part selectedPart = partsTable.getSelectionModel().getSelectedItem();

        //if no row selected
        if (selectedPart == null) {
            myHelpers.showAlert("Invalid Selection", "No Item Selected");
            return;
        }

        //conform remove
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm");
        alert.setHeaderText("Are you sure?");
        alert.setContentText("Choose an option.");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            if (Inventory.deletePart(selectedPart) == false) {
                myHelpers.showAlert("Remove Error", "Unable to Remove.");
            };
            ;
        }
    }

    /**
     * Handles deleting products
     */
    @FXML void deleteProductHandler() {
        //get part
        Product selectedProduct = productsTable.getSelectionModel().getSelectedItem();

        //if no row selected
        if (selectedProduct == null) {
            myHelpers.showAlert("Invalid Selection", "No Item Selected");
            return;
        }

        //alert if associated parts
        ObservableList parts = selectedProduct.getAllAssociatedParts();
        AtomicBoolean associatedParts = new AtomicBoolean(false);

        parts.forEach( part -> {
            if (Inventory.getAllParts().contains(part)) {
                associatedParts.set(true);
            }
        });

        if (associatedParts.get()) {
            myHelpers.showAlert("Remove Error", "Unable to Remove. Product is associated with Parts.");
            return;
        };
        //check if any associated parts in inventory
                //if so, error message and return

        //conform remove
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm");
        alert.setHeaderText("Are you sure?");
        alert.setContentText("Choose an option.");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            if (Inventory.deleteProduct(selectedProduct) == false) {
                myHelpers.showAlert("Remove Error", "Unable to Remove. Please ensure no associated projects.");
            };
        }
    }

    /**
     * Exits App.
     * RUNTIME ERROR: was missing argument at first for .exit(),
     * so when called it produced an error
     */
    @FXML void exit(ActionEvent event) {
        System.exit(0);
    }

    /**
     * Get part ID
     */
    public static int getPartId() {
        return selectedPartId;
    }

    /**
     * Get Product ID
     */
    public static int getProductId() {
        return selectedProductId;
    }

    /**
     * Handles Modifying the parts
     */
    @FXML void modifyPartHandler(ActionEvent event) throws IOException {
        //get selected item
        Part selectedPart = partsTable.getSelectionModel().getSelectedItem();

        //if no item selected
        if (selectedPart == null) {
            myHelpers.showAlert("Invalid Selection", "No Item Selected");
            return;
        }

        this.selectedPartId = selectedPart.getId();

        //change scene
        myHelpers.changeScene(
                "modifyPartForm.fxml",
                600,
                400,
                "Modify Part",
                event
        );
    }

    /**
     * Handles modifying the product
     */
    @FXML void modifyProductHandler(ActionEvent event) throws IOException {
        //get selected item
        Product selectedProduct = productsTable.getSelectionModel().getSelectedItem();

        //if no item selected
        if (selectedProduct == null) {
            myHelpers.showAlert("Invalid Selection", "No Item Selected");
            return;
        }

        this.selectedProductId = selectedProduct.getId();

        //change scene
        myHelpers.changeScene(
                "modifyProductForm.fxml",
                1000,
                600,
                "Modify Product",
                event
        );
    }

    /**
     * Filter Parts List
     */
    private void filterPartsList(String searchText) {
        partsFilteredList.setPredicate(part -> {
            if (searchText == null || searchText.isEmpty()) {
                return true;
            }
            String lowerCaseSearchText = searchText.toLowerCase();
            String convertedID = Integer.toString(part.getId()).toLowerCase();

            return part.getName().toLowerCase().contains(lowerCaseSearchText) || convertedID.contains(lowerCaseSearchText) ;
        });
    }

    /**
     * Filter Products List
     */
    private void filterProductsList(String searchText) {
        productsFilteredList.setPredicate(part -> {
            if (searchText == null || searchText.isEmpty()) {
                return true;
            }
            String lowerCaseSearchText = searchText.toLowerCase();
            String convertedID = Integer.toString(part.getId()).toLowerCase();

            return part.getName().toLowerCase().contains(lowerCaseSearchText) || convertedID.contains(lowerCaseSearchText) ;
        });
    }

    /**
     * Handles Adding parts to list
     */
    @FXML void searchPart() {
        String searchText = searchPart.getText();
        //filter partsTable values
        filterPartsList(searchText);
    }

    /**
     * Handles Searching Products
     */
    @FXML void searchProduct() {
        String searchText = searchProduct.getText();
        //filter partsTable values
        filterProductsList(searchText);
    }
}