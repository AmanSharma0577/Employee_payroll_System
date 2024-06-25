import java.util.ArrayList;

abstract class Employee{

    private String name;

  private int id;

  public Employee(String name, int id){
      this.name = name;
      this.id = id;
  }
  // use the Encapsulation ;
  public String getName(){
      return name;
     }
     public int getId(){
      return id;
     }
public abstract double CalculateSalary();

      @Override
              // Same name but different functionalitu
    public String toString(){
      return "Employee [name=" + name + ", id=" + id + ",salary=" +CalculateSalary()+"]";
}
}

class FullTimeEmployee extends Employee{
    private double monthlySalary;
    public FullTimeEmployee(String name, int id, double monthlySalary){
        //using super keyword to call the parent class constructor
        super(name, id);
        this.monthlySalary = monthlySalary;
    }
    @Override
    public double CalculateSalary(){
        return monthlySalary;
    }
}
class PartialTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;
    public PartialTimeEmployee(String name, int id, double monthlySalary, int hoursWorked){
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
    @Override
    public double CalculateSalary(){
        return hoursWorked * hourlyRate;
    }
}
class PayrollSystem{
    private ArrayList<Employee> employeeList;
    public PayrollSystem(){
        employeeList = new ArrayList<>();
    }
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }
    public void removeEmployee(int id){
        Employee employeeToRemove = null;
        //using for each loop for iterate.
        for(Employee employee : employeeList){
            if(employee.getId() == id){
                employeeToRemove = employee;
                break;
            }
        }
        if(employeeToRemove != null){
            employeeList.remove(employeeToRemove);
        }
    }
    public void displayEmployee(){
        for(Employee employee : employeeList){
            System.out.println(employee);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("Aman Sharma", 1000, 2000);
        PartialTimeEmployee emp2  = new PartialTimeEmployee("Alexender", 2000,   500, 100);
        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        System.out.println("Initial Employee Detail: ");
        payrollSystem.displayEmployee();
        System.out.println("Removing Employee");
        payrollSystem.removeEmployee(emp2.getId());
        System.out.println("Remaining Employee Detail: ");
        payrollSystem.displayEmployee();
    }
}