

package allen_c482.inventory_app;

/**
 * Extends part class
 */
public class Outsourced extends Part {

    /**
     * stores teh machineId value
     */
    private int machineId;

    /**
     * Constructs an Outsourced part with the specified information.
     */
    public Outsourced(int id, String name, double price, int stock, int min, int max, String companyName) {
        super(id, name, price, stock, min, max);
        this.machineId = machineId;
    }

    /**
     * Sets the machine ID of the Outsourced part.
     */
    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }

    /**
     * Returns the machine ID of the Outsourced part.
     */
    public int getMachineId() {
        return machineId;
    }
}
