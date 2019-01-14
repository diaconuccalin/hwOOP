public class Employee {
    private String name;
    private int activeTime;
    private Vehicle vehicle;
    private boolean onRoad;

    public Employee(String name) {
        this.name = name;
        activeTime = 0;
        onRoad = false;
    }

    public String getName() {
        return name;
    }

    public void passTime(int time, ErrorFrame ef) {
        activeTime -= time;

        if(activeTime <= 0) {
            ef.displayError("<html><div align = \"center\">Active time limit exceeded on employee " + name + "!</div></html>");
        }else if(activeTime < 15) {
            ef.displayError("<html><div align = \"center\">15 minutes left for employee " + name + "!</div></html>");
        }
    }

    public boolean isOnRoad() {
        return onRoad;
    }
}
