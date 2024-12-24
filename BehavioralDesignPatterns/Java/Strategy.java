// Strategy Interface
interface Strategy {
    int execute(int a, int b);
}

// ConcreteStrategy for Addition
class AddStrategy implements Strategy {
    public int execute(int a, int b) {
        return a + b;
    }
}

// ConcreteStrategy for Subtraction
class SubtractStrategy implements Strategy {
    public int execute(int a, int b) {
        return a - b;
    }
}

// ConcreteStrategy for Multiplication
class MultiplyStrategy implements Strategy {
    public int execute(int a, int b) {
        return a * b;
    }
}

// Context Class
class Calculator {
    private Strategy strategy;

    public Calculator(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int a, int b) {
        return strategy.execute(a, b);
    }
}

// Client Code
public class Main {
    public static void main(String[] args) {
        Strategy addStrategy = new AddStrategy();
        Strategy subtractStrategy = new SubtractStrategy();
        Strategy multiplyStrategy = new MultiplyStrategy();

        Calculator calculator = new Calculator(addStrategy);
        System.out.println(calculator.executeStrategy(5, 3));  // Output: 8

        calculator.setStrategy(subtractStrategy);
        System.out.println(calculator.executeStrategy(5, 3));  // Output: 2

        calculator.setStrategy(multiplyStrategy);
        System.out.println(calculator.executeStrategy(5, 3));  // Output: 15
    }
}
