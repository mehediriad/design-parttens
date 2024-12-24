// Component
interface Coffee {
    int cost();
}

// ConcreteComponent
class BasicCoffee implements Coffee {
    @Override
    public int cost() {
        return 5; // Basic coffee cost
    }
}

// Decorator
abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public abstract int cost();
}

// Concrete Decorators
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public int cost() {
        return coffee.cost() + 2; // Adding milk cost
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public int cost() {
        return coffee.cost() + 1; // Adding sugar cost
    }
}

// Client Code
public class Main {
    public static void main(String[] args) {
        Coffee coffee = new BasicCoffee();
        System.out.println("Cost of basic coffee: " + coffee.cost()); // Output: 5

        coffee = new MilkDecorator(coffee);
        System.out.println("Cost of coffee with milk: " + coffee.cost()); // Output: 7

        coffee = new SugarDecorator(coffee);
        System.out.println("Cost of coffee with milk and sugar: " + coffee.cost()); // Output: 8
    }
}
