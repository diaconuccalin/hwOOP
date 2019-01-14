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

    public Place[] getAll() {
        return all;
    }

    public Place getPlace(int index) {
        return all[index];
    }
}
