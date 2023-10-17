import java.util.ArrayList;

abstract class Employee {
    public String name;
    public int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
    public abstract double calculate_salary();


    public String toString(){
        return "Employee [name= " + name + ", id = " +id+ ", salary = "+ calculate_salary()+ "]";
    }

}
class Full_time_Employee extends Employee {
    public double monthlySalary;

    public Full_time_Employee(String name, int id,double monthlySalary) {
        super(name,id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculate_salary() {
        return monthlySalary;
    }
}
class Part_Time_Employee extends Employee {
    public double workingHours;
    public double hoursRate;

    public Part_Time_Employee(String name, int id, double workingHours, double hoursRate) {
        super(name, id);
        this.workingHours = workingHours;
        this.hoursRate = hoursRate;
    }

    @Override
    public double calculate_salary() {
        return workingHours*hoursRate;
    }
}
class Payroll_System {
    public ArrayList<Employee> employeeList;

    public Payroll_System() {
        employeeList=new ArrayList<>();
    }
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }
    public void removeEmployee(int id ){
        Employee employeetoRemove = null;
        for (Employee employee : employeeList){
            if (employee.getId() ==id){
                employeetoRemove=employee;
                break;
            }
        }
        if(employeetoRemove != null){
            employeeList.remove(employeetoRemove);
        }
    }
    public void displayEmployee(){
        for (Employee employee:employeeList){
            System.out.println(employee);
        }
    }
}
