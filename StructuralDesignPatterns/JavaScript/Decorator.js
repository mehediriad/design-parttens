// Component
class Coffee {
    cost() {
        return 5; // Basic coffee cost
    }
}

// Decorator
class CoffeeDecorator {
    constructor(coffee) {
        this.coffee = coffee;
    }

    cost() {
        return this.coffee.cost();
    }
}

// Concrete Decorators
class MilkDecorator extends CoffeeDecorator {
    cost() {
        return this.coffee.cost() + 2; // Adding milk cost
    }
}

class SugarDecorator extends CoffeeDecorator {
    cost() {
        return this.coffee.cost() + 1; // Adding sugar cost
    }
}

// Client Code
let coffee = new Coffee();
console.log("Cost of basic coffee: " + coffee.cost()); // Output: 5

coffee = new MilkDecorator(coffee);
console.log("Cost of coffee with milk: " + coffee.cost()); // Output: 7

coffee = new SugarDecorator(coffee);
console.log("Cost of coffee with milk and sugar: " + coffee.cost()); // Output: 8
