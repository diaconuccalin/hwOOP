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

    public void addVehicle(Vehicle v) {
        avd.addVehicle(v);
    }
}
