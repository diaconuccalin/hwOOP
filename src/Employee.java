public class Employee {
    private String name;
    private int activeTime;
    private Vehicle vehicle;
    private boolean onRoad;

    public Employee(String name) {
        this.name = name;
        activeTime = 0;
        onRoad = false;
    }

    public String getName() {
        return name;
    }
    public boolean isOnRoad() {
        return onRoad;
    }
    public void setOnRoad(boolean onRoad) {
        this.onRoad = onRoad;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public int getActiveTime() {
        return activeTime;
    }

    public void setVehicle(Vehicle vehicle) {
        activeTime = 180;
        this.vehicle = vehicle;
    }

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
