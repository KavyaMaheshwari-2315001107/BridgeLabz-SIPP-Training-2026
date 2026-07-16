package generics;
import java.util.*;

abstract class CourseType {

    String type;

    CourseType(String type) {
        this.type = type;
    }

    public String toString() {
        return type;
    }
}

class ExamCourse extends CourseType {

    ExamCourse(String type) {
        super(type);
    }
}

class AssignmentCourse extends CourseType {

    AssignmentCourse(String type) {
        super(type);
    }
}

class ResearchCourse extends CourseType {

    ResearchCourse(String type) {
        super(type);
    }
}

class Course<T extends CourseType> {

    int id;
    String name;
    T type;

    Course(int id, String name, T type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public String toString() {
        return "Course ID : " + id +
               "  Name : " + name +
               "  Type : " + type;
    }
}

public class UniversityCourse {

    static ArrayList<Course<? extends CourseType>> list = new ArrayList<>();

    static void display(List<? extends CourseType> types) {

        System.out.println("\nCourse Types");

        for (CourseType c : types)
            System.out.println(c);
    }

    static void showCourses() {

        if (list.isEmpty()) {
            System.out.println("No Courses Available.");
            return;
        }

        System.out.println("\nCourses");

        for (Course<?> c : list)
            System.out.println(c);
    }

    public static void main(String[] args) {

        Course<ExamCourse> c1 =
                new Course<>(101, "Data Structures",
                        new ExamCourse("Exam Based"));

        Course<AssignmentCourse> c2 =
                new Course<>(102, "Web Development",
                        new AssignmentCourse("Assignment Based"));

        Course<ResearchCourse> c3 =
                new Course<>(103, "Artificial Intelligence",
                        new ResearchCourse("Research Based"));

        list.add(c1);
        list.add(c2);
        list.add(c3);

        showCourses();

        ArrayList<CourseType> types = new ArrayList<>();

        types.add(new ExamCourse("Exam Based"));
        types.add(new AssignmentCourse("Assignment Based"));
        types.add(new ResearchCourse("Research Based"));

        display(types);
    }
}