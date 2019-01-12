public class AllRoutes {
    private Route[] all = new Route[200];
    private int n;

    AllRoutes() {
        n = 0;
    }

    public int addRoute(Route r) {
        for(int i = 0; i < n; i++) {
            if(all[i].getId() > r.getId()) {
                if (n - i >= 0) System.arraycopy(all, i, all, i + 1, n - i);
                all[i] = r;
                n++;
                return i;
            }
        }
        all[n] = r;
        n++;
        return n-1;
    }

    public void removeRoute(int id) {
        for(int i = 0; i < n; i++) {
            if(all[i].getId() == id) {
                all[i] = all[n - 1];
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

    public int getN() {
        return n;
    }

    public Route[] getAll() {
        return all;
    }

    public Route getRoute(String sId) {
        int id = Integer.parseInt(sId);
        for(int i = 0; i < n; i++) {
            if(all[i].getId() == id)
                return all[i];
        }

        return null;
    }

    public Route getRoute(int id) {
        for(int i = 0; i < n; i++) {
            if(all[i].getId() == id)
                return all[i];
        }

        return null;
    }

    public int getIndex(int id) {
        for(int i = 0; i < n; i++) {
            if(all[i].getId() == id)
                return i;
        }
        return -1;
    }
}
