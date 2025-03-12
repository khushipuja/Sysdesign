
import java.util.Collections;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        Employee b = new Employee("B" , Collections.emptyList(),30);
        Employee c = new Employee("C" , Collections.emptyList(),10);

        Employee a = new Employee("A" , List.of(b,c),200);

        EmployeeService employeeService = new EmployeeService();

        employeeService.addEmployee("B" , Collections.emptyList(),30);
        employeeService.addEmployee("C" , Collections.emptyList(),10);
        employeeService.addEmployee("A" , List.of(b,c),80);

        employeeService.findMaxAverageEmployee();

    }
}