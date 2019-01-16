public class Route {
    private int id;
    private int n;

    private Stop[] stops = new Stop[200];
    private AllVehicles av = new AllVehicles();

    public Route(int routeId) {
        id = routeId;
        n = 0;
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

    public void addStop(Stop st) {
        stops[n] = st;
        n++;
        st.addRoute(this);
    }

    public Stop getFirstStop() {return stops[0];}
    public AllVehicles getAv() {
        return av;
    }

    public void addVehicle(Vehicle v) {
        av.addVehicle(v);
    }
    public void removeVehicle(Vehicle v) {
        av.removeVehicle(v.getId());
    }

    public Place getNextStop(Place stop) {
        for(int i=0; i<stops.length - 1; i++)
        {
            if(stop == stops[i]) return stops[i+1];
        }
        return stops[0];
    }

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
