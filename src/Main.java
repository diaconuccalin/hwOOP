public class Main {
    private static AllVehicles vp = new AllVehicles();
    private static AllRoutes ar = new AllRoutes();
    private static AllStops as = new AllStops();
    private static AllEmployees ae = new AllEmployees();

    private static Depot d1 = new Depot("Grozavesti", 30);
    private static Depot d2 = new Depot("Zorilor", 210);
    private static Depot d3 = new Depot("Campului", 120);

    private static Route r1 = new Route(35);
    private static Route r2 = new Route(40);

    public static void main(String[] args) {
        as.addStop(new Stop("Observator"));
        as.addStop(new Stop("Memo"));
        as.addStop(new Stop("VIVO"));
        as.addStop(new Stop("Iulius Mall"));
        as.addStop(new Stop("Piata Garii"));
        as.addStop(new Stop("Horia"));

        vp.addVehicle(new Vehicle(100, 123, Vehicle.vehicleType.BUS));
        vp.addVehicle(new Vehicle(100, 845, Vehicle.vehicleType.BUS));
        vp.addVehicle(new Vehicle(100, 756, Vehicle.vehicleType.BUS));
        vp.addVehicle(new Vehicle(100, 231, Vehicle.vehicleType.BUS));

        r1.addStop(as.getStop(2));
        r1.addStop(as.getStop(1));
        r1.addStop(as.getStop(0));

        r2.addStop(as.getStop(0));
        r2.addStop(as.getStop(5));
        r2.addStop(as.getStop(4));
        r2.addStop(as.getStop(3));

        ar.addRoute(r1);
        ar.addRoute(r2);

        ae.addEmployee(new Employee("George Popescu"));
        ae.addEmployee(new Employee("Girip Arthur"));
        ae.addEmployee(new Employee("Girip Elvis"));
        ae.addEmployee(new Employee("Betianu Miruna"));
        ae.addEmployee(new Employee("Diaconu Calin"));
        ae.addEmployee(new Employee("Girip Cristian"));

        MainFrame mp = new MainFrame(vp, ar, as, ae, d1, d2, d3);
    }
}
