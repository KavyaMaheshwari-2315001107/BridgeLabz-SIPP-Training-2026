import java.util.*;

class Pair<T, U> {

    T first;
    U second;

    Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    void display() {
        System.out.println(first + " " + second);
    }
}

class Stack<T> {

    ArrayList<T> list = new ArrayList<>();

    void push(T x) {
        list.add(x);
    }

    void pop() {

        if (list.isEmpty()) {
            System.out.println("Stack Empty");
            return;
        }

        System.out.println("Removed : " + list.remove(list.size() - 1));
    }

    void peek() {

        if (list.isEmpty()) {
            System.out.println("Stack Empty");
            return;
        }

        System.out.println("Top : " + list.get(list.size() - 1));
    }

    void display() {

        if (list.isEmpty()) {
            System.out.println("Stack Empty");
            return;
        }

        System.out.println(list);
    }
}

class Repository<T> {

    ArrayList<T> list = new ArrayList<>();

    void add(T obj) {
        list.add(obj);
    }

    void show() {

        for (T x : list)
            System.out.println(x);
    }
}

class Student {

    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return id + " " + name;
    }
}

public class GenericDemo {

    static <T extends Comparable<T>> T findMax(T arr[]) {

        T max = arr[0];

        for (T x : arr) {

            if (x.compareTo(max) > 0)
                max = x;
        }

        return max;
    }

    static void print(List<?> list) {

        for (Object x : list)
            System.out.println(x);
    }

    public static void main(String[] args) {

        Pair<String, Integer> p = new Pair<>("Laptop", 50000);
        p.display();

        Stack<Integer> st = new Stack<>();

        st.push(10);
        st.push(20);
        st.push(30);

        st.display();
        st.peek();
        st.pop();
        st.display();

        Integer arr[] = {12, 45, 67, 23, 89};

        System.out.println("Maximum = " + findMax(arr));

        Repository<Student> r = new Repository<>();

        r.add(new Student(101, "Kavya"));
        r.add(new Student(102, "Riya"));

        System.out.println("\nStudents");
        r.show();

        List<String> name = new ArrayList<>();

        name.add("Aman");
        name.add("Neha");
        name.add("Rohit");

        System.out.println("\nWildcard Output");
        print(name);
    }
}