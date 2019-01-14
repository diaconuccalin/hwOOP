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

    Vehicle(int id, vehicleType type) {
        this.id = id;
        this.type = type;

        malfunction = false;

        activeRoute = null;
        timeToDestination = 0;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type.toString();
    }

    public boolean isMalfunction() {
        return malfunction;
    }

    public void setMalfunction(boolean malfunction) {
        this.malfunction = malfunction;
    }

    public void passTime(int time, int[][] distances) {
        if(timeToDestination >= 0) {
            timeToDestination -= time;
        }
        if(timeToDestination == 0 && activeRoute != null){
            timeToDestination = distances[destination.getId()][activeRoute.getNextStop(destination).getId()];
            destination = activeRoute.getNextStop(destination);
        }
    }

    public void sendOnRoute(Route r, AllEmployees ae, int[][] distances) {
        activeRoute = r;
        driver = setDriver(ae);
        destination = r.getFirstStop();
        timeToDestination += distances[destination.getId()][r.getFirstStop().getId()];
    }

    public void sendToDepot(Depot d, int[][] distances){
        timeToDestination += distances[destination.getId()][d.getId()];
        destination = d;
        activeRoute = null;
    }

    Random random = new Random();

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

    public void removeDriver() {
        driver = null;
    }

    public Route getActiveRoute() {
        return activeRoute;
    }

    public void setCurrentDepot(Depot currentDepot) {
        this.currentDepot = currentDepot;
    }

    public Depot getCurrentDepot() {
        return currentDepot;
    }

    public void setActiveRoute(Route activeRoute) {
        this.activeRoute = activeRoute;
    }

    public Employee getDriver() {
        return driver;
    }
}
