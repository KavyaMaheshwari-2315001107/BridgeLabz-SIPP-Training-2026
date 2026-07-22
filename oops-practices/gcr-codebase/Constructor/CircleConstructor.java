public class CircleConstructor {
    public static void main(String[] args) {
        Circle circleDefault = new Circle();
        Circle circleCustom = new Circle(10.5);

        circleDefault.displayRadius();
        circleCustom.displayRadius();
    }
}

class Circle {
    private double radius;

    public Circle() {
        this(5.0);
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void displayRadius() {
        System.out.println("Circle radius: " + radius);
    }
}
