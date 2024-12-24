// Implementor
interface DrawingAPI {
    void drawCircle(int x, int y, int radius);
}

// Concrete Implementor 1
class DrawingAPI1 implements DrawingAPI {
    public void drawCircle(int x, int y, int radius) {
        System.out.println("Drawing circle using API1 at (" + x + ", " + y + ") with radius " + radius);
    }
}

// Concrete Implementor 2
class DrawingAPI2 implements DrawingAPI {
    public void drawCircle(int x, int y, int radius) {
        System.out.println("Drawing circle using API2 at (" + x + ", " + y + ") with radius " + radius);
    }
}

// Abstraction
abstract class Shape {
    protected DrawingAPI drawingAPI;

    public Shape(DrawingAPI drawingAPI) {
        this.drawingAPI = drawingAPI;
    }

    public abstract void draw();
}

// Refined Abstraction
class Circle extends Shape {
    private int x, y, radius;

    public Circle(DrawingAPI drawingAPI, int x, int y, int radius) {
        super(drawingAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawingAPI.drawCircle(x, y, radius);
    }
}

// Client Code
public class Main {
    public static void main(String[] args) {
        DrawingAPI api1 = new DrawingAPI1();
        DrawingAPI api2 = new DrawingAPI2();

        Shape circle1 = new Circle(api1, 5, 10, 20);
        circle1.draw(); // Output: Drawing circle using API1 at (5, 10) with radius 20

        Shape circle2 = new Circle(api2, 15, 25, 30);
        circle2.draw(); // Output: Drawing circle using API2 at (15, 25) with radius 30
    }
}
