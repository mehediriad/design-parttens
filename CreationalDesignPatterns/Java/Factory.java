// Product ইন্টারফেস
interface Shape {
    void draw();
}

// Concrete Product
class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Rectangle implements Shape {
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

// Creator
abstract class ShapeFactory {
    public abstract Shape createShape();
}

// Concrete Creator
class CircleFactory extends ShapeFactory {
    public Shape createShape() {
        return new Circle();
    }
}

class RectangleFactory extends ShapeFactory {
    public Shape createShape() {
        return new Rectangle();
    }
}

// ক্লায়েন্ট কোড
public class Main {
    public static void main(String[] args) {
        ShapeFactory circleFactory = new CircleFactory();
        Shape circle = circleFactory.createShape();
        circle.draw(); // Output: Drawing a Circle

        ShapeFactory rectangleFactory = new RectangleFactory();
        Shape rectangle = rectangleFactory.createShape();
        rectangle.draw(); // Output: Drawing a Rectangle
    }
}
