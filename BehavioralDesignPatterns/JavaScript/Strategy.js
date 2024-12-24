// Strategy Interface
class Strategy {
    execute(a, b) {
        throw new Error("This method must be overridden.");
    }
}

// ConcreteStrategy for Addition
class AddStrategy extends Strategy {
    execute(a, b) {
        return a + b;
    }
}

// ConcreteStrategy for Subtraction
class SubtractStrategy extends Strategy {
    execute(a, b) {
        return a - b;
    }
}

// ConcreteStrategy for Multiplication
class MultiplyStrategy extends Strategy {
    execute(a, b) {
        return a * b;
    }
}

// Context Class
class Calculator {
    constructor(strategy) {
        this.strategy = strategy;
    }

    setStrategy(strategy) {
        this.strategy = strategy;
    }

    executeStrategy(a, b) {
        return this.strategy.execute(a, b);
    }
}

// Client Code
const addStrategy = new AddStrategy();
const subtractStrategy = new SubtractStrategy();
const multiplyStrategy = new MultiplyStrategy();

const calculator = new Calculator(addStrategy);
console.log(calculator.executeStrategy(5, 3));  // Output: 8

calculator.setStrategy(subtractStrategy);
console.log(calculator.executeStrategy(5, 3));  // Output: 2

calculator.setStrategy(multiplyStrategy);
console.log(calculator.executeStrategy(5, 3));  // Output: 15
