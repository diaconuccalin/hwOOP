/**
 * <h1>AllPlaces</h1>
 * This class is used for storing and managing a list of Places.
 */

public class AllPlaces {
    Place[] all = new Place[100];
    int n;

    /**
     * This constructor sets the initial number of stored Places to 0.
     */
    public AllPlaces() {
        n = 0;
    }

    /**
     * This function is used to add a Place to the all[] array.
     * @param p This is the Place object to be added to the list.
     */
    public void addPlace(Place p) {
        all[n] = p;
        n++;
    }
}
