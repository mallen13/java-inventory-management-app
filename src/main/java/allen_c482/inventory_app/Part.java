package allen_c482.inventory_app;

/**
 * defines the Part class
 */
public class Part {
    //private attributes
    private int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;

    /**
     * Constructor for the Part class.
     */
    public Part(int id, String name, double price, int stock, int min, int max) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
    }

    /**
     * Sets the ID of the part.
     * @param id the unique ID of the part
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the name of the part.
     * @param name the name of the part
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the price of the part.
     * @param price the price of the part
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Sets the inventory level of the part.
     * @param stock the current inventory level of the part
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Sets the minimum inventory level of the part.
     * @param min the minimum inventory level of the part
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     * Sets the maximum inventory level of the part.
     * @param max the maximum inventory level of the part
     */
    public void setMax(int max) {
        this.max = max;
    }

    /**
     * Returns the ID of the part.
     * @return the unique ID of the part
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the name of the part.
     * @return the name of the part
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the price of the part.
     * @return the price of the part
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the current inventory level of the part.
     * @return the current inventory level of the part
     */
    public int getStock() {
        return stock;
    }

    /**
     * Returns the minimum inventory level of the part.
     * @return the minimum inventory level of the part
     */
    public int getMin() {
        return min;
    }

    /**
     * Returns the maximum inventory level of the part.
     * @return the maximum inventory level of the part
     */
    public int getMax() {
        return max;
    }
}
