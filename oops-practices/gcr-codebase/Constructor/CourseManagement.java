public class CourseManagement {
    public static void main(String[] args) {
        Course course1 = new Course("Java Programming", "3 months", 12000.0);
        Course course2 = new Course("Web Development", "4 months", 15000.0);

        course1.displayCourseDetails();
        course2.displayCourseDetails();

        Course.updateInstituteName("Global Tech Institute");
        Course.displayInstituteDetails();
    }
}

class Course {
    private String courseName;
    private String duration;
    private double fee;
    private static String instituteName = "Tech Academy";

    public Course(String courseName, String duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public void displayCourseDetails() {
        System.out.println("Course: " + courseName);
        System.out.println("Duration: " + duration);
        System.out.println("Fee: " + fee);
        System.out.println("Institute: " + instituteName);
    }

    public static void updateInstituteName(String name) {
        instituteName = name;
    }

    public static void displayInstituteDetails() {
        System.out.println("Institute Name: " + instituteName);
    }
}
