/**
 * <h1>AllStops</h1>
 * This class is used for storing and managing a list of Stops.
 */

public class AllStops {
    private Stop[] all = new Stop[200];
    private int n;

    /**
     * This constructor sets the initial number of Stops to 0.
     */
    AllStops() {
        n = 0;
    }

    /**
     * Getter function for n.
     * @return int The value of n.
     */
    public int getN() {
        return n;
    }

    /**
     * Getter function for the stored list of Stops.
     * @return Stop[] The array of the stored Stops.
     */
    public Stop[] getAll() {
        return all;
    }

    /**
     * This function adds a Stop object to the list, in alphabetical order.
     * @param s This is the Stop to be added.
     * @return int The index of the position where the Stop was inserted.
     */
    public int addStop(Stop s) {
        for(int i = 0; i < n; i++) {
            if(s.getName().compareTo(all[i].getName()) < 0) {
                if (n - i >= 0) System.arraycopy(all, i, all, i + 1, n - i);

                all[i] = s;
                n++;
                return i;
            }
        }
        all[n] = s;
        n++;
        return n - 1;
    }

    /**
     * This function returns the Stop from a certain position in the list.
     * @param index This is the index of the searched Stop.
     * @return Stop This will be the Stop from the index-th position.
     */
    public Stop getStop(int index) {
        return all[index];
    }

    /**
     * This function returns the Stop with a certain name from the list.
     * @param name The name of the searched Stop.
     * @return Stop This will be the Stop with the given name.
     */
    public Stop getStop(String name) {
        for(int i = 0; i < n; i++) {
            if(all[i].getName().equals(name)) {
                return all[i];
            }
        }

        return all[0];
    }
}
