public class AllStops {
    private Stop[] all = new Stop[200];
    private int n;

    AllStops() {
        n = 0;
    }

    public int addStop(Stop s) {
        for(int i = 0; i < n; i++) {
            if(s.getName().compareTo(all[i].getName()) < 0) {
                if (n - i >= 0) System.arraycopy(all, i, all, i + 1, n - i);

                all[i] = s;
                n++;
                return i;
            }
        }
        all[n] = s;
        n++;
        return n - 1;
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

        return all[0];
    }

    public Stop getStop(int index) {
        return all[index];
    }
}
