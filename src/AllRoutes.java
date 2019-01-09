public class AllRoutes {
    private Route[] all = new Route[200];
    private int n;

    AllRoutes() {
        n = 0;
    }

    public void addRoute(Route r) {
        all[n] = r;
        n++;
    }

    public void removeRoute(int id) {
        for(int i = 0; i < n; i++) {
            if(all[i].getId() == id) {
                all[i] = all[n];
                n--;
                break;
            }
        }
    }

    public void printRoutes() {
        for(int i = 0; i < n; i++) {
            System.out.println(all[i].getId());
        }
    }
}
