package TopPerformanceEmployee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeService {

    Map<String , Integer> indegreeMap;
    Map<String , Employee> employeeMap;
    double maxAverage;
    String maxAverageName;

    public EmployeeService() {
        indegreeMap = new HashMap<>();
        employeeMap = new HashMap<>();
        maxAverage = Integer.MIN_VALUE;
        maxAverageName = "none";
    }

    public void addEmployee(String name ,List<Employee> subordinates,int rating){
        Employee employee = new Employee(name,subordinates,rating);
        employeeMap.put(name , employee);

        if(subordinates!= null && subordinates.size()>0){
            for(Employee employee1 : subordinates){
                indegreeMap.put(employee1.name , 1);
            }
        }


    }

    public Pair<Integer,Integer> findMaxAverage(Employee employee){

        if(employee == null){
            return new Pair<>(0, 0);
        }

        Pair<Integer,Integer> max = new Pair<>(0, 0);
        int childrenCount = 0;
        int childrenRatingSum = 0;


        for(Employee sub_employee : employee.subordinates){
            Pair<Integer,Integer> sub_max = findMaxAverage(sub_employee);
            childrenCount++;
            childrenRatingSum += sub_max.second;
        }

        double currentAverage = (childrenRatingSum + employee.rating) / (childrenCount+1);

        if(currentAverage > maxAverage){
            maxAverage = currentAverage;
            maxAverageName = employee.name;
        }

        return  new Pair<>(childrenCount + 1, childrenRatingSum + employee.rating);


    }

    public void findMaxAverageEmployee(){

        List<Employee> zeroIndegreeList = new ArrayList<>();
        for(Employee employee : employeeMap.values()){
            if(!indegreeMap.containsKey(employee.name)){
                zeroIndegreeList.add(employee);
            }
        }

        for(Employee employee : zeroIndegreeList){
            findMaxAverage(employee);
        }
        System.out.println("Employee with max avg is : " +maxAverageName + " with avg : " + maxAverage);
    }
}
