public class Main {
    private static VehiclePark vp = new VehiclePark();
    private static AllRoutes ar = new AllRoutes();
    private static AllStops as = new AllStops();
    private static AllEmployees ae = new AllEmployees();

    public static void main(String[] args) {
        as.addStop(new Stop("Observator"));
        as.addStop(new Stop("Memo"));
        as.addStop(new Stop("VIVO"));
        as.addStop(new Stop("Iulius Mall"));
        as.addStop(new Stop("Piata Garii"));
        as.addStop(new Stop("Horia"));

        MainFrame mp = new MainFrame(vp, ar, as, ae);
    }
}
