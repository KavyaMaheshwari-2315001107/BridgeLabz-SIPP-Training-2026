public class UniversityManagement {
    public static void main(String[] args) {
        PostgraduateStudent student = new PostgraduateStudent(102, "Aarav", 9.1);
        student.displayStudentInfo();
        student.updateCgpa(9.3);
        student.displayStudentInfo();
    }
}

class Student {
    public int rollNumber;
    protected String name;
    private double cgpa;

    public Student(int rollNumber, String name, double cgpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.cgpa = cgpa;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public void displayStudentInfo() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + cgpa);
    }
}

class PostgraduateStudent extends Student {
    public PostgraduateStudent(int rollNumber, String name, double cgpa) {
        super(rollNumber, name, cgpa);
    }

    public void updateCgpa(double newCgpa) {
        setCgpa(newCgpa);
    }
}
