

package allen_c482.inventory_app;

/**
 * Extends part class
 */
public class Outsourced extends Part {

    /**
     * stores teh machineId value
     */
    private String companyName;

    /**
     * Constructs an Outsourced part with the specified information.
     */
    public Outsourced(int id, String name, double price, int stock, int min, int max, String companyName) {
        super(id, name, price, stock, min, max);
        this.companyName = companyName;
    }

    /**
     * Sets the machine ID of the Outsourced part.
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * Returns the machine ID of the Outsourced part.
     */
    public String getCompanyName() {
        return this.companyName;
    }
}
