import java.util.*;

class Employee {

    int id;
    int attendance;

    Employee(int id, int attendance) {
        this.id = id;
        this.attendance = attendance;
    }
}

public class AttendanceRanking{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number of Employees : ");
        int n = sc.nextInt();

        int id[] = new int[n];
        int att[] = new int[n];

        System.out.println("Enter Employee IDs");

        for (int i = 0; i < n; i++)
            id[i] = sc.nextInt();

        System.out.println("Enter Attendance");

        for (int i = 0; i < n; i++)
            att[i] = sc.nextInt();

        System.out.print("Enter K : ");
        int k = sc.nextInt();

        Employee arr[] = new Employee[n];

        for (int i = 0; i < n; i++)
            arr[i] = new Employee(id[i], att[i]);

        Arrays.sort(arr, (a, b) -> {

            if (a.attendance == b.attendance)
                return a.id - b.id;

            return b.attendance - a.attendance;
        });

        System.out.println("Top Employees");

        for (int i = 0; i < k; i++)
            System.out.print(arr[i].id + " ");
    }
}