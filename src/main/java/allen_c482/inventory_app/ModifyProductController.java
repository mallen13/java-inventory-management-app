package allen_c482.inventory_app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;

/**
 * Handles modifying a product
 */
public class ModifyProductController {

    /**
     * Variable Declarations
     */
    final private FilteredList<Part> partsFilteredList = new FilteredList<>(Inventory.getAllParts(), p -> true);
    private ObservableList<Part> associatedParts = FXCollections.observableArrayList();
    Helpers myHelpers = new Helpers();
    private int id;
    final private Product newProduct = new Product(0,"",00.00,0,0,0);

    @FXML private TableView<Part> associatedPartsTable;
    @FXML private TableColumn<Part, Integer> partID;
    @FXML private TableColumn<Part, Integer> partID1;
    @FXML private TableColumn<Part, Integer> partInventoryLevel;
    @FXML private TableColumn<Part, Integer> partInventoryLevel1;
    @FXML private TableColumn<Part, String> partName;
    @FXML private TableColumn<Part, String> partName1;
    @FXML private TableColumn<Part, Double> partPrice;
    @FXML private TableColumn<Part, Double> partPrice1;
    @FXML private TextField partSearch;
    @FXML private TableView<Part> partsTable;
    @FXML private TextField productIDInput;
    @FXML private TextField productInvInput;
    @FXML private TextField productMaxInput;
    @FXML private TextField productMinInput;
    @FXML private TextField productNameInput;
    @FXML private TextField productPriceInput;

    /**
     * Get Product id on object load
     */
    public void initialize() {
        this.id = Inventory.getAllProducts().size() + 1;
        productIDInput.setText(String.valueOf(id));

        //fill parts table on initialize
        partsTable.setItems(partsFilteredList);
        partID.setCellValueFactory(new PropertyValueFactory<>("id"));
        partInventoryLevel.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partName.setCellValueFactory(new PropertyValueFactory<>("name"));
        partPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        //get selected product ID
        int selectedProductId = MainController.getProductId();
        Product product = Inventory.lookupProduct(selectedProductId);

        //get values
        String inv = Integer.toString(product.getStock());
        String price = Double.toString(product.getPrice());
        String max = Integer.toString(product.getMax());
        String min = Integer.toString(product.getMin());

        //set inputs
        //get inputs on load
        productIDInput.setText(String.valueOf(product.getId()));
        productNameInput.setText(product.getName());
        productInvInput.setText(inv);
        productPriceInput.setText(price);
        productMaxInput.setText(max);
        productMinInput.setText(min);

        //fill associated parts table on initialize
        associatedParts = product.getAllAssociatedParts();
        associatedPartsTable.setItems(associatedParts);
        partID1.setCellValueFactory(new PropertyValueFactory<>("id"));
        partInventoryLevel1.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partName1.setCellValueFactory(new PropertyValueFactory<>("name"));
        partPrice1.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    /**
     * Add Parts to Product
     */
    @FXML void addAssociatedPart() {
        //get selected item
        Part selectedPart = partsTable.getSelectionModel().getSelectedItem();

        //if no item selected
        if (selectedPart == null) {
            myHelpers.showAlert("Invalid Selection", "No Item Selected");
            return;
        }

        //check if part already associated
        if (associatedParts.contains(selectedPart)) {
            myHelpers.showAlert("Invalid Selection", "Part already associated.");
            return;
        }

        //fill parts table
        associatedParts.add(selectedPart);
        newProduct.addAssociatedPart(selectedPart);
    }


    /**
     * Add a new product
     */
    @FXML void saveProduct(ActionEvent event) throws IOException  {
        //Variables
        String name = productNameInput.getText();
        String invInput = productInvInput.getText();
        String priceInput = productPriceInput.getText();
        String maxInput = productMaxInput.getText();
        String minInput = productMinInput.getText();

        //validate for empty inputs, alert if so
        if (myHelpers.isAnyEmpty(name,invInput,priceInput,maxInput,minInput)) {
            myHelpers.showAlert("Invalid Inputs", "No Empty Inputs");
            return;
        }

        //convert/ validate types;
        double price;
        int inv;
        int min;
        int max;

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

        //add item
        ObservableList productsList = Inventory.getAllProducts();
        int productIdx = productsList.indexOf(newProduct);
        Inventory.updateProduct(1,newProduct);

        //if in-house is toggled
        newProduct.setId(id);
        newProduct.setName(name);
        newProduct.setPrice(price);
        newProduct.setStock(inv);
        newProduct.setMin(min);
        newProduct.setMax(max);


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
     * cancel button to go back to main screen
     * @param event
     */
    @FXML void cancelSaveProduct(ActionEvent event) throws IOException {
        myHelpers.changeScene(
                "mainForm.fxml",
                1021,
                386,
                "Main Management App",
                event
        );
    }


    /**
     * remote an associated part
     */
    @FXML void removePart(ActionEvent event) {
        //get selected item
        Part selectedPart = associatedPartsTable.getSelectionModel().getSelectedItem();

        //if no item selected
        if (selectedPart == null) {
            myHelpers.showAlert("Invalid Selection", "No Item Selected");
            return;
        }

        associatedParts.remove(selectedPart);
        newProduct.deleteAssociatedPart(selectedPart);
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
     * Handles Adding parts to list
     */
    @FXML void searchParts() {
        String searchText = partSearch.getText();
        //filter partsTable values
        filterPartsList(searchText);
    }

}
