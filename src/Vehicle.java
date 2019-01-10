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

    Vehicle(int fuel, int id, vehicleType type) {
        this.fuel = fuel;
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
}
