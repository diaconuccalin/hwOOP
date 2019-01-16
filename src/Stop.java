public class Stop extends Place {
    private String name;
    private AllRoutes ar = new AllRoutes();

    public Stop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public AllRoutes getAr() {
        return ar;
    }

    public void addRoute(Route r) {
        ar.addRoute(r);
    }
    public void removeRoute(Route r) {
        ar.removeRoute(r.getId());
    }
}
