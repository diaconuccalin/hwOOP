/**
 * <h1>Vehicle</h1>
 * Vehicles can be stored in a Depot or can be sent on Route. They also must have a driver when on Route and are
 * of three kinds: BUSES, TROLLEYBUSES and SERVICE VEHICLES.
 */

import java.util.Random;
public class Vehicle {
    enum vehicleType {
        BUS,
        TROLLEYBUS,
        SERVICE
    }

    private int id;
    private vehicleType type;
    private boolean malfunction;

    private int timeToDestination;
    private Place destination;
    private Route activeRoute;
    private Employee driver;

    private Depot currentDepot;

    /**
     * Constructor method.
     * @param id The id of the newly created Vehicle.
     * @param type The type of the newly created Vehicle.
     */
    Vehicle(int id, vehicleType type) {
        this.id = id;
        this.type = type;
        malfunction = false;
        activeRoute = null;
        timeToDestination = 0;
    }

    /**
     * Getter method for the id.
     * @return int The id of the Vehicle.
     */
    public int getId() {
        return id;
    }

    /**
     * Getter method for the type.
     * @return Vehicle.type The type of the Vehicle.
     */
    public String getType() {
        return type.toString();
    }

    /**
     * Getter method for whether the Vehicle has a malfunction.
     * @return boolean This will be true when the Vehicle is malfunctioning.
     */
    public boolean isMalfunction() {
        return malfunction;
    }

    /**
     * Getter method for activeRoute.
     * @return Route Gets the current Route.
     */
    public Route getActiveRoute() {
        return activeRoute;
    }

    /**
     * Getter method for Depot.
     * @return Depot Gets the current Depot.
     */
    public Depot getCurrentDepot() {
        return currentDepot;
    }

    /**
     * Getter method for driver.
     * @return Employee Gets the current assigned Employee.
     */
    public Employee getDriver() {
        return driver;
    }

    /**
     * Getter method for destination.
     * @return Place Gets the next destination of the Vehicle.
     */
    public Place getDestination() {
        return destination;
    }

    /**
     * Getter method for timeToDestination.
     * @return int Gets the time needed to reach the destination.
     */
    public int getTimeToDestination() {
        return timeToDestination;
    }

    /**
     * Setter method for activeRoute.
     * @param activeRoute The Route to be set as active for this Vehicle.
     */
    public void setActiveRoute(Route activeRoute) {
        this.activeRoute = activeRoute;
    }

    /**
     * Setter method for currentDepot.
     * @param currentDepot The Depot to be set as current for this Vehicle.
     */
    public void setCurrentDepot(Depot currentDepot) {
        this.currentDepot = currentDepot;
    }

    /**
     * Function to send this Vehicle on Route. It assigns a random Employee as driver
     * and sets the destination as the first Stop on the Route.
     * @param r Route to be sent to.
     * @param ae List of all Employees.
     * @param distances The matrix of distances between all the Places.
     */
    public void sendOnRoute(Route r, AllEmployees ae, int[][] distances) {
        activeRoute = r;
        driver = setDriver(ae);
        destination = r.getFirstStop();
        timeToDestination += distances[destination.getId()][r.getFirstStop().getId()];
        r.addVehicle(this);
    }

    Random random = new Random();

    /**
     * Function to set a random Employee as driver for this Vehicle.
     * @param ae The list of all the Employees.
     * @return Employee The random Employee obtained.
     */
    public Employee setDriver(AllEmployees ae) {
        Employee[] e = ae.getAll();
        int a = random.nextInt(150);

        while(e[a].isOnRoad())
        {
            a = random.nextInt(150);
        }

        e[a].setOnRoad(true);
        e[a].setVehicle(this);

        System.out.println(e[a].getVehicle().getId());

       return driver = e[a];
    }

    /**
     * Function to remove active driver.
     */
    public void removeDriver() {
        driver.setVehicle(null);
        driver.setOnRoad(false);
        driver = null;
    }

    /**
     * Function that enables the passage of time (thus the movement of the vehicle from current location towards
     * the destination.
     * @param time The amount of time that passes.
     * @param distances The matrix of distances between all the Places.
     */
    public void passTime(int time, int[][] distances) {
        if(timeToDestination >= 0) {
            timeToDestination -= time;
        }
        if(timeToDestination == 0 && activeRoute != null){
            timeToDestination = distances[destination.getId()][activeRoute.getNextStop(destination).getId()];
            destination = activeRoute.getNextStop(destination);
        }
    }
}
