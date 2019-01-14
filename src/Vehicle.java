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
    private Stop destination;
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
    }

    public void sendOnRoute(Route r, Employee d) {
        activeRoute = r;
        driver = d;
        destination = r.getFirstStop();
//        timeToDestination =                   build a matrix with all possible times and get the time from there
    }
}
