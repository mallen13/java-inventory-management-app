package allen_c482.inventory_app;

import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import java.io.IOException;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    Helpers myHelpers = new Helpers();

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

    public void initialize(URL location, ResourceBundle resources) {
        //fill parts table on initialize
        partsTable.setItems(Inventory.getAllParts());
        partID.setCellValueFactory(new PropertyValueFactory<>("id"));
        partInventoryLevel.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partName.setCellValueFactory(new PropertyValueFactory<>("name"));
        partPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        //fill products table on initialize
        productsTable.setItems(Inventory.getAllProducts());
        productID.setCellValueFactory(new PropertyValueFactory<>("id"));
        productInventoryLevel.setCellValueFactory(new PropertyValueFactory<>("stock"));
        productName.setCellValueFactory(new PropertyValueFactory<>("name"));
        productPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

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

    @FXML void addProductHandler(ActionEvent event) {
    }

    @FXML void deletePartHandler(ActionEvent event) {
        System.out.println("Delete Part");
    }

    @FXML void deleteProductHandler(ActionEvent event) {
        System.out.println("Delete Product");
    }

    @FXML void exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML void modifyPartHandler(ActionEvent event) {
        System.out.println("Modify Part");
    }

    @FXML void modifyProductHandler(ActionEvent event) {
        System.out.println("Modify Product");
    }

    @FXML void searchPart(KeyEvent event) {
        System.out.println(event.getCharacter());
    }

    @FXML void searchProduct(KeyEvent event) {
        System.out.println(event.getCharacter());
    }
}