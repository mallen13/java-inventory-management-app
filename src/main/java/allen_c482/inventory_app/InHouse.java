
package allen_c482.inventory_app;

/**
 * Inherited class that extends Part
 */
public class InHouse extends Part {

    /**
     * stores machineId
     */
    private int machineId;

    /**
     * Constructor for the InHouse class that sets the ID, name, price, stock, min, max, and machine ID.
     * @params id, name, price, stock, min,max, machineId
     */
    public InHouse(int id, String name, double price, int stock, int min, int max, int machineId) {
        super(id, name, price, stock, min, max);
        this.machineId = machineId;
    }

    /**
     * Sets the ID of the machine used to manufacture the part.
     * @param machineId The ID of the machine used to manufacture the part
     */
    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }

    /**
     * Returns the ID of the machine used to manufacture the part.
     * @return The ID of the machine used to manufacture the part
     */
    public int getMachineId() {
        return machineId;
    }

}

