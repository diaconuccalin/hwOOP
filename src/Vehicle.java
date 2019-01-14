import java.util.Random;
public class Vehicle {
    enum vehicleType {
        BUS,
        TROLLEYBUS,
        SERVICE
    }

    private int fuel;
    private int id;
    private vehicleType type;
    private boolean malfunction;

    private int timeToDestination;
    private Place destination;
    private Route activeRoute;
    private Employee driver;

    private Depot currentDepot;
    private Stop currentStop;
    private Route currentRoute;

    Vehicle(int id, vehicleType type) {
        fuel = 100;
        this.id = id;
        this.type = type;

        malfunction = false;

        activeRoute = null;
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

    public int getFuel() {
        return fuel;
    }

    public void setMalfunction(boolean malfunction) {
        this.malfunction = malfunction;
    }

    public void passTime(int time) {
        timeToDestination -= time;
        if(timeToDestination == 0){
            destination = currentRoute.getNextStop(currentStop);
        }
    }

    public void sendOnRoute(Route r, AllEmployees ae, int[][] distances) {
        activeRoute = r;
        driver = setDriver(ae);
        destination = r.getFirstStop();
        timeToDestination = distances[destination.getId()][r.getFirstStop().getId()];
    }

    public void sendToDepot(Depot d, int[][] distances){
        timeToDestination = distances[destination.getId()][d.getId()];
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
       return driver = e[a];
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
}
