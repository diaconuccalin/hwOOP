public class Depot extends Place{
    private String name;
    private int capacity;

    public Depot(String name, int capacity, int id) {
        this.name = name;
        this.capacity = capacity;
        this.setId(id);
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
}
