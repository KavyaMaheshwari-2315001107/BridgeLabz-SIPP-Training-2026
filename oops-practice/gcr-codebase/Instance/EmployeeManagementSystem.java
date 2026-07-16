public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Tanya", "EMP2001", "Developer");
        Employee emp2 = new Employee("Vikram", "EMP2002", "Designer");

        if (emp1 instanceof Employee) {
            emp1.displayDetails();
        }
        if (emp2 instanceof Employee) {
            emp2.displayDetails();
        }

        Employee.displayTotalEmployees();
    }
}

class Employee {
    private static String companyName = "Tech Solutions";
    private static int totalEmployees = 0;
    private final String id;
    private String name;
    private String designation;

    public Employee(String name, String id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }

    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    public void displayDetails() {
        System.out.println("Company: " + companyName);
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Designation: " + designation);
    }
}
