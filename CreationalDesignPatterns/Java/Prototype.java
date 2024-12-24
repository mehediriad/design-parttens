// Prototype
interface Prototype {
    Prototype clone();
}

// Concrete Prototype
class Shape implements Prototype {
    private String type;

    public Shape(String type) {
        this.type = type;
    }

    public void draw() {
        System.out.println("Drawing a " + type);
    }

    @Override
    public Prototype clone() {
        return new Shape(this.type);
    }
}

// Client Code
public class Main {
    public static void main(String[] args) {
        Shape circle = new Shape("Circle");
        circle.draw(); // Output: Drawing a Circle

        Shape clonedCircle = (Shape) circle.clone();
        clonedCircle.draw(); // Output: Drawing a Circle
    }
}
