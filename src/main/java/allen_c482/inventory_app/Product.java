package allen_c482.inventory_app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Class for creating a Product Object
 * @author Matt Allen. Student Number: 010945885
 */
public class Product {
    private ObservableList<Part> associatedParts = FXCollections.observableArrayList();;
    private int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;

    /**
     * Constructor
     */
    public Product(int id, String name, double price, int stock, int min, int max) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
    }

    /**
     * ID setter
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Name setter
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Price setter
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Stock Setter
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Min setter
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     * Max setter
     */
    public void setMax(int max) {
        this.max = max;
    }

    /**
     * ID getter
     */
    public int getId() {
        return id;
    }

    /**
     * Name getter
     */
    public String getName() {
        return name;
    }

    /**
     * Price getter
     */
    public double getPrice() {
        return price;
    }

    /**
     * Stock getter
     */
    public int getStock() {
        return stock;
    }

    /**
     * Min getter
     */
    public int getMin() {
        return min;
    }

    /**
     * Max getter
     */
    public int getMax() {
        return max;
    }

    /**
     * Part getter
     */
    public void addAssociatedPart(Part part) {
        associatedParts.add(part);
    }

    /**
     * Delete Parts connected to Product
     */
    public boolean deleteAssociatedPart(Part selectedAssociatedPart) {
        return associatedParts.remove(selectedAssociatedPart);
    }

    /**
     * Get all Associated Parts
     */
    public ObservableList<Part> getAllAssociatedParts() {
        return associatedParts;
    }
}

