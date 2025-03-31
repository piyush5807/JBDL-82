import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Employee implements Comparator<Employee>{

    private String name;

    private Integer salary;

    public Employee(String name, Integer salary) {
        this.name = name;
        this.salary = salary;
    }

    public Employee(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public List<Employee> sort(List<Employee> employees, int limit){

//        return employees.stream()
//                .sorted(Comparator.comparing(Employee::getSalary).reversed()
//                        .thenComparing(Employee::getName))
//                .limit(3)
//                .collect(Collectors.toList());

        return employees.stream()
                .sorted(this::compare)
                .limit(3)
                .collect(Collectors.toList());
    }





    @Override
    public int compare(Employee o1, Employee o2) {
        if(o1.salary.equals(o2.salary)){
            return o1.name.compareTo(o2.name);
        }

        return o2.salary - o1.salary;
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Rajat", 10000),
                new Employee("Punit", 20000),
                new Employee("Dilraj", 30000),
                new Employee("Karan", 20000),
                new Employee("Preeti", 20000),
                new Employee("Kirti", 10000)
        );

        Employee employee = new Employee();



        System.out.println(employee.sort(employees, 3));
    }
}
