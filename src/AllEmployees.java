public class AllEmployees {
    private Employee[] all = new Employee[500];
    private int n;

    public void addEmployee(Employee e) {
        all[n] = e;
        n++;
    }

    public void removeEmployee(String removeName) {
        for(int i = 0; i < n; i++) {
            if(all[i].getName() == removeName) {
                all[i] = all[n];
                n--;
                break;
            }
        }
    }

    public void printEmployees() {
        for(int i = 0; i < n; i++) {
            System.out.println(all[i].getName());
        }
    }
}
