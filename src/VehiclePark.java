public class VehiclePark {
    private Vehicle[] park = new Vehicle[300];
    private int n;

    VehiclePark() {
        n = 0;
    }

    public void addVehicle(Vehicle v) {
        park[n] = v;
        n++;
    }

    public void removeVehicle(int id) {
        for(int i = 0; i < n; i++) {
            if(park[i].getId() == id) {
                park[i] = park[n];
                n--;
                break;
            }
        }
    }
}
