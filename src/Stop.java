/**
 * <h1>Stop</h1>
 * A Place through which vehicle pass and which can be added to a Route.
 */

public class Stop extends Place {
    private String name;
    private AllRoutes ar = new AllRoutes();

    /**
     * Constructor function.
     * @param name The name of the newly created Stop.
     */
    public Stop(String name) {
        this.name = name;
    }

    /**
     * Getter function for name.
     * @return String This is the name of the Stop.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter function for Ar.
     * @return AllRoutes The list of the Routes that pass through this Stop.
     */
    public AllRoutes getAr() {
        return ar;
    }

    /**
     * Function to add a Route to this Stop.
     * @param r The Route to be added.
     */
    public void addRoute(Route r) {
        ar.addRoute(r);
    }

    /**
     * Function to remove a Route from this Stop.
     * @param r The Route to be removed.
     */
    public void removeRoute(Route r) {
        ar.removeRoute(r.getId());
    }
}
