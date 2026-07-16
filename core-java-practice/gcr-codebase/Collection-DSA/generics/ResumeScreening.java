package generics;
import java.util.*;

abstract class JobRole {

    String role;

    JobRole(String role) {
        this.role = role;
    }

    public String toString() {
        return role;
    }
}

class SoftwareEngineer extends JobRole {

    SoftwareEngineer() {
        super("Software Engineer");
    }
}

class DataScientist extends JobRole {

    DataScientist() {
        super("Data Scientist");
    }
}

class ProductManager extends JobRole {

    ProductManager() {
        super("Product Manager");
    }
}

class Resume<T extends JobRole> {

    String name;
    T role;

    Resume(String name, T role) {
        this.name = name;
        this.role = role;
    }

    public String toString() {
        return "Candidate : " + name +
                " | Role : " + role;
    }
}

public class ResumeScreening {

    static ArrayList<Resume<? extends JobRole>> list = new ArrayList<>();

    static <T extends JobRole> void addResume(Resume<T> r) {
        list.add(r);
    }

    static void show() {

        if (list.isEmpty()) {
            System.out.println("No Resume Found.");
            return;
        }

        System.out.println("\nResume Screening");

        for (Resume<?> r : list)
            System.out.println(r);
    }

    static void roles(List<? extends JobRole> list) {

        System.out.println("\nAvailable Job Roles");

        for (JobRole j : list)
            System.out.println(j);
    }

    public static void main(String[] args) {

        addResume(new Resume<>("Kavya",
                new SoftwareEngineer()));

        addResume(new Resume<>("Riya",
                new DataScientist()));

        addResume(new Resume<>("Aman",
                new ProductManager()));

        show();

        ArrayList<JobRole> role = new ArrayList<>();

        role.add(new SoftwareEngineer());
        role.add(new DataScientist());
        role.add(new ProductManager());

        roles(role);
    }
}