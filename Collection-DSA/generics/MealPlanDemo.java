package generics;
import java.util.*;

interface MealPlan {
    String getMealType();
}

class VegetarianMeal implements MealPlan {

    public String getMealType() {
        return "Vegetarian";
    }

    public String toString() {
        return getMealType();
    }
}

class VeganMeal implements MealPlan {

    public String getMealType() {
        return "Vegan";
    }

    public String toString() {
        return getMealType();
    }
}

class KetoMeal implements MealPlan {

    public String getMealType() {
        return "Keto";
    }

    public String toString() {
        return getMealType();
    }
}

class HighProteinMeal implements MealPlan {

    public String getMealType() {
        return "High Protein";
    }

    public String toString() {
        return getMealType();
    }
}

class Meal<T extends MealPlan> {

    String user;
    T plan;

    Meal(String user, T plan) {
        this.user = user;
        this.plan = plan;
    }

    void display() {
        System.out.println("User : " + user);
        System.out.println("Meal Plan : " + plan.getMealType());
    }
}

public class MealPlanDemo {

    static <T extends MealPlan> void generate(Meal<T> meal) {

        System.out.println("\nMeal Generated Successfully");
        meal.display();
    }

    public static void main(String[] args) {

        Meal<VegetarianMeal> m1 =
                new Meal<>("Kavya", new VegetarianMeal());

        Meal<VeganMeal> m2 =
                new Meal<>("Riya", new VeganMeal());

        Meal<KetoMeal> m3 =
                new Meal<>("Aman", new KetoMeal());

        Meal<HighProteinMeal> m4 =
                new Meal<>("Rahul", new HighProteinMeal());

        generate(m1);
        generate(m2);
        generate(m3);
        generate(m4);
    }
}