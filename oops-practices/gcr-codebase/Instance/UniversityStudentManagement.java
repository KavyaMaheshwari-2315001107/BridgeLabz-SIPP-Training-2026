public class UniversityStudentManagement {
    public static void main(String[] args) {
        Student student1 = new Student("Ria", 301, "A");
        Student student2 = new Student("Ayan", 302, "B");

        if (student1 instanceof Student) {
            student1.displayStudentDetails();
        }
        if (student2 instanceof Student) {
            student2.displayStudentDetails();
        }

        Student.displayTotalStudents();
    }
}

class Student {
    private static String universityName = "Greenfield University";
    private static int totalStudents = 0;
    private final int rollNumber;
    private String name;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    public void displayStudentDetails() {
        System.out.println("University: " + universityName);
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Grade: " + grade);
    }
}
