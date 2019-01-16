/**
 * <h1>Employee</h1>
 * The Employees are actually the company's drivers.
 */

public class Employee {
    private String name;
    private int activeTime;
    private Vehicle vehicle;
    private boolean onRoad;

    /**
     * Constructor which places Employee "on hold".
     * @param name This will be the name of the new Employee.
     */
    public Employee(String name) {
        this.name = name;
        activeTime = 0;
        onRoad = false;
    }

    /**
     * Getter function for the name.
     * @return String This will return the name of the Employee.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter function for the onRoad boolean.
     * @return boolean Returns true if onRoad is true and false otherwise.
     */
    public boolean isOnRoad() {
        return onRoad;
    }

    /**
     * Setter function for the onRoad boolean.
     * @param onRoad This will be the new value of onRoad.
     */
    public void setOnRoad(boolean onRoad) {
        this.onRoad = onRoad;
    }

    /**
     * Getter function for the driven Vehicle.
     * @return Vehicle The Vehicle which the Employee drives.
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * Getter function for the activeTime.
     * @return int The integer which stores the the active time of a driver while onRoad.
     */
    public int getActiveTime() {
        return activeTime;
    }

    /**
     * Setter function for the Vehicle. This also sets the activeTime at 180, as a driver is not allowed
     * to drive for more than 180 minutes continuously.
     * @param vehicle The Vehicle which is assigned to the Employee.
     */
    public void setVehicle(Vehicle vehicle) {
        activeTime = 180;
        this.vehicle = vehicle;
    }

    /**
     * The passTime function which checks if the maximum active time is approaching or has already been passed
     * and displays warnings accordingly.
     * @param time The amount of time that has passed.
     * @param ef Used to display warnings regarding the activeTime.
     */
    public void passTime(int time, ErrorFrame ef) {
        if(onRoad) {
            activeTime -= time;

            if (activeTime <= 0) {
                ef.displayError("<html><div align = \"center\">Active time limit exceeded on employee " + name + "<br>on vehicle " + vehicle.getId() + "!</div></html>");
            } else if (activeTime < 15) {
                ef.displayError("<html><div align = \"center\">15 minutes left for employee " + name + " on vehicle " + vehicle.getId() + "!</div></html>");
            }
        }
    }
}
