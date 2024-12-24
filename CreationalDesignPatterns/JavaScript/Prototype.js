// Prototype
class Shape {
    constructor(type) {
        this.type = type;
    }

    clone() {
        return new Shape(this.type);
    }

    draw() {
        console.log(`Drawing a ${this.type}`);
    }
}

// Client Code
const circle = new Shape("Circle");
circle.draw(); // Output: Drawing a Circle

const clonedCircle = circle.clone();
clonedCircle.draw(); // Output: Drawing a Circle

