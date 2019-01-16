/**
 * <h1>Route</h1>
 * The Routes are actually ordered lists of Stops and are used by Vehicles to get the next Stop.
 */

public class Route {
    private int id;
    private int n;

    private Stop[] stops = new Stop[200];
    private AllVehicles av = new AllVehicles();

    /**
     * Constructor function, which also sets the number of Stops to 0.
     * @param routeId The id of the newly created Route.
     */
    public Route(int routeId) {
        id = routeId;
        n = 0;
    }

    /**
     * Getter function for the id.
     * @return int This is the id of the Route.
     */
    public int getId() {
        return id;
    }

    /**
     * Getter function for the list of Stops.
     * @return Stop[] This is an array with all the Stops on the Route.
     */
    public Stop[] getStops() {
        return stops;
    }

    /**
     * Getter function for n.
     * @return int This is the number of Stops in a Route.
     */
    public int getN() {
        return n;
    }

    /**
     * This function adds a Stop to the end of the Stops list.
     * @param st This is the Stop to be added.
     */
    public void addStop(Stop st) {
        stops[n] = st;
        n++;
        st.addRoute(this);
    }

    /**
     * This function returns the first Stop in the Route.
     * @return Stop This the element on the first position in the Stops array.
     */
    public Stop getFirstStop() {return stops[0];}

    /**
     * Getter function for av.
     * @return AllVehicles Returns the list of Vehicles that are now on this route.
     */
    public AllVehicles getAv() {
        return av;
    }

    /**
     * This function adds a vehicle to the list of Vehicles that are now on this Route.
     * @param v The vehicle to be added.
     */
    public void addVehicle(Vehicle v) {
        av.addVehicle(v);
    }

    /**
     * This function removes a vehicle from the list of Vehicles that are now on this Route.
     * @param v The Vehicle to be removed.
     */
    public void removeVehicle(Vehicle v) {
        av.removeVehicle(v.getId());
    }

    /**
     * This function returns the next Stop after the one that was passed. If the passed Stop is not in the list,
     * it will return the first stop instead.
     * @param stop This is the current Stop.
     * @return Stop This is the next Stop.
     */
    public Place getNextStop(Place stop) {
        for(int i=0; i<stops.length - 1; i++)
        {
            if(stop == stops[i]) return stops[i+1];
        }
        return stops[0];
    }

    /**
     * This function is used to display the time until the next Vehicle will arrive in a certain stop on this Route.
     * @param s The stop for which we need the computation.
     * @param distances The matrix of distances between all the Places.
     * @return int The time until the next Vehicle arrives on this line.
     */
    public int getClosestToStop(Stop s, int[][] distances) {
        int min = 2000;
        Vehicle[] v = av.getPark();

        for(int i = 0; i < av.getN(); i++) {
            int d = distances[v[i].getDestination().getId()][s.getId()] + v[i].getTimeToDestination();
            if(d < min)
                min = d;
        }

        return min;
    }
}
