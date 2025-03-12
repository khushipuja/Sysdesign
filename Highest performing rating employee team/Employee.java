package TopPerformanceEmployee;

import java.util.List;

public class Employee {
    String name;
    List<Employee> subordinates;
    int rating;

    public Employee(String name, List<Employee> subordinates, int rating) {
        this.name = name;
        this.subordinates = subordinates;
        this.rating = rating;
    }
}
