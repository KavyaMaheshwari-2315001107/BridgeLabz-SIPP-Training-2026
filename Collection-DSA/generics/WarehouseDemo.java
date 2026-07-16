import java.util.*;

abstract class WarehouseItem {

    String id;
    String name;

    WarehouseItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "ID : " + id + "  Name : " + name;
    }
}

class Electronics extends WarehouseItem {

    Electronics(String id, String name) {
        super(id, name);
    }
}

class Grocery extends WarehouseItem {

    Grocery(String id, String name) {
        super(id, name);
    }
}

class Furniture extends WarehouseItem {

    Furniture(String id, String name) {
        super(id, name);
    }
}

class Storage<T extends WarehouseItem> {

    ArrayList<T> list = new ArrayList<>();

    void add(T item) {
        list.add(item);
        System.out.println("Item Added.");
    }

    void display() {

        if (list.isEmpty()) {
            System.out.println("Storage Empty.");
            return;
        }

        for (T x : list)
            System.out.println(x);
    }

    ArrayList<T> getItems() {
        return list;
    }
}

public class WarehouseDemo {

    static void show(List<? extends WarehouseItem> list) {

        System.out.println("\nItems");

        for (WarehouseItem x : list)
            System.out.println(x);
    }

    public static void main(String[] args) {

        Storage<Electronics> e = new Storage<>();
        Storage<Grocery> g = new Storage<>();
        Storage<Furniture> f = new Storage<>();

        e.add(new Electronics("E101", "Laptop"));
        e.add(new Electronics("E102", "Mobile"));

        g.add(new Grocery("G101", "Rice"));
        g.add(new Grocery("G102", "Sugar"));

        f.add(new Furniture("F101", "Chair"));
        f.add(new Furniture("F102", "Table"));

        System.out.println("\nElectronics");
        e.display();

        System.out.println("\nGroceries");
        g.display();

        System.out.println("\nFurniture");
        f.display();

        show(e.getItems());
        show(g.getItems());
        show(f.getItems());
    }
}