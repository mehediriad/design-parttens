// Abstract Class with Template Method
class Meal {
    prepareMeal() {
        this.boilWater();
        this.brew();
        this.pourInCup();
        this.addCondiments();
    }

    boilWater() {
        console.log("Boiling water...");
    }

    pourInCup() {
        console.log("Pouring into cup...");
    }

    // Abstract Methods to be implemented by subclasses
    brew() {
        throw new Error("This method must be overridden.");
    }

    addCondiments() {
        throw new Error("This method must be overridden.");
    }
}

// Concrete Class 1
class Tea extends Meal {
    brew() {
        console.log("Steeping the tea...");
    }

    addCondiments() {
        console.log("Adding lemon...");
    }
}

// Concrete Class 2
class Coffee extends Meal {
    brew() {
        console.log("Dripping coffee through filter...");
    }

    addCondiments() {
        console.log("Adding sugar and milk...");
    }
}

// Client Code
const tea = new Tea();
tea.prepareMeal();
// Output:
// Boiling water...
// Steeping the tea...
// Pouring into cup...
// Adding lemon...

const coffee = new Coffee();
coffee.prepareMeal();
// Output:
// Boiling water...
// Dripping coffee through filter...
// Pouring into cup...
// Adding sugar and milk...
