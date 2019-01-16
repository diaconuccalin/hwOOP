/**
 * <h1>Depot</h1>
 * Depots are used for storing Vehicles that are not on Routes.
 */

public class Depot extends Place{
    private String name;
    private AllVehicles avd = new AllVehicles();

    /**
     * Constructor function.
     * @param name This will be the name of the Depot.
     * @param id This will be the unique id of the Depot.
     */
    public Depot(String name, int id) {
        this.name = name;
        this.setId(id);
    }

    /**
     * Getter function for the name.
     * @return String Returns the name of the Depot.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter function for the list of stored Vehicles.
     * @return AllVehicles Returns an Object with the list of all the stored Vehicles.
     */
    public AllVehicles getAvd() {
        return avd;
    }

    /**
     * Function to add a Vehicle to the list.
     * @param v The Vehicle to be added to the list.
     */
    public void addVehicle(Vehicle v) {
        avd.addVehicle(v);
    }

    /**
     * Function to remove Vehicle from the list.
     * @param v The Vehicle to be removed from the list.
     */
    public void removeVehicle(Vehicle v) {avd.removeVehicle(v.getId());}
}
