/**
 * <h1>AllVehicles</h1>
 * This class is used for storing and managing a list of Vehicles.
 */

public class AllVehicles {
    private Vehicle[] park = new Vehicle[300];
    private int n;

    /**
     * This constructor sets the initial number of vehicles in the list to 0.
     */
    AllVehicles() {
        n = 0;
    }

    /**
     * Getter function for n.
     * @return int The number of Vehicles stored.
     */
    public int getN() {
        return n;
    }

    /**
     * Getter function for the list of Vehicles.
     * @return Vehicle[] The array containing the stored Vehicles.
     */
    public Vehicle[] getPark() {
        return park;
    }

    /**
     * This function adds a Vehicle object to the stored list.
     * @param v This is the vehicle to be added.
     * @return int The index of the position where the vehicle was inserted.
     */
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

    /**
     * This function returns a Vehicle object with a certain id. If it is not found, null is given instead.
     * @param id This is the id for the searched vehicle.
     * @return Vehicle This is the Vehicle with the given id.
     */
    public Vehicle getVehicle (int id) {
        for(int i = 0; i < n; i++) {
            if(park[i].getId() == id) {
                return park[i];
            }
        }

        return null;
    }

    /**
     * This function returns a Vehicle object with a certain id, passed as a String that also contains other characters.
     * @param s This String contains the id, but may also contain other characters, except numbers.
     * @return Vehicle This is the vehicle with the given id.
     */
    public Vehicle getVehicle(String s) {
        String sAux = s.replaceAll("[^0-9]", "");
        int aux = Integer.parseInt(sAux);
        return getVehicle(aux);
    }

    /**
     * This function removes the Vehicle with a certain id.
     * @param id This is the id of he vehicle to be removed.
     */
    public void removeVehicle(int id) {
        for(int i = 0; i < n; i++) {
            if(park[i].getId() == id) {
                park[i] = park[n - 1];
                n--;
                break;
            }
        }
    }

    /**
     * This function will be called when any of the time passage buttons from the TimeControlFrame is pressed
     * and should, in turn, apply the passTime function to all the Vehicles in the list.
     * @see TimeControlFrame
     * @see Employee
     * @param time This is used to get the amount of time that passes.
     * @param distances This is the matrix of distances between Places and is used further in the Vehicle class.
     */
    public void passTime(int time, int[][] distances) {
        for(int i = 0; i < n; i++) {
            park[i].passTime(time, distances);
        }
    }
}
