public class EmployeeRecords {
    public static void main(String[] args) {
        Manager manager = new Manager("EMP3001", "Sales", 83000.0);
        manager.displayManagerDetails();
        manager.modifySalary(87000.0);
        manager.displayManagerDetails();
    }
}

class Employee {
    public String employeeID;
    protected String department;
    private double salary;

    public Employee(String employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void displayEmployeeInfo() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
    }
}

class Manager extends Employee {
    public Manager(String employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    public void modifySalary(double newSalary) {
        setSalary(newSalary);
    }

    public void displayManagerDetails() {
        displayEmployeeInfo();
    }
}
