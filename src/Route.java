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

    public Stop getNextStop(Stop stop) {
        for(int i=0; i<stops.length - 1; i++)
        {
            if(stop == stops[i]) return stops[i+1];
        }
        return stops[0];
    }
}
