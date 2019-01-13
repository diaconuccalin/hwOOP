public class Route {
    private int id;
    private int n;
    private Stop[] stops = new Stop[200];

    public Route(int routeId) {
        id = routeId;
        n = 0;
    }

    public void addStop(Stop st) {
        stops[n] = st;
        n++;
    }

    public int getId() {
        return id;
    }

    public Stop[] getStops() {
        return stops;
    }

    public int getN() {
        return n;
    }

    public Stop getFirstStop() {return stops[0];}
}
