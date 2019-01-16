/**
 * <h1>AllEmployees</h1>
 * This class is used for storing and managing a list of Employees.
 */

public class AllEmployees {
    private Employee[] all = new Employee[500];
    private int n;

    /**
     * This is the constructor. It assigns n (the number of Employees in the list) to 0.
     */
    public AllEmployees() {
        n = 0;
    }

    /**
     * Getter function for n.
     * @return int This returns the value of n.
     */
    public int getN() {
        return n;
    }

    /**
     * Getter function for the array of Employees.
     * @return Employee[] This returns the stored list of Employees.
     */
    public Employee[] getAll() {
        return all;
    }

    /**
     * This function adds an Employee object to the list in alphabetical order.
     * @param e This is the Employee to be added.
     * @return int This returns the index of the position on which the Employee was stored in the all[] array.
     */
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

    /**
     * Function to obtain the Employee object from a list by name.
     * @param name A String with the name of Employee that this method should look for.
     * @return Employee The Employee with the given name.
     */
    public Employee getEmployee(String name) {
        for(int i = 0; i < n; i++) {
            if(all[i].getName().equals(name))
                return all[i];
        }

        return null;
    }

    /**
     * Function to remove an Employee from the list by name.
     * @param removeName A String with the name of the Employee to be removed.
     */
    public void removeEmployee(String removeName) {
        for(int i = 0; i < n; i++) {
            if(all[i].getName().equals(removeName)) {
                all[i] = all[n - 1];
                n--;
                break;
            }
        }
    }

    /**
     * This function will be called when any of the time passage buttons from the TimeControlFrame is pressed
     * and should, in turn, apply the passTime function to all the Employees in the list.
     * @see TimeControlFrame
     * @see Employee
     * @param time This is used to get the amount of time that passes.
     * @param ef This is used further, in the Employee class, to warn to user when an Employee exceeds the maximum active time.
     */
    public void passTime (int time, ErrorFrame ef) {
        for(int i = 0; i < n; i++) {
            all[i].passTime(time, ef);
        }
    }
}
