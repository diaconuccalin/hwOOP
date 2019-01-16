public class AllVehicles {
    private Vehicle[] park = new Vehicle[300];
    private int n;

    AllVehicles() {
        n = 0;
    }

    public int getN() {
        return n;
    }
    public Vehicle[] getPark() {
        return park;
    }

    public int addVehicle(Vehicle v) {
        for(int i = 0; i < n; i++) {
            if((v.getType() + v.getId()).compareTo(park[i].getType()+park[i].getId()) < 0) {
                if (n - i >= 0) System.arraycopy(park, i, park, i + 1, n - i);

                park[i] = v;
                n++;
                return i;
            }
        }

        park[n] = v;
        n++;
        return n-1;
    }

    public Vehicle getVehicle (int id) {
        for(int i = 0; i < n; i++) {
            if(park[i].getId() == id) {
                return park[i];
            }
        }

        return null;
    }

    public Vehicle getVehicle(String s) {
        String sAux = s.replaceAll("[^0-9]", "");
        int aux = Integer.parseInt(sAux);
        return getVehicle(aux);
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

    public void passTime(int time, int[][] distances) {
        for(int i = 0; i < n; i++) {
            park[i].passTime(time, distances);
        }
    }
}
