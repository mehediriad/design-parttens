// Abstract Class with Template Method
abstract class Meal {
    // Template Method
    public final void prepareMeal() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    public void boilWater() {
        System.out.println("Boiling water...");
    }

    public void pourInCup() {
        System.out.println("Pouring into cup...");
    }

    // Abstract Methods to be implemented by subclasses
    public abstract void brew();
    public abstract void addCondiments();
}

// Concrete Class 1
class Tea extends Meal {
    public void brew() {
        System.out.println("Steeping the tea...");
    }

    public void addCondiments() {
        System.out.println("Adding lemon...");
    }
}

// Concrete Class 2
class Coffee extends Meal {
    public void brew() {
        System.out.println("Dripping coffee through filter...");
    }

    public void addCondiments() {
        System.out.println("Adding sugar and milk...");
    }
}

// Client Code
public class Main {
    public static void main(String[] args) {
        Meal tea = new Tea();
        tea.prepareMeal();
        // Output:
        // Boiling water...
        // Steeping the tea...
        // Pouring into cup...
        // Adding lemon...

        Meal coffee = new Coffee();
        coffee.prepareMeal();
        // Output:
        // Boiling water...
        // Dripping coffee through filter...
        // Pouring into cup...
        // Adding sugar and milk...
    }
}
