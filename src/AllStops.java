public class AllStops {
    private Stop[] all = new Stop[200];
    private int n;

    AllStops() {
        n = 0;
    }

    public void addStop(Stop s) {
        all[n] = s;
        n++;
    }

    public void removeStop(String name) {
        for(int i = 0; i < n; i++) {
            if(all[i].getName() == name) {
                all[i] = all[n];
                n--;
                break;
            }
        }
    }

    public int getN() {
        return n;
    }

    public Stop[] getAll() {
        return all;
    }
}
