package allen_c482.inventory_app;

import java.net.URL;

import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

/**
 * Updates a product in the inventory.
 * FUTURE ENHANCEMENT: perhaps getters/setters could return a
 * confirmation string
 *  @author Matt Allen. Student Number: 010945885
 */
public class MainController implements Initializable {

    /**
     * Helper class instance variable
     */
    Helpers myHelpers = new Helpers();

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
    //Handlers
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
    @FXML void addProductHandler(ActionEvent event) {
    }

    /**
     * Handles Deleting parts from list
     */
    @FXML void deletePartHandler(ActionEvent event) {
        System.out.println("Delete Part");
    }

    /**
     * Handles deleting products
     */
    @FXML void deleteProductHandler(ActionEvent event) {
        System.out.println("Delete Product");
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
    @FXML void modifyProductHandler(ActionEvent event) {
        System.out.println("Modify Product");
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