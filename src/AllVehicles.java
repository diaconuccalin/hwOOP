public class AllVehicles {
    private Vehicle[] park = new Vehicle[300];
    private int n;

    AllVehicles() {
        n = 0;
    }

    public void addVehicle(Vehicle v) {
        park[n] = v;
        n++;
    }

    public void removeVehicle(int id) {
        for(int i = 0; i < n; i++) {
            if(park[i].getId() == id) {
                park[i] = park[n - 1];
                n--;
                break;
            }
        }
    }

    public void printVehicles() {
        for(int i = 0; i < n; i++) {
            System.out.println(park[i].getType() + " - " + park[i].getId());
        }
    }

    public int getN() {
        return n;
    }

    public Vehicle[] getPark() {
        return park;
    }

    public Vehicle findVehicle (int id) {
        for(int i = 0; i < n; i++) {
            if(park[i].getId() == id) {
                return park[i];
            }
        }

        return null;
    }
}
