// Product ইন্টারফেস
class Shape {
    draw() {
        throw new Error("This method should be overridden!");
    }
}

// Concrete Product
class Circle extends Shape {
    draw() {
        console.log("Drawing a Circle");
    }
}

class Rectangle extends Shape {
    draw() {
        console.log("Drawing a Rectangle");
    }
}

// Creator
class ShapeFactory {
    static createShape(type) {
        if (type === "circle") {
            return new Circle();
        } else if (type === "rectangle") {
            return new Rectangle();
        } else {
            throw new Error("Invalid shape type");
        }
    }
}

// ক্লায়েন্ট কোড
const circle = ShapeFactory.createShape("circle");
circle.draw(); // Output: Drawing a Circle

const rectangle = ShapeFactory.createShape("rectangle");
rectangle.draw(); // Output: Drawing a Rectangle
