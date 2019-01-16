public class AllPlaces {
    Place[] all = new Place[100];
    int n;

    public AllPlaces() {
        n = 0;
    }

    public void addPlace(Place p) {
        all[n] = p;
        n++;
    }
}
