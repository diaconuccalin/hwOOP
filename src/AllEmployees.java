public class AllEmployees {
    private Employee[] all = new Employee[500];
    private int n;

    public AllEmployees() {
        n = 0;
    }

    public int getN() {
        return n;
    }
    public Employee[] getAll() {
        return all;
    }

    public int addEmployee(Employee e) {
        for(int i = 0; i < n; i++) {
            if(e.getName().compareTo(all[i].getName()) < 0) {
                if (n - i >= 0) System.arraycopy(all, i, all, i + 1, n - i);

                all[i] = e;
                n++;
                return i;
            }
        }

        all[n] = e;
        n++;
        return n-1;
    }

    public Employee getEmployee(String name) {
        for(int i = 0; i < n; i++) {
            if(all[i].getName().equals(name))
                return all[i];
        }

        return null;
    }

    public void removeEmployee(String removeName) {
        for(int i = 0; i < n; i++) {
            if(all[i].getName().equals(removeName)) {
                all[i] = all[n - 1];
                n--;
                break;
            }
        }
    }

    public void passTime (int time, ErrorFrame ef) {
        for(int i = 0; i < n; i++) {
            all[i].passTime(time, ef);
        }
    }
}
