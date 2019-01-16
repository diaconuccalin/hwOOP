public class Depot extends Place{
    private String name;
    private AllVehicles avd = new AllVehicles();

    public Depot(String name, int id) {
        this.name = name;
        this.setId(id);
    }

    public String getName() {
        return name;
    }
    public AllVehicles getAvd() {
        return avd;
    }

    public void addVehicle(Vehicle v) {
        avd.addVehicle(v);
    }

    public void removeVehicle(Vehicle v) {avd.removeVehicle(v.getId());}
}
