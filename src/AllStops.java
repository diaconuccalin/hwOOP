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
            if(all[i].getName().equals(name)) {
                all[i] = all[n - 1];
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

    public Stop getStop(String name) {
        for(int i = 0; i < n; i++) {
            if(all[i].getName().equals(name)) {
                return all[i];
            }
        }

        return null;
    }

    public Stop getStop(int index) {
        return all[index];
    }
}
