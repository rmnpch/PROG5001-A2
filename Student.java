public class Student { // Blueprint for creating similar student objects
    private String name;
    private float total;

    // Student class constructor
    Student(String name, int studentId, float a1, float a2, float a3) {
        this.name = name;
        this.total = a1 + a2 + a3;
    }

    // getters and setter
    public String getName() {
        return name;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(Float newTotal) {
        this.total = newTotal;
    }

}
