/**=
 * <h1>AllRoutes</h1>
 * This class is used for storing and managing a list of Routes.
 */

public class AllRoutes {
    private Route[] all = new Route[200];
    private int n;

    /**
     * This constructor sets the initial number of Routes in the list to 0.
     */
    AllRoutes() {
        n = 0;
    }

    /**
     * Getter function for n.
     * @return int Returns the value of n.
     */
    public int getN() {
        return n;
    }

    /**
     * Getter function for the list of Routes.
     * @return Route[] Returns an array of Route objects containing the list of all the Routes stored.
     */
    public Route[] getAll() {
        return all;
    }

    /**
     * This function adds a Route object to the list of stored Routes in ascending order of the Routes' IDs.
     * @param r This is the Route to be added.
     * @return int Returns the index of the place in the list where the Route was stored.
     */
    public int addRoute(Route r) {
        for(int i = 0; i < n; i++) {
            if(all[i].getId() > r.getId()) {
                if (n - i >= 0) System.arraycopy(all, i, all, i + 1, n - i);
                all[i] = r;
                n++;
                return i;
            }
        }
        all[n] = r;
        n++;
        return n-1;
    }

    /**
     * This function returns the Route with a certain ID.
     * @param rId The id of the searched Route, passed as String.
     * @return Route The Route object with id rId.
     */
    public Route getRoute(String rId) {
        int id = Integer.parseInt(rId);
        for(int i = 0; i < n; i++) {
            if(all[i].getId() == id)
                return all[i];
        }

        return null;
    }

    /**
     * This function removes a Route with a certain id from the list, replacing it with the last Route in the list.
     * @param id This is the id of the Route to be removed.
     */
    public void removeRoute(int id) {
        for(int i = 0; i < n; i++) {
            if(all[i].getId() == id) {
                all[i] = all[n - 1];
                n--;
                break;
            }
        }
    }

    /**
     * This function returns the position of the Route with a certain ID.
     * @param id This is the id of the searched Route.
     * @return int The index of the position of the Route with the passed ID, or -1 if the Route is not found.
     */
    public int getIndex(int id) {
        for(int i = 0; i < n; i++) {
            if(all[i].getId() == id)
                return i;
        }
        return -1;
    }
}
