package allen_c482.inventory_app;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

/**
 * This class represents the inventory of parts and products for the inventory management system.
 * @author Matt Allen. Student Number: 010945885
 */
public class Inventory {
    /**
     * CREATES allParts observable list
     */
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    /**
     * CREATES allProducts observale list
     */
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();

    /**
     * Adds a part to the inventory.
     * RUNTIME ERROR: this was not listed as static at first
     * @param newPart
     */
    public static void addPart(Part newPart) {
        allParts.add(newPart);
    }

    /**
     * Adds a product to the inventory.
     * @param newProduct
     */
    public static void addProduct(Product newProduct) {
        allProducts.add(newProduct);
    }

    /**
     * Searches for a part in the inventory by ID.
     * @param partId
     */
    public static Part lookupPart(int partId) {
        for (Part part : allParts) {
            if (part.getId() == partId) {
                return part;
            }
        }
        return null;
    }

    /**
     * Searches for a product in the inventory by ID.
     */
    public static Product lookupProduct(int productId) {
        for (Product product : allProducts) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    /**
     * Searches for parts in the inventory by name.
     */
    public static ObservableList<Part> lookupPart(String partName) {
        ObservableList<Part> matchingParts = FXCollections.observableArrayList();
        for (Part part : allParts) {
            if (part.getName().equals(partName)) {
                matchingParts.add(part);
            }
        }
        return matchingParts;
    }

    /**
     * Searches for products in the inventory by name.
     */
    public static ObservableList<Product> lookupProduct(String productName) {
        ObservableList<Product> matchingProducts = FXCollections.observableArrayList();
        for (Product product : allProducts) {
            if (product.getName().equals(productName)) {
                matchingProducts.add(product);
            }
        }
        return matchingProducts;
    }

    /**
     * Updates a part in the inventory.
     */
    public static void updatePart(int index, Part selectedPart) {
        allParts.set(index, selectedPart);
    }

    /**
     * Updates a product in the inventory.
     * FUTURE ENHANCEMENT: perhaps getters/setters could return a
     * confirmation string
     */
    public static void updateProduct(int index, Product newProduct) {
        allProducts.set(index, newProduct);
    }

    /**
     * Deletes a part from the inventory.
     * return true if the part was successfully deleted, false otherwise
     */
    public static boolean deletePart(Part selectedPart) {
        return allParts.remove(selectedPart);
    }

    /**
     * Deletes a product from the inventory.
     * return true if the part was successfully deleted, false otherwise
     */
    public static boolean deleteProduct(Product selectedProduct) {
       return allProducts.remove(selectedProduct);
    }

    /**
     * gets all parts from the inventory.
     */
    public static ObservableList<Part> getAllParts() {
        return allParts;
    }

    /**
     * gets all products from the inventory.
     */
    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }
}
