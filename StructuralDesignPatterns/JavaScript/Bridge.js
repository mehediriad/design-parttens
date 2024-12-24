// Implementor
class DrawingAPI {
    drawCircle(x, y, radius) {
        throw new Error("This method should be overridden!");
    }
}

// Concrete Implementor 1
class DrawingAPI1 extends DrawingAPI {
    drawCircle(x, y, radius) {
        console.log(`Drawing circle using API1 at (${x}, ${y}) with radius ${radius}`);
    }
}

// Concrete Implementor 2
class DrawingAPI2 extends DrawingAPI {
    drawCircle(x, y, radius) {
        console.log(`Drawing circle using API2 at (${x}, ${y}) with radius ${radius}`);
    }
}

// Abstraction
class Shape {
    constructor(drawingAPI) {
        this.drawingAPI = drawingAPI;
    }

    draw() {
        throw new Error("This method should be overridden!");
    }
}

// Refined Abstraction
class Circle extends Shape {
    constructor(drawingAPI, x, y, radius) {
        super(drawingAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    draw() {
        this.drawingAPI.drawCircle(this.x, this.y, this.radius);
    }
}

// Client Code
const api1 = new DrawingAPI1();
const api2 = new DrawingAPI2();

const circle1 = new Circle(api1, 5, 10, 20);
circle1.draw(); // Output: Drawing circle using API1 at (5, 10) with radius 20

const circle2 = new Circle(api2, 15, 25, 30);
circle2.draw(); // Output: Drawing circle using API2 at (15, 25) with radius 30
